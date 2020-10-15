package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.ShoppingProductNotSuch;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.model.response.entity.ShoppingCart;
import com.Sales.SalesWeb.model.response.entity.ShoppingProduct;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static com.Sales.SalesWeb.service.utils.Mapper.toProductDto;

@Service
public class ShoppingCartService extends AbstractService {

    private Predicate<ShoppingProduct> getShoppingProductPredicate(Product product) {
        return shoppingProduct -> shoppingProduct.getProduct().getProductId().equals(product.getProductId());
    }

    private Optional<ShoppingProduct> getShoppingProduct(Product product, ShoppingCart shoppingCart) {
        return shoppingCart.getProducts().stream()
                .filter(getShoppingProductPredicate(product)).findFirst();
    }

    public void addProduct(Product product, ShoppingCart shoppingCart, Integer numberPieces) {
        if (shoppingCart.getProducts().stream().anyMatch(getShoppingProductPredicate(product))) {
            addProductPieces(product, shoppingCart, 1);
        } else {
            List<ShoppingProduct> products = shoppingCart.getProducts();
            products.add(new ShoppingProduct(toProductDto(product), numberPieces));
            shoppingCart.setProducts(products);
            validation(shoppingCart);
        }
    }

    public void deleteProduct(Product product, ShoppingCart shoppingCart) {
        List<ShoppingProduct> products = shoppingCart.getProducts();
        products.removeIf(entry -> entry.getProduct().getProductId().equals(product.getProductId()));
        shoppingCart.setProducts(products);
        validation(shoppingCart);
    }

    public void addProductPieces(Product product, ShoppingCart shoppingCart, Integer numberPieces) {
        Optional<ShoppingProduct> shoppingProductOptional = getShoppingProduct(product, shoppingCart);
        if (!shoppingProductOptional.isPresent()) {
            addProduct(product, shoppingCart, numberPieces);
            return;
        }
        ShoppingProduct shoppingProduct = shoppingProductOptional.get();
        shoppingProduct.setNumberPieces(shoppingProduct.getNumberPieces() + numberPieces);
        validation(shoppingCart);
    }

    public void deleteProductPieces(Product product, ShoppingCart shoppingCart, Integer numberPieces) {
        Optional<ShoppingProduct> shoppingProductOptional = getShoppingProduct(product, shoppingCart);
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
    }

    private void validation(ShoppingCart shoppingCart) {
        List<ShoppingProduct> products = shoppingCart.getProducts();
        shoppingCart.setTotalAmount(BigDecimal.valueOf(products.stream()
                .map(ShoppingProduct::getPriceNumberPieces).mapToDouble(BigDecimal::doubleValue).sum()).setScale(2));
        shoppingCart.setCountProducts(products.size());
        shoppingCart.setCountProductsPieces(products.stream().map(ShoppingProduct::getNumberPieces)
                .mapToInt(a -> a).sum());
    }
}