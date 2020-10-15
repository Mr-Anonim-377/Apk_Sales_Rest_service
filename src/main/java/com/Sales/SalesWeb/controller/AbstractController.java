package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.NoSuchObjects;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.service.utils.ObjectUtils;

public abstract class AbstractController extends ObjectUtils {

    protected <T> void nullAssert(T t) {
        if (t == null) {
            throw new NoSuchObjects();
        }
    }

    protected <T> void nullAssert(String message, T t) {
        try {
            nullAssert(t);
        } catch (NoSuchObjects e) {
            throw new ApiException(message,
                    "<search's Object> == null",
                    ExceptionType.NoSuchObj);
        }
    }

    protected <T> void nullAssert(ApiException apiException, T t) {
        if (t == null) {
            throw apiException;
        }
    }

}