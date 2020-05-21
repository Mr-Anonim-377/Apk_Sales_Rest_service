package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.controller.requestDto.ReviewRequest.ReviewRequest;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.model.ProductReview;
import com.Sales.SalesWeb.model.Review;
import com.Sales.SalesWeb.model.User;
import com.Sales.SalesWeb.repository.ProductRepository;
import com.Sales.SalesWeb.repository.ProductReviewRepository;
import com.Sales.SalesWeb.repository.ReviewRepository;
import com.Sales.SalesWeb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductReviewRepository productReviewRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ReviewService(ReviewRepository reviewRepository,
                         ProductReviewRepository productReviewRepository,
                         ProductRepository productRepository,
                         UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.productReviewRepository = productReviewRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public void createProductReview(ReviewRequest reviewRequest) {
        try {
            Review review = new Review();
            Integer requestMark = reviewRequest.getMark();
            review.setReviewMark(requestMark);
            review.setReviewDescription(reviewRequest.getDiscription());
            review.setReviewTitle(reviewRequest.getTitle());
            review.setReviewType(reviewRequest.getReviewType());
            Optional<User> optionalUser = userRepository.findByEmail(reviewRequest.getUserEmail());
            if (optionalUser.isPresent()) {
                review.setUser(optionalUser.get());
            } else {
                throw new ApiException("Find User error",
                        "Not find user in db",
                        ExceptionType.NoSuchObj);
            }
            review.setReviewId(UUID.randomUUID());
            Review reviewIdDb = reviewRepository.save(review);

            ProductReview productReview = new ProductReview();

            Optional<Product> productOptional = productRepository.findById(reviewRequest.getProductId());
            if (productOptional.isPresent()) {
                productReview.setProductReviewsId(UUID.randomUUID());
                productReview.setProduct(productOptional.get());
            } else {
                throw new ApiException("Find product error",
                        "Not find product in db",
                        ExceptionType.NoSuchObj);
            }
            productReview.setReview(reviewIdDb);
            productReviewRepository.save(productReview);

            Product product = productOptional.get();
            product.setSumMark(product.getSumMark() == null
                    ? requestMark
                    : product.getSumMark() + requestMark);
            product.setAverageMark(product.getAverageMark() == null
                    ? new BigDecimal(requestMark)
                    : new BigDecimal(
                    Double.valueOf(product.getSumMark()) / product.getProductReviews().size()));
            productRepository.save(product);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
    }

}
