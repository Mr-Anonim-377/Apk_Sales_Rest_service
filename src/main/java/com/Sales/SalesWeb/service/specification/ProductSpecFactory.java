package com.Sales.SalesWeb.service.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProductSpecFactory<T> extends AbstractSpecFacory<T>{
    @Override
    protected <K> Predicate createBetweenPredicate(CriteriaBuilder criteriaBuilder, Root<T> root,
                                                   List<K> betweenArg, String alias) {
        List<BigDecimal> currentArg = betweenArg.stream().map(element -> (BigDecimal) element)
                .collect(Collectors.toList());
        return criteriaBuilder.between(root.get(alias), currentArg.get(0), currentArg.get(1));
    }
}
