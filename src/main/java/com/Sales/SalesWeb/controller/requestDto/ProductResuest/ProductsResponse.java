package com.Sales.SalesWeb.controller.requestDto.ProductResuest;

import com.Sales.SalesWeb.model.DTO.ProductDto;
import lombok.Data;

import java.util.List;

@Data
public class ProductsResponse {

    List<ProductDto> products;

    Integer pageCount;
}