package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.model.POJO.ShoppingCart;
import com.Sales.SalesWeb.model.POJO.ShoppingProduct;
import com.Sales.SalesWeb.model.Product;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ShoppingCartService {

    public void addProduct(Product product, ShoppingCart shoppingCart, Integer numberPieces) {
        Map<String, ShoppingProduct> products = shoppingCart.getProducts();
        products.put(product.getProductId().toString(), new ShoppingProduct(product, numberPieces));
        shoppingCart.setProducts(products);
    }

    public void addProductPieces(Product product, ShoppingCart shoppingCart, Integer numberPieces){
        ShoppingProduct shoppingProduct = shoppingCart.getProducts().get(product.getNameProduct());
        if(shoppingProduct == null){
            addProduct(product,shoppingCart,numberPieces);
            return;
        }
        shoppingProduct.setNumberPieces(numberPieces);
        shoppingCart.validation();
    }
}
