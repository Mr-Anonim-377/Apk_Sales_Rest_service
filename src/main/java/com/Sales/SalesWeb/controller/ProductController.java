package com.Sales.SalesWeb.controller;


import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.NoSuchObject;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.model.POJO.FavoriteCategoryProductsResponse;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.service.ProductsService;
import com.google.common.collect.ImmutableMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    private final ProductsService productsService;

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductsOnCategpry(@RequestParam Integer id,
                                                @RequestParam(required = false) BigDecimal minPrice,
                                                @RequestParam(required = false) BigDecimal maxPrice,
                                                @RequestParam(required = false) Integer collectionId,
                                                @RequestParam int page) {
        List<Object> products = productsService.getProductWithCollectionId(ImmutableMap.of("price", Arrays.asList(minPrice, maxPrice)), page, ImmutableMap.of("collectionId",
                collectionId, "productCategoryId", id));
        if (products == null || products.isEmpty()) {
            throw new NoSuchObject();
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProduct(@PathVariable UUID id) {
        Product product = productsService.getProduct(id);
        if (product == null) {
            throw new NoSuchObject();
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createProduct(@RequestBody Product product) {
        Product newProduct = productsService.createProduct(product);
        if (newProduct == null) {
            throw new ApiException("Don't save product in db :(", "newProduct ==null", ExceptionType.SaveInDbException);
        }
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProduct(@PathVariable("id") Product product) {
        if (!productsService.deleteProduct(product)) {
            throw new ApiException("Don't delete product :(", "productsService.deleteProduct(product) == null",
                    ExceptionType.DeleteInDbException);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProduct(@PathVariable("id") Product productFromDb, @RequestBody Product productFromReqest) {
        Map<String, Product> stringProductMap = productsService.updateProduct(productFromDb, productFromReqest);
        if (stringProductMap.isEmpty()) {
            throw new ApiException("Don't update product :(", "productsService.deleteProduct(product) == null",
                    ExceptionType.UpdateInDbException);
        }
        return new ResponseEntity<>(stringProductMap, HttpStatus.OK);
    }

    @PostMapping(value = "/favorites", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getFavoriteCategoriesFavoriteProdcuts(@RequestParam Integer countFavoriteCategries) {
        List<FavoriteCategoryProductsResponse> favoriteCategoriesFavoriteProdcuts = productsService
                .getFavoriteCategoriesFavoriteProdcuts(countFavoriteCategries);
        if (favoriteCategoriesFavoriteProdcuts.isEmpty()) {
            throw new ApiException("FavoriteCategories have't in db :(",
                    "favoriteCategoriesFavoriteProdcuts.isEmpty()",
                    ExceptionType.NoSuchObjs);
        }
        return new ResponseEntity<>(favoriteCategoriesFavoriteProdcuts, HttpStatus.OK);
    }

}
