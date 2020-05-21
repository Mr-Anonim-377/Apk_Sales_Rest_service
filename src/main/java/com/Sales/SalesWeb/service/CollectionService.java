package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.model.Collection;
import com.Sales.SalesWeb.model.DTO.CollectionDto;
import com.Sales.SalesWeb.model.POJO.PriceBetween;
import com.Sales.SalesWeb.repository.CollectionRepository;
import com.Sales.SalesWeb.repository.ProductRepository;
import com.Sales.SalesWeb.service.utils.Mapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.Sales.SalesWeb.service.utils.Mapper.toCollectionDto;

@Service
public class CollectionService {
    private final CollectionRepository collectionRepository;
    private ProductRepository productRepository;

    public CollectionService(CollectionRepository collectionRepository, ProductRepository productRepository) {
        this.collectionRepository = collectionRepository;
        this.productRepository = productRepository;
    }

    public CollectionDto getCollect(Integer id) {
        CollectionDto collectionDto;
        try {
            Collection collection = collectionRepository.findByCollectionId(id);
            collectionDto = collection==null?null:toCollectionDto(collection);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return collectionDto;
    }

    public PriceBetween getPriceBtween(int id, String requestType){
        try{
            return new PriceBetween(getPriceMin(requestType, id), getPriceMax(requestType, id));
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
    }
    private BigDecimal getPriceMin(String requestType, Integer id) {
        switch (requestType){
            case "Category":{
                return productRepository.findFirstByCategory_CategoryIdOrderByPriceAsc(id).getPrice();
            }
            case "Collection":{
                return productRepository.findFirstByCollection_CollectionIdOrderByPriceAsc(id).getPrice();
            }
            default:{
                throw new ApiException("RequestType not mapping -_-",
                        "Rquest id type error",
                        ExceptionType.ArgumentValueMismatch);
            }
        }
    }
    private BigDecimal getPriceMax(String requestType, Integer id) {
        switch (requestType){
            case "Category":{
                return productRepository.findFirstByCategory_CategoryIdOrderByPriceDesc(id).getPrice();
            }
            case "Collection":{
                return productRepository.findFirstByCollection_CollectionIdOrderByPriceDesc(id).getPrice();
            }
            default:{
                throw new ApiException("SearchType not mapping -_-",
                        "Enum SearchType not mapping",
                        ExceptionType.ArgumentValueMismatch);
            }
        }
    }

    public List<Map<Integer,String>> getCollectionsByProductOfCategory(int categoryId){
        List<Map<Integer,String>> collections;
        try {
            collections = collectionRepository.getAllProductCollections(categoryId);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return collections;

    }

    public List<CollectionDto> getAllCollect() {
        List<CollectionDto> collections;
        try {
            List<Collection> all = collectionRepository.findAll();
            collections = all.isEmpty()?null:all.stream().map(Mapper::toCollectionDto)
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return collections;
    }
}
