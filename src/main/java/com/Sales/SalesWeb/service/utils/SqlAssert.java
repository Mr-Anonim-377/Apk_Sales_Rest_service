package com.Sales.SalesWeb.service.utils;

import com.Sales.SalesWeb.controller.exception.NoSuchObjects;

import java.util.List;
import java.util.function.Predicate;

public class SqlAssert {

    public static Predicate isEmpty() {
        return i -> ((List<Object>) i).isEmpty();
    }

    public static void listAssert(List list, Predicate predicate) {
        if (predicate.test(list)) {
            throw new NoSuchObjects();
        }
    }

    public static void listAssert(List list, Predicate predicate, RuntimeException e) {
        if (predicate.test(list)) {
            throw e;
        }
    }
}
