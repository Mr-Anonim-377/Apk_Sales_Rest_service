package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.NoSuchObjects;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.service.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "search", produces = MediaType.APPLICATION_JSON_VALUE)
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }


    @GetMapping(value = "/onProductsName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchOnProduct(@RequestParam String name, @RequestParam int page) {
        if(name.length()<=3){
            throw new ApiException("The search string is less than or equal to 3  -_-",
                    "name.length()<=3",
                    ExceptionType.WrongSearchString);
        }
        Page<Product> products = searchService.searchOnProductName(name, page);
        if(products.isEmpty()){
            throw new NoSuchObjects();
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
