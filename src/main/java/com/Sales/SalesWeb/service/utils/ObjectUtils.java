package com.Sales.SalesWeb.service.utils;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.NoSuchObjects;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ObjectUtils implements ObjectAssertUtils {
    public Predicate isEmpty() {
        return i -> ((List<Object>) i).isEmpty();
    }

    protected <T> void objectAssert(ApiException apiException, T actual, T expected) {
        if (!actual.equals(expected)) {
            throw apiException;
        }
    }

    protected <T> void objectAssert(ApiException apiException, Predicate<T> predicate,T t) {
        if (predicate.test(t)) {
            throw apiException;
        }
    }

    protected <T, R> void objectAssert(ApiException apiException, BiPredicate<T, R> predicate, T actual, R expected) {
        if (predicate.test(actual,expected)) {
            throw apiException;
        }
    }

    public void listAssert(List list, Predicate predicate) {
        if (predicate.test(list)) {
            throw new NoSuchObjects();
        }
    }

    public void listAssert(List list, Predicate predicate, ApiException e) {
        if (predicate.test(list)) {
            throw e;
        }
    }
}