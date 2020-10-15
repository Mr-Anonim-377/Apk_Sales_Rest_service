package com.Sales.SalesWeb.controller;


import com.Sales.SalesWeb.service.ReviewService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "productsReviews/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductReviewsController extends AbstractController{
    private final ReviewService reviewService;

    public ProductReviewsController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
}