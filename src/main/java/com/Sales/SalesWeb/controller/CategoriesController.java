package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.model.POJO.Navigation;
import com.Sales.SalesWeb.service.CategoriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "navigation", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriesController {
    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }


    @GetMapping(value = "/Navigation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllNavigationCategories() {
        Navigation navigationCategories = categoriesService.getAllNavigationCategories();
        if (navigationCategories == null) {
            throw new ApiException("No search Navigation in db :(",
                    "navigationCategories == null",
                    ExceptionType.NoSuchObj);
        }
        return new ResponseEntity<>(navigationCategories, HttpStatus.OK);
    }

}
