package com.Sales.SalesWeb.service.utils;

import com.Sales.SalesWeb.controller.exception.ApiException;

import java.util.List;
import java.util.function.Predicate;

public interface ObjectAssertUtils {
    Predicate isEmpty();

    void listAssert(List list, Predicate predicate);

    void listAssert(List list, Predicate predicate, ApiException e);
}
