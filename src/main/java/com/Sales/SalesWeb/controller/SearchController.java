package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.service.SearchService;
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
        return new ResponseEntity<>(searchService.searchOnProductName(name,page), HttpStatus.OK);
    }

}
