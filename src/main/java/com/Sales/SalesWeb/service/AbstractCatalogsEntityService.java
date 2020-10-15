package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.model.response.entity.PriceBetween;

import java.math.BigDecimal;

public abstract class AbstractCatalogsEntityService extends AbstractService {
    public PriceBetween getPriceBetween(int id) {
        CheckedErrorFunction<Integer, PriceBetween> functionSql = (idValue) ->
                new PriceBetween(getPriceMin(idValue), getPriceMax(idValue));
        return applyHibernateQuery(id, functionSql);
    }

    protected abstract BigDecimal getPriceMin(Integer id);

    protected abstract BigDecimal getPriceMax(Integer id);
}