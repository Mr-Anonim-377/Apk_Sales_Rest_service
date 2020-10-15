package com.Sales.SalesWeb.controller;


import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.controller.requestDto.ProductResuest.ProductCategoryRequest;
import com.Sales.SalesWeb.controller.requestDto.ProductResuest.ProductCollectionRequest;
import com.Sales.SalesWeb.controller.requestDto.ProductResuest.ProductsCategoryResponse;
import com.Sales.SalesWeb.controller.requestDto.ProductResuest.ProductsCollectionResponse;
import com.Sales.SalesWeb.model.DTO.ProductDto;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.model.response.entity.FavoriteCategoryProductsResponse;
import com.Sales.SalesWeb.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "products/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController extends AbstractController {
    private final ProductsService productsService;

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping(value = "category", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductsOnCategory(@RequestBody ProductCategoryRequest body) {
        ProductsCategoryResponse products = productsService.getProductsWithProductRequest(body.getPage(), body);
        nullAssert(products);
        products.setCategoryName(productsService.getCategoryNameById(body.getCategoryId()));
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping(value = "collection", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductsOnCollection(@RequestBody ProductCollectionRequest body) {
        ProductsCollectionResponse products = productsService.getProductsWithProductRequest(body.getPage(), body);
        nullAssert(products);
        products.setCollectionName(productsService.getCollectionNameById(body.getCollectionId()));
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProduct(@PathVariable UUID id) {
        ProductDto product = productsService.getProduct(id);
        nullAssert(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createProduct(@RequestBody Product product) {
        boolean isCratedProduct = productsService.createProduct(product);
        objectAssert(new ApiException("Don't save product in db :(", "productsService.createProduct(product) == false",
                ExceptionType.SaveInDbException), isCratedProduct, true);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProduct(@RequestParam("productId") Product product) {
        boolean isDeletedProduct = productsService.deleteProduct(product);
        objectAssert(new ApiException("Don't delete product :(", "productsService.deleteProduct(product) == false",
                ExceptionType.DeleteInDbException), isDeletedProduct, true);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProduct(@RequestParam("productId") Product productFromDb,
                                        @RequestBody Product productFromReqest) {
        Map<String, ProductDto> stringProductMap = productsService.updateProduct(productFromDb, productFromReqest);
        boolean isUpdatedProduct = stringProductMap.isEmpty();
        objectAssert(new ApiException("Don't update product :(", "productsService.updateProduct(product) == false",
                ExceptionType.UpdateInDbException), isUpdatedProduct, true);
        return new ResponseEntity<>(stringProductMap, HttpStatus.OK);
    }

    @PostMapping(value = "favorites/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getFavoriteCategoriesFavoriteProducts(@RequestParam Integer countFavoriteCategories) {
        List<FavoriteCategoryProductsResponse> favoriteProdcuts = productsService
                .getFavoriteCategoriesFavoriteProducts(countFavoriteCategories);
        listAssert(favoriteProdcuts, isEmpty(), new ApiException("FavoriteCategories haven't in db :(",
                "favoriteCategoriesFavoriteProducts.isEmpty()",
                ExceptionType.NoSuchObjs));
        return new ResponseEntity<>(favoriteProdcuts, HttpStatus.OK);
    }

}