package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.controller.exception.NoSuchObjects;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.model.DTO.CategoryDto;
import com.Sales.SalesWeb.model.POJO.Navigation;
import com.Sales.SalesWeb.model.POJO.PriceBetween;
import com.Sales.SalesWeb.service.CategoriesService;
import com.Sales.SalesWeb.service.CollectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriesController {
    private final CategoriesService categoriesService;
    private CollectionService collectionService;

    public CategoriesController(CategoriesService categoriesService, CollectionService collectionService) {
        this.categoriesService = categoriesService;
        this.collectionService = collectionService;
    }


    @GetMapping(value = "navigation",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllNavigationCategories() {
        Navigation navigationCategories = categoriesService.getAllNavigationCategories();
        if (navigationCategories == null) {
            throw new ApiException("No search Navigation in db :(",
                    "navigationCategories == null",
                    ExceptionType.NoSuchObj);
        }
        return new ResponseEntity<>(navigationCategories, HttpStatus.OK);
    }

    @GetMapping(value = "category/all/byProductOfCollection", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCollectionsByProductOfCollection(@RequestParam int collectionId) {
        List<Map<Integer,String>> collections;
        try {
            collections = categoriesService.getCollectionsByProductOfCategory(collectionId);
            if (collections.isEmpty()) {
                throw new NoSuchObjects();
            }
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return new ResponseEntity<>(collections, HttpStatus.OK);
    }

    @GetMapping(value = "category/all/getPriceBetween", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMaxAndMinPrice(@RequestParam int categoryId) {
        PriceBetween priceBetween = collectionService.getPriceBtween(categoryId, "Category");
        return new ResponseEntity<>(priceBetween,HttpStatus.OK);
    }

    @GetMapping(value = "category/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCategory() {
        List<CategoryDto> collections;
        try {
            collections = categoriesService.getAllCollect();
            if (collections.isEmpty()) {
                throw new NoSuchObjects();
            }
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return new ResponseEntity<>(collections, HttpStatus.OK);
    }


}
