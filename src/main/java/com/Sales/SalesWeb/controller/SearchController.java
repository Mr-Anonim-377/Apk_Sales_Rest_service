package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.controller.enums.SearchType;
import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.NoSuchObjects;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.service.SearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "search", produces = MediaType.APPLICATION_JSON_VALUE)
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }


    @GetMapping(value = "/onProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchOnProduct(@RequestParam String searchString, @RequestParam() SearchType searchType, @RequestParam int page) {
        if (searchString.length() <= 3) {
            throw new ApiException("The search string is less than or equal to 3  -_-",
                    "name.length()<=3",
                    ExceptionType.WrongSearchString);
        }
        List<Product> products;
        switch (searchType) {
            case ON_PRODUCT_NAME:
                products = searchService.searchOnProductName(searchString, page).toList();
            case ON_PRODUCT_PROPERTIES:
                products = searchService.searchOnProductProperties(searchString, page).toList();
            case ON_PRODUCT_DESCRIPTION:
                products = searchService.searchOnProductDescription(searchString, page).toList();
            default:
                products = searchService.searchOnNameProductOrPropertiesOrProductDescription(searchString, page)
                        .toList();
        }
        if (products.isEmpty()) {
            throw new NoSuchObjects();
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
