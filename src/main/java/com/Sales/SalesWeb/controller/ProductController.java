package com.Sales.SalesWeb.controller;


import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.NoSuchObject;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.controller.requestDto.ProductResuest.ProductCategoryReqest;
import com.Sales.SalesWeb.controller.requestDto.ProductResuest.ProductCollectionRequest;
import com.Sales.SalesWeb.controller.requestDto.ProductResuest.ProductsResponse;
import com.Sales.SalesWeb.model.DTO.ProductDto;
import com.Sales.SalesWeb.model.POJO.FavoriteCategoryProductsResponse;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.Sales.SalesWeb.service.utils.SqlAssert.isEmpty;
import static com.Sales.SalesWeb.service.utils.SqlAssert.listAssert;

@RestController
@RequestMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    private final ProductsService productsService;

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductsOnCategory(@RequestBody ProductCategoryReqest body) {
        ProductsResponse products = productsService.getProductWithProductRequest(body.getPage(), body);
        if (products == null || products.getProducts().isEmpty()) {
            throw new NoSuchObject();
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @PostMapping(value = "/collection", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductsOnCollection(@RequestBody ProductCollectionRequest body) {
        ProductsResponse products = productsService.getProductWithProductRequest(body.getPage(), body);
        if (products == null || products.getProducts().isEmpty()) {
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
