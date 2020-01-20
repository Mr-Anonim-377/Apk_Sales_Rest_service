package com.Sales.SalesWeb.controller;


import com.Sales.SalesWeb.controller.exception.InternalServerExeption;
import com.Sales.SalesWeb.controller.exception.NoSuchObject;
import com.Sales.SalesWeb.model.POJO.FavoriteCategoryProductsResponse;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE)
@SessionAttributes("product")
public class ProductController {
    private final ProductsService productsService;

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProduct(Model model, @PathVariable UUID id) {
        Product product;
        try {
            product = productsService.getProduct(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new InternalServerExeption();
        }
        if (product == null) {
            throw new NoSuchObject();
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createProduct(@RequestBody Product product) {
        Product newProduct;
        try {
            newProduct = productsService.createProduct(product);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new InternalServerExeption();
        }
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProduct(@PathVariable("id") Product product) {
        try {
            productsService.deleteProduct(product);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new InternalServerExeption();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProduct(@PathVariable("id") Product productFromDb, @RequestBody Product productFromReqest) {
        Map<String, Product> stringProductMap;
        try {
            stringProductMap = productsService.updateProduct(productFromDb, productFromReqest);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new InternalServerExeption();
        }
        return new ResponseEntity<>(stringProductMap, HttpStatus.OK);

    }

    @PostMapping(value = "favorites", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getFavoriteCategoriesFavoriteProdcuts() {
        List<FavoriteCategoryProductsResponse> favoriteCategoriesFavoriteProdcuts;
        try {
            favoriteCategoriesFavoriteProdcuts = productsService.getFavoriteCategoriesFavoriteProdcuts();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new InternalServerExeption();
        }
        return new ResponseEntity<>(favoriteCategoriesFavoriteProdcuts, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity test(@ModelAttribute Product product) {
        product.setNameProduct("4333545");
        return new ResponseEntity(product, HttpStatus.OK);
    }


    @ModelAttribute("product")
    public Product createUser() {
        Product product = new Product();
        product.setNameProduct("testtttt");
        return product;
    }

}
