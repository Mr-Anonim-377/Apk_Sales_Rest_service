package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.model.Collection;
import com.Sales.SalesWeb.model.DTO.CollectionDto;
import com.Sales.SalesWeb.model.response.entity.SimpleDbEntity;
import com.Sales.SalesWeb.repository.CollectionRepository;
import com.Sales.SalesWeb.repository.ProductRepository;
import com.Sales.SalesWeb.service.utils.Mapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import static com.Sales.SalesWeb.service.utils.Mapper.toCollectionDto;

@Service
public class CollectionService extends AbstractCatalogsEntityService {
    private final CollectionRepository collectionRepository;
    private final ProductRepository productRepository;

    public CollectionService(CollectionRepository collectionRepository, ProductRepository productRepository) {
        this.collectionRepository = collectionRepository;
        this.productRepository = productRepository;
    }

    public CollectionDto getCollect(Integer id) {
        CheckedErrorFunction<Integer, CollectionDto> functionSql = (collectionId) -> {
            Collection collection = collectionRepository.findByCollectionId(collectionId);
            return collection == null ? null : toCollectionDto(collection);
        };
        return applyHibernateQuery(id, functionSql);
    }

    public List<SimpleDbEntity<Integer, String>> getCollectionsByCategoryIdOfProduct(int categoryId) {
        CheckedErrorFunction<Integer, List<SimpleDbEntity<Integer, String>>> functionSql =
                collectionRepository::getCollectionsByCategoryIdOfProduct;
        return applyHibernateQuery(categoryId, functionSql);
    }

    public List<CollectionDto> getAllCollect() {
        Callable<List<CollectionDto>> functionSql = () -> {
            List<Collection> all = collectionRepository.findAll();
            return all.isEmpty() ? null : all.stream().map(Mapper::toCollectionDto).collect(Collectors.toList());
        };
        return applyHibernateQuery(functionSql);
    }

    @Override
    protected BigDecimal getPriceMin(Integer id) {
        CheckedErrorFunction<Integer, BigDecimal> functionSql = idValue -> {
            BigDecimal minProductPrice = productRepository.findFirstByCollection_CollectionIdOrderByPriceAsc(id).getPrice();
            return minProductPrice == null ? new BigDecimal(1) : minProductPrice;
        };
        return applyHibernateQuery(id, functionSql);
    }

    @Override
    protected BigDecimal getPriceMax(Integer id) {
        CheckedErrorFunction<Integer, BigDecimal> functionSql = idValue -> {
            BigDecimal minProductPrice = productRepository.findFirstByCollection_CollectionIdOrderByPriceDesc(id).getPrice();
            return minProductPrice == null ? new BigDecimal(999999) : minProductPrice;
        };
        return applyHibernateQuery(id, functionSql);
    }
}