package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.model.DTO.CollectionDto;
import com.Sales.SalesWeb.model.response.entity.PriceBetween;
import com.Sales.SalesWeb.model.response.entity.SimpleDbEntity;
import com.Sales.SalesWeb.service.CollectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "collections/", produces = MediaType.APPLICATION_JSON_VALUE)
public class CollectionController extends AbstractController {
    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCollection(@PathVariable Integer id) {
        CollectionDto collection = collectionService.getCollect(id);
        nullAssert(collection);
        return new ResponseEntity<>(collection, HttpStatus.OK);
    }

    @GetMapping(value = "get/getPriceBetween/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMaxAndMinPrice(@RequestParam int collectionId) {
        PriceBetween priceBetween = collectionService.getPriceBetween(collectionId);
        nullAssert(priceBetween);
        return new ResponseEntity<>(priceBetween, HttpStatus.OK);
    }

    @GetMapping(value = "get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCollection() {
        List<CollectionDto> collections = collectionService.getAllCollect();
        nullAssert(collections);
        return new ResponseEntity<>(collections, HttpStatus.OK);
    }

    @GetMapping(value = "get/all/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCollectionsByCategoryIdOfProduct(@RequestParam int categoryId) {
        List<SimpleDbEntity<Integer, String>> collections =
                collectionService.getCollectionsByCategoryIdOfProduct(categoryId);
        nullAssert(collections);
        return new ResponseEntity<>(collections, HttpStatus.OK);
    }
}