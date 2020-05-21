package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.controller.requestDto.SerchRequest.SearchResultRequest;
import com.Sales.SalesWeb.controller.requestDto.SerchRequest.SearchResultResponse;
import com.Sales.SalesWeb.model.DTO.ProductDto;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.repository.ProductRepository;
import com.Sales.SalesWeb.service.specification.ProductSpecFactory;
import com.Sales.SalesWeb.service.utils.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.Sales.SalesWeb.config.ControllerConfig.PAGE_SIZE;

@Service
public class SearchService {

    private final ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    public SearchResultResponse searchProduct(SearchResultRequest request) {
//        try {
//            Pageable pageable = PageRequest.of(request.getPage(), PAGE_SIZE);
//            String str = request.getSearchString();
//            Page<Product> containsProducts = productRepository
//                    .findByNameProductContainsOrPropertiesContainsOrProductDescriptionContains(str, str, str, pageable);
//            return new SearchResultResponse(containsProducts.getContent().stream().map(Mapper::toProductDto)
//                    .collect(Collectors.toList()), containsProducts.getTotalPages());
//        } catch (RuntimeException e) {
//            throw new InternalDataBaseServerExeption();
//        }
//    }

    public SearchResultResponse searchProduct(SearchResultRequest request) {
        ProductSpecFactory<Product> productSpecFactory = new ProductSpecFactory();
        Pageable pageable = request.createSort() == null ? PageRequest.of(request.getPage(), PAGE_SIZE)
                : PageRequest.of(request.getPage(), PAGE_SIZE, request.createSort());
        Specification<Product> specification = productSpecFactory
                .getLikeAndEqualsOrAndBetweenSpecification(request.toMapBetween(),
                        request.toAndsPredicateMap(),
                        request.toOrsPredicateMap(),
                        request.toLikePredicateMap());
        List<ProductDto> productsContent;
        Page<Product> productsPage;
        try {
            productsPage = productRepository.findAll(specification, pageable);
            productsContent = productsPage.getContent()
                    .stream().map(Mapper::toProductDto).collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return new SearchResultResponse(productsContent,productsPage.getTotalPages());
    }
}
