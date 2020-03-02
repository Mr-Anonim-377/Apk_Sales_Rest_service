package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.Sales.SalesWeb.config.ControllerConfig.PAGE_SIZE;

@Service
public class SearchService {

    private final ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> searchOnProductName(String searchString, int page) {
        try {
            Pageable pageable = PageRequest.of(page, PAGE_SIZE);
            return productRepository.findByNameProductContains(searchString, pageable);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
    }

    public Page<Product> searchOnProductProperties(String searchString, int page) {
        try {
            Pageable pageable = PageRequest.of(page, PAGE_SIZE);
            return productRepository.findByPropertiesContains(searchString, pageable);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
    }

    public Page<Product> searchOnProductDescription(String searchString, int page) {
        try {
            Pageable pageable = PageRequest.of(page, PAGE_SIZE);
            return productRepository.findByProductDescriptionContains(searchString, pageable);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
    }

    public Page<Product> searchOnNameProductOrPropertiesOrProductDescription(String searchString, int page) {
        try {
            Pageable pageable = PageRequest.of(page, PAGE_SIZE);
            return productRepository.findByNameProductOrPropertiesOrProductDescriptionContains(searchString, searchString, searchString, pageable);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
    }


}
