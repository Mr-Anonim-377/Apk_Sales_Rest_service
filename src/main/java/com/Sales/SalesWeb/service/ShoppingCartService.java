package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.controller.exception.ShoppingProductNotSuch;
import com.Sales.SalesWeb.model.POJO.ShoppingCart;
import com.Sales.SalesWeb.model.POJO.ShoppingProduct;
import com.Sales.SalesWeb.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.Sales.SalesWeb.service.utils.Mapper.toProductDto;

@Service
public class ShoppingCartService {

    public void addProduct(Product product, ShoppingCart shoppingCart, Integer numberPieces) {
        try {
            AtomicBoolean isAdded = new AtomicBoolean(false);
            shoppingCart.getProducts().forEach(productCart -> {
                if (productCart.getProduct().getProductId().equals(product.getProductId())) {
                    isAdded.set(true);
                }
            });
            if (isAdded.get()) {
                addProductPieces(product, shoppingCart, 1);
            } else {
                List<ShoppingProduct> products = shoppingCart.getProducts();
                products.add(new ShoppingProduct(toProductDto(product), numberPieces));
                shoppingCart.setProducts(products);
                validation(shoppingCart);
            }
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }

    }

    public void deleteProduct(Product product, ShoppingCart shoppingCart) {
        try {
            List<ShoppingProduct> products = shoppingCart.getProducts();
            products.removeIf(entry -> entry.getProduct().getProductId().equals(product.getProductId()));
            shoppingCart.setProducts(products);
            validation(shoppingCart);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
    }

    public void addProductPieces(Product product, ShoppingCart shoppingCart, Integer numberPieces) {
        try {
            Optional<ShoppingProduct> shoppingProductOptional = shoppingCart.getProducts().stream()
                    .filter(productItem -> productItem.getProduct().getProductId().equals(product.getProductId()))
                    .findFirst();
            if (!shoppingProductOptional.isPresent()) {
                addProduct(product, shoppingCart, numberPieces);
                return;
            }
            ShoppingProduct shoppingProduct = shoppingProductOptional.get();
            shoppingProduct.setNumberPieces(shoppingProduct.getNumberPieces() + numberPieces);
            validation(shoppingCart);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
    }

    public void deleteProductPieces(Product product, ShoppingCart shoppingCart, Integer numberPieces) {
        try {
            Optional<ShoppingProduct> shoppingProductOptional = shoppingCart.getProducts().stream()
                    .filter(productItem -> productItem.getProduct().getProductId().equals(product.getProductId()))
                    .findFirst();
            if (!shoppingProductOptional.isPresent()) {
                throw new ShoppingProductNotSuch();
            }
            ShoppingProduct shoppingProduct = shoppingProductOptional.get();
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
        List<ShoppingProduct> products = shoppingCart.getProducts();
        shoppingCart.setTotalAmount(BigDecimal.valueOf(products.stream()
                .map(ShoppingProduct::getPriceNumberPieces)
                .mapToDouble(BigDecimal::doubleValue)
                .sum()));
        shoppingCart.setCountProducts(products.size());
        shoppingCart.setCountProductsPieces(products.stream().map(ShoppingProduct::getNumberPieces)
                .mapToInt(a -> a)
                .sum());
    }
}
