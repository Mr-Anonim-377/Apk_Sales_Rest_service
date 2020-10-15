package com.Sales.SalesWeb.service;

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
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.Sales.SalesWeb.config.ControllerConfig.PAGE_SIZE;

@Service
public class SearchService extends AbstractService {

    private final ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public SearchResultResponse searchProduct(SearchResultRequest request) {
        ProductSpecFactory<Product> productSpecFactory = new ProductSpecFactory();
        Specification<Product> specification = productSpecFactory
                .getLikeAndEqualsOrAndBetweenSpecification(request.toMapBetween(), request.toAndsPredicateMap(),
                        request.toOrsPredicateMap(), request.toLikePredicateMap());
        Sort sort = request.createSort();
        Pageable pageable = sort == null ? PageRequest.of(request.getPage(), PAGE_SIZE)
                : PageRequest.of(request.getPage(), PAGE_SIZE, sort);
        CheckedErrorFunction<Pageable, SearchResultResponse> searchSqlFunction = functionPageable -> {
            String searchString = request.getSearchString().replaceAll("%", "");
            /*
            TODO Нужно исравить поиск максмальнйо и минимальной не только по всей атрибуетам поиска,
            а по конкретному, который передатеся в реквесте
            */
            BigDecimal maxPrice = productRepository
                    .findFirstByNameProductContainingIgnoreCaseOrPropertiesContainingIgnoreCaseOrProductDescriptionContainingIgnoreCaseOrderByPriceDesc(
                            searchString, searchString, searchString)
                    .getPrice();
            BigDecimal minPrice = productRepository
                    .findFirstByNameProductContainingIgnoreCaseOrPropertiesContainingIgnoreCaseOrProductDescriptionContainingIgnoreCaseOrderByPriceAsc(
                            searchString, searchString, searchString)
                    .getPrice();
            Page<Product> productsPage = productRepository.findAll(specification, functionPageable);
            List<ProductDto> productsContent = productsPage.getContent().stream()
                    .map(Mapper::toProductDto).collect(Collectors.toList());
            return new SearchResultResponse(productsContent, productsPage.getTotalPages(), minPrice, maxPrice);
        };
        return applyHibernateQuery(pageable, searchSqlFunction);
    }
}