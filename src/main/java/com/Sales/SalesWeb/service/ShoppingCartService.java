package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.controller.exception.ShoppingProductNotSuch;
import com.Sales.SalesWeb.model.POJO.ShoppingCart;
import com.Sales.SalesWeb.model.POJO.ShoppingProduct;
import com.Sales.SalesWeb.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class ShoppingCartService {

    public void addProduct(Product product, ShoppingCart shoppingCart, Integer numberPieces) {
        try {
            if(shoppingCart.getProducts().containsKey(product.getProductId().toString())){
                addProductPieces(product,shoppingCart,1);
            }else{
                Map<String, ShoppingProduct> products = shoppingCart.getProducts();
                products.put(product.getProductId().toString(), new ShoppingProduct(product, numberPieces));
                shoppingCart.setProducts(products);
                validation(shoppingCart);
            }
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }

    }

    public void deleteProduct(Product product, ShoppingCart shoppingCart) {
        try {
            Map<String, ShoppingProduct> products = shoppingCart.getProducts();
            products.entrySet().removeIf(entry -> entry.getValue().getProduct().getProductId()
                    .equals(product.getProductId()));
            shoppingCart.setProducts(products);
            validation(shoppingCart);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
    }

    public void addProductPieces(Product product, ShoppingCart shoppingCart, Integer numberPieces) {
        try {
            ShoppingProduct shoppingProduct = shoppingCart.getProducts().get(product.getProductId().toString());
            if (shoppingProduct == null) {
                addProduct(product, shoppingCart, numberPieces);
                return;
            }

            shoppingProduct.setNumberPieces(shoppingProduct.getNumberPieces() + numberPieces);
            validation(shoppingCart);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
    }

    public void deleteProductPieces(Product product, ShoppingCart shoppingCart, Integer numberPieces) {
        try {
            ShoppingProduct shoppingProduct = shoppingCart.getProducts().get(product.getProductId().toString());
            if (shoppingProduct == null) {
                throw new ShoppingProductNotSuch();
            }
            int currentPieces = shoppingProduct.getNumberPieces() - numberPieces;
            if (currentPieces <= 0) {
                deleteProduct(product, shoppingCart);
            } else {
                shoppingProduct.setNumberPieces(currentPieces);
            }
            validation(shoppingCart);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
    }

    private void validation(ShoppingCart shoppingCart) {
        Map<String, ShoppingProduct> products = shoppingCart.getProducts();
        shoppingCart.setTotalAmount(BigDecimal.valueOf(products.values().stream()
                .map(ShoppingProduct::getPriceNumberPieces)
                .mapToDouble(BigDecimal::doubleValue)
                .sum()));
        shoppingCart.setCountProducts(products.size());
        shoppingCart.setCountProductsPieces(products.values().stream().map(ShoppingProduct::getNumberPieces)
                .mapToInt(a -> a)
                .sum());
    }
}
