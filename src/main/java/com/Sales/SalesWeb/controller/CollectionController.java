package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.controller.exception.NoSuchObject;
import com.Sales.SalesWeb.controller.exception.NoSuchObjects;
import com.Sales.SalesWeb.model.DTO.CollectionDto;
import com.Sales.SalesWeb.model.POJO.PriceBetween;
import com.Sales.SalesWeb.service.CollectionService;
import com.Sales.SalesWeb.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "collection", produces = MediaType.APPLICATION_JSON_VALUE)
public class CollectionController {
    private final CollectionService collectionService;
    private final ProductsService productsService;

    public CollectionController(ProductsService productsService, CollectionService collectionService) {
        this.collectionService = collectionService;
        this.productsService = productsService;
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCollection(@PathVariable Integer id) {
        CollectionDto collection = collectionService.getCollect(id);
        if (collection == null) {
            throw new NoSuchObject();
        }
        return new ResponseEntity<>(collection, HttpStatus.OK);
    }

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCollection() {
        List<CollectionDto> collections;
        try {
            collections = collectionService.getAllCollect();
            if (collections.isEmpty()) {
                throw new NoSuchObjects();
            }
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return new ResponseEntity<>(collections, HttpStatus.OK);
    }

    @GetMapping(value = "all/getPriceBetween", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMaxAndMinPrice(@RequestParam int collectionId) {
        PriceBetween priceBetween = collectionService.getPriceBtween(collectionId, "Collection");
        return new ResponseEntity<>(priceBetween,HttpStatus.OK);
    }


    @GetMapping(value = "all/byProductOfCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCollectionsByProductOfCategory(@RequestParam int categoryId) {
        List<Map<Integer,String>> collections;
        try {
            collections = collectionService.getCollectionsByProductOfCategory(categoryId);
            if (collections.isEmpty()) {
                throw new NoSuchObjects();
            }
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return new ResponseEntity<>(collections, HttpStatus.OK);
    }
}
