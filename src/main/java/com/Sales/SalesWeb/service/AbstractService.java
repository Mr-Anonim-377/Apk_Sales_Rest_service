package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.service.utils.ObjectUtils;
import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.concurrent.Callable;

public abstract class AbstractService extends ObjectUtils {

    @FunctionalInterface
    public interface CheckedErrorFunction<T, R> {
        R apply(T t) throws Exception;
    }

    @FunctionalInterface
    public interface CheckedErrorSupplier<R> {
        R get() throws Exception;
    }

    @FunctionalInterface
    public interface CheckedErrorConsumer<T> {
        void accept(T t) throws Exception;
    }

    public class CustomError extends RuntimeException {

        public CustomError(String message) {
            super(message);
        }
    }

    protected <T, R> R applyHibernateQuery(T t, CheckedErrorFunction<T, R> function) {
        return applyByException(t, function,
                ImmutableMap.of(new RuntimeException(), new InternalDataBaseServerExeption()));
    }

    protected <R> R applyHibernateQuery(CheckedErrorSupplier<R> function) {
        return applyByException(function,
                ImmutableMap.of(new RuntimeException(), new InternalDataBaseServerExeption()));
    }

    protected <T> void applyHibernateQuery(T t, CheckedErrorConsumer<T> consumer) {
        applyByException(t, consumer, ImmutableMap.of(new RuntimeException(), new InternalDataBaseServerExeption()));
    }

    @Deprecated
    protected <R> R applyHibernateQuery(Callable<R> function) {
        R applyResult = null;
        try {
            applyResult = function.call();
        } catch (Throwable e) {
            throwCustomException(e, ImmutableMap.of(new RuntimeException(), new InternalDataBaseServerExeption()));
        }
        return applyResult;
    }

    protected <R> R applyByException(CheckedErrorSupplier<R> function,
                                  Map<? extends Throwable, ? extends ApiException> exceptionFields) {
        R applyResult = null;
        try {
            applyResult = function.get();
        } catch (Throwable e) {
            throwCustomException(e, exceptionFields);
        }
        return applyResult;
    }

    protected <T, R> R applyByException(T t, CheckedErrorFunction<T, R> function,
                                     Map<? extends Throwable, ? extends ApiException> exceptionFields) {
        R applyResult = null;
        try {
            applyResult = function.apply(t);
        } catch (Throwable e) {
            throwCustomException(e, exceptionFields);
        }
        return applyResult;
    }

    protected <T> void applyByException(T t, CheckedErrorConsumer<T> consumer,
                                     Map<? extends Throwable, ? extends ApiException> exceptionFields) {
        try {
            consumer.accept(t);
        } catch (Throwable e) {
            throwCustomException(e, exceptionFields);
        }
    }

    private <T extends Throwable> void throwCustomException(
            T exception, Map<? extends Throwable, ? extends ApiException> exceptionFields) {
        try {
            Class<? extends Throwable> exceptionClass = exception.getClass();
            for (Map.Entry<? extends Throwable, ? extends ApiException> entry : exceptionFields.entrySet()) {
                if (entry.getKey().getClass() == exceptionClass) {
                    exception.printStackTrace();
                    throw entry.getValue();
                }
            }
            throw exception;
        } catch (Throwable t) {
            t.printStackTrace();
            throw new CustomError(t.getMessage());
        }
    }
}