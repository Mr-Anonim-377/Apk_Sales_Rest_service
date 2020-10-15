package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.model.DTO.CategoryDto;
import com.Sales.SalesWeb.model.response.entity.PriceBetween;
import com.Sales.SalesWeb.model.response.entity.ResponseNavigationEntity;
import com.Sales.SalesWeb.model.response.entity.SimpleDbEntity;
import com.Sales.SalesWeb.service.CategoriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "categories/", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriesController extends AbstractController {
    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping(value = "navigation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllNavigationCategories() {
        ResponseNavigationEntity responseNavigationCategories = categoriesService.getAllNavigationCategories();
        nullAssert("No search Navigation in db :(", responseNavigationCategories);
        return new ResponseEntity<>(responseNavigationCategories, HttpStatus.OK);
    }

    @GetMapping(value = "get/getPriceBetween/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMaxAndMinPrice(@RequestParam int categoryId) {
        PriceBetween priceBetween = categoriesService.getPriceBetween(categoryId);
        nullAssert(priceBetween);
        return new ResponseEntity<>(priceBetween, HttpStatus.OK);
    }

    @GetMapping(value = "get/all/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCategoriesByCollectionIdOfProduct(@RequestParam int collectionId) {
        List<SimpleDbEntity<Integer, String>> categories =
                categoriesService.getCategoriesByCollectionIdOfProduct(collectionId);
        nullAssert(categories);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping(value = "get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCategory() {
        List<CategoryDto> collections = categoriesService.getAllCollect();
        nullAssert(collections);
        return new ResponseEntity<>(collections, HttpStatus.OK);
    }
}