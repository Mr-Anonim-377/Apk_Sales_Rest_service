package com.Sales.SalesWeb.service.Specification;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractSpecFacory {


    private Predicate createEqualPredicate(CriteriaBuilder criteriaBuilder, Path<Object> path, Object obj) {
        return criteriaBuilder.equal(path, obj);
    }

    protected abstract <T> Predicate createBetwenPredicate(CriteriaBuilder criteriaBuilder, Root<Object> root, List<T> betwenArg, String alias);

    public <T> Specification<Object> getSpecification(Map<String, List<T>> betwenArg, Map<String, Object> equalArg) {
        return (Specification<Object>)
                (root, criteriaQuery, criteriaBuilder) ->
                {
                    List<Predicate> predicateList = new ArrayList<>();
                    equalArg.forEach((k, v) -> {
                        String[] split = k.split("\\.");
                        Path<Object> path = null;
                        if (split.length > 0) {
                            path = applyGet(root, split);
                        }
                        predicateList.add(createEqualPredicate(criteriaBuilder, path == null ? root.get(k) : path, v));
                    });
                    betwenArg.forEach((k, v) -> {
                        predicateList.add(createBetwenPredicate(criteriaBuilder, root, v, k));
                    });
                    return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
                };
    }

    public Specification<Object> getSpecification(Map<String, Object> equalArg) {
        return (Specification<Object>)
                (root, criteriaQuery, criteriaBuilder) ->
                {
                    List<Predicate> predicateList = new ArrayList<>();
                    equalArg.forEach((k, v) -> {
                        String[] split = k.split("\\.");
                        Path<Object> path = null;
                        if (split.length > 0) {
                            path = applyGet(root, split);
                        }
                        predicateList.add(createEqualPredicate(criteriaBuilder, path == null ? root.get(k) : path, v    ));
                    });
                    return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
                };
    }

    private Path<Object> applyGet(Root<Object> root, String[] split) {
        Path<Object> path = null;
        for (String alias : split) {
            path = path == null ? root.get(alias) : path.get(alias);
        }
        return path;
    }
}
