package com.Sales.SalesWeb.controller;


import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.NoSuchObject;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.model.DTO.ProductDto;
import com.Sales.SalesWeb.model.POJO.FavoriteCategoryProductsResponse;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

import static com.Sales.SalesWeb.service.utils.SqlAssert.isEmpty;
import static com.Sales.SalesWeb.service.utils.SqlAssert.listAssert;

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
        Map<String, List<BigDecimal>> between = new HashMap<>();
        if (minPrice != null || maxPrice != null) {
            between.put("price", Arrays.asList(minPrice, maxPrice));
        }
        Map<String, Object> equals = new HashMap<>();
        if (collectionId != null) {
            equals.put("collectionId",
                    collectionId);
        }
        equals.put("productCategoryId", id);

        List<Object> products = productsService.getProductWithCollectionId(between, page, equals);
        if (products == null || products.isEmpty()) {
            throw new NoSuchObject();
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProduct(@PathVariable UUID id) {
        ProductDto product = productsService.getProduct(id);
        if (product == null) {
            throw new NoSuchObject();
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createProduct(@RequestBody Product product) {
        if (!productsService.createProduct(product)) {
            throw new ApiException("Don't save product in db :(", "productsService.createProduct(product) == null",
                    ExceptionType.SaveInDbException);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProduct(@RequestParam("productId") Product product) {
        if (!productsService.deleteProduct(product)) {
            throw new ApiException("Don't delete product :(", "productsService.deleteProduct(product) == null",
                    ExceptionType.DeleteInDbException);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProduct(@RequestParam("productId") Product productFromDb,
                                        @RequestBody Product productFromReqest) {
        Map<String, ProductDto> stringProductMap = productsService.updateProduct(productFromDb, productFromReqest);
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
        listAssert(favoriteCategoriesFavoriteProdcuts, isEmpty(), new ApiException("FavoriteCategories have't in db :(",
                "favoriteCategoriesFavoriteProdcuts.isEmpty()",
                ExceptionType.NoSuchObjs));
        return new ResponseEntity<>(favoriteCategoriesFavoriteProdcuts, HttpStatus.OK);
    }

}
