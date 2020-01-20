package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.model.POJO.ShoppingCart;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "shoppingCart", produces = MediaType.APPLICATION_JSON_VALUE)
@SessionAttributes("shoppingCart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/cart")
    public ResponseEntity getCart(@ModelAttribute ShoppingCart shoppingCart) {
        return new ResponseEntity(shoppingCart, HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity addProduct(@RequestParam("productId") Product product,
                                     @ModelAttribute ShoppingCart shoppingCart) {

        shoppingCartService.addProduct(product, shoppingCart,1);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/addProductPieces")
    public ResponseEntity addProductPieces(@RequestParam("numberPieces") Integer numberPieces,
                                           @RequestParam("productId") Product product,
                                           @ModelAttribute ShoppingCart shoppingCart) {

        shoppingCartService.addProductPieces(product, shoppingCart,numberPieces);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ModelAttribute("shoppingCart")
    public ShoppingCart createUser() {
        return new ShoppingCart();
    }
}
