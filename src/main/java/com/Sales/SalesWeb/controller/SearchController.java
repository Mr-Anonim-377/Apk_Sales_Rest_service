package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.NoSuchObjects;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.controller.requestDto.SerchRequest.SearchResultRequest;
import com.Sales.SalesWeb.controller.requestDto.SerchRequest.SearchResultResponse;
import com.Sales.SalesWeb.service.SearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "search/", produces = MediaType.APPLICATION_JSON_VALUE)
public class SearchController extends AbstractController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping(value = "onProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchOnProduct(@RequestBody SearchResultRequest apiRequest) {
        ApiException apiException = new ApiException("The search string is less than or equal to 3  -_-",
                "name.length() <= 3", ExceptionType.WrongSearchString);
        objectAssert(apiException, request -> request.getSearchString().length() <= 3, apiRequest);
        SearchResultResponse resultProducts = searchService.searchProduct(apiRequest);
        nullAssert(resultProducts);
        return new ResponseEntity<>(resultProducts, HttpStatus.OK);
    }

}