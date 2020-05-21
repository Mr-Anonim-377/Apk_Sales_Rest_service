package com.Sales.SalesWeb.controller.requestDto.SerchRequest;

import com.Sales.SalesWeb.model.DTO.ProductDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchResultResponse {

    List<ProductDto> products;

    Integer pageCount;

    public SearchResultResponse() {
    }

    public SearchResultResponse(List<ProductDto> products, Integer pageCaunt) {
        this.products = products;
        this.pageCount = pageCaunt;
    }
}
