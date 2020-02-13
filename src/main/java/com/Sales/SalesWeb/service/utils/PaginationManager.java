package com.Sales.SalesWeb.service.utils;

import com.Sales.SalesWeb.repository.ProductRepository;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
@Data
public class PaginationManager<T, R> {
    private R repository;
    private JpaRepository repository_1;
    private ProductRepository productRepository;
    private List<T> content;
    private int page;
    private int size;
    private Sort sort;
    private Predicate<T> filter;
    private Pageable pageable;

    public PaginationManager(int page, int size, R repository,JpaRepository repository_1,ProductRepository productRepository) {
        this.page = page;
        this.size = size;
        this.repository = repository;
        this.repository_1 = repository_1;
        this.productRepository = productRepository;
        this.pageable = PageRequest.of(page, size);
    }

    public PaginationManager(int page, int size, R repository, Sort sort) {
        this.page = page;
        this.size = size;
        this.repository = repository;
        this.pageable = PageRequest.of(page, size);
        this.sort = sort;
    }

    public PaginationManager(int page, int size, R repository, Predicate filter) {
        this.page = page;
        this.size = size;
        this.repository = repository;
        this.pageable = PageRequest.of(page, size);
        this.filter = filter;
    }

    public void defoltPagination(List<Object> sqlQueryParams, String nameQueryMethod) {
        sqlQueryParams.add(pageable);
        List<Class> queryMethodArgsList = new ArrayList<>();
        for (Object o : sqlQueryParams) {
            queryMethodArgsList.add(o.getClass());
        }
        Class[] queryMethodArgs = queryMethodArgsList.toArray(new Class[0]);
        try {
            Method queryMethod = repository.getClass().getDeclaredMethod(nameQueryMethod, queryMethodArgs);
            Page<T> page = (Page<T>) queryMethod.invoke(repository, sqlQueryParams.toArray());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
