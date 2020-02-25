package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.model.ProductReview;
import com.Sales.SalesWeb.repository.ProductReviewsRepository;
import com.Sales.SalesWeb.service.Specification.AbstractSpecFacory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ReviewService {
    private final ProductReviewsRepository productReviewsRepository;


    public ReviewService(ProductReviewsRepository productReviewsRepository) {
        this.productReviewsRepository = productReviewsRepository;
    }


    public ProductReview createReview(ProductReview productReview) {
        try {
            productReview = productReviewsRepository.save(productReview);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return productReview;
    }

    public boolean deleteProductReview(ProductReview productReview) {
        try {
            productReviewsRepository.delete(productReview);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return productReviewsRepository.findById(productReview.getProductReviewsId()).isPresent();
    }

    public List<Object> getReviewOnFilter(List<String> searchKeys, List<Object> searchValues) {
        AbstractSpecFacory abstractSpecFacory = new AbstractSpecFacory() {
            @Override
            protected <T> Predicate createBetwenPredicate(CriteriaBuilder criteriaBuilder, Root<Object> root, List<T> betwenArg, String alias) {
                return null;
            }
        };
        Map<String, Object> map = searchKeys != null ? IntStream.range(0, searchKeys.size()).boxed()
                .collect(Collectors.toMap(searchKeys::get, searchValues::get)) : new HashMap<>();

        List<Map.Entry<String, Object>> keys = new ArrayList<>();

        map.entrySet().forEach(entry -> {
            if (entry.getValue().toString()
                    .matches("([a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8})")) {
                keys.add(entry);
            }
        });
        keys.forEach(i -> {
            map.put(i.getKey(), UUID.fromString((String) i.getValue()));
        });

        Specification<Object> specification = abstractSpecFacory.getSpecification(map);
        List<Object> review;
        try {
            review = productReviewsRepository.findAll(specification);

        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return review;
    }
}
