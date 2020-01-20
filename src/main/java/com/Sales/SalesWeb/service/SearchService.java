package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.model.Collection;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.repository.CollectionRepository;
import com.Sales.SalesWeb.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SearchService {
    private final ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Page<Product> searchOnProductName(String name){
        Pageable pageable = PageRequest.of(0, 20);
        return productRepository.findByNameProductContains(name,pageable);
    }


}
