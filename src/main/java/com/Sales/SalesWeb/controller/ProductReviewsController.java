package com.Sales.SalesWeb.controller;


import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.NoSuchObject;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.model.ProductReview;
import com.Sales.SalesWeb.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "productsReviews", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductReviewsController {
    private final ReviewService reviewService;

    public ProductReviewsController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductsOnCategpry(@PathVariable("id") ProductReview productReview) {
        return new ResponseEntity<>(productReview, HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductsOnCategory(
                                        @RequestParam(value = "searchKey", required = false) List<String> searchKeys,
                                        @RequestParam(value = "searchValue", required = false) List<Object> searchValues) {
        searchKeys = searchKeys==null? new ArrayList<>():searchKeys;
        searchValues = searchValues==null? new ArrayList<>():searchValues;
        List<Object> reviewOnFilter = reviewService.getReviewOnFilter(searchKeys, searchValues);
        if (reviewOnFilter == null || reviewOnFilter.isEmpty()) {
            throw new NoSuchObject();
        }
        return new ResponseEntity<>(reviewOnFilter, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createReview(@RequestBody ProductReview productReview) {
        ProductReview review = reviewService.createReview(productReview);
        if (review == null) {
            throw new NoSuchObject();
        }
        return new ResponseEntity<>(productReview, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProduct(@PathVariable("id") ProductReview productReview) {
        if (!reviewService.deleteProductReview(productReview)) {
            throw new ApiException("Don't delete product :(", "reviewService.deleteProductReview(productReview) == null",
                    ExceptionType.DeleteInDbException);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
