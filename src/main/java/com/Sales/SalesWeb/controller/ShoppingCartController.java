package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.controller.exception.BadParamForRequest;
import com.Sales.SalesWeb.controller.exception.NoSuchObject;
import com.Sales.SalesWeb.model.POJO.ShoppingCart;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
@SessionAttributes(types = ShoppingCart.class)
@RequestMapping(value = "shoppingCart", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping(value = "/cart")
    public ResponseEntity<ShoppingCart> getCart( ShoppingCart shoppingCart) {
        return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
    }

    @PostMapping(value = "/addProduct",params = {"productId"})
    public ResponseEntity addProduct(@RequestParam("productId") Product product,
                                     ShoppingCart shoppingCart) {
        if (product == null) {
            throw new NoSuchObject();
        }
        shoppingCartService.addProduct(product, shoppingCart, 1);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(name = "/addProductPieces",params = {"numberPieces","productId"})
    public ResponseEntity addProductPieces(@RequestParam("numberPieces") Integer numberPieces,
                                           @RequestParam("productId") Product product,
                                           ShoppingCart shoppingCart) {
        if (product == null) {
            throw new NoSuchObject();
        }
        if (numberPieces <= 0) {
            throw new BadParamForRequest();
        }
        shoppingCartService.addProductPieces(product, shoppingCart, numberPieces);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteProduct",params = {"productId"})
    public ResponseEntity deleteProduct(@RequestParam("productId") Product product,
                                        ShoppingCart shoppingCart) {

        if (product == null) {
            throw new NoSuchObject();
        }
        shoppingCartService.deleteProduct(product, shoppingCart);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(name = "/deleteProductPieces",params = {"numberPieces","productId"})
    public ResponseEntity deleteProductPieces(@RequestParam("numberPieces") Integer numberPieces,
                                              @RequestParam("productId") Product product,
                                              ShoppingCart shoppingCart) {

        if (product == null) {
            throw new NoSuchObject();
        }
        if (numberPieces <= 0) {
            throw new BadParamForRequest();
        }
        shoppingCartService.deleteProductPieces(product, shoppingCart, numberPieces);
        return new ResponseEntity(HttpStatus.OK);
    }

//    @ModelAttribute
//    public ShoppingCart createShoppingCart() {
//        return new ShoppingCart();
//    }
}
