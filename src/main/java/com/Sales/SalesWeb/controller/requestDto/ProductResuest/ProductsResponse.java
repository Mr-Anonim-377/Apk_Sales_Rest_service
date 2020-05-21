package com.Sales.SalesWeb.controller.requestDto.ProductResuest;

import com.Sales.SalesWeb.model.DTO.ProductDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ProductsResponse {

    List<ProductDto> products;

    Integer pageCount;

    public ProductsResponse() {
    }

    public ProductsResponse(List<ProductDto> products, Integer pageCount) {
        this.products = products;
        this.pageCount = pageCount;
    }
}
