package com.Sales.SalesWeb.service.specification;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractSpecFacory<T> {

    public <K> Specification<T> getEqualsAndBetweenSpecification(Map<String, List<K>> betwenArg,
                                                                 Map<Object, String> equalArg) {
        return (Specification<T>)
                (root, criteriaQuery, criteriaBuilder) ->
                {
                    List<Predicate> predicateList = getEqualsPredicateList(equalArg, root, criteriaBuilder);
                    betwenArg.forEach((k, v) -> {
                        predicateList.add(createBetweenPredicate(criteriaBuilder, root, v, k));
                    });
                    return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
                };
    }

    public <K> Specification<T> getLikeAndEqualsOrAndBetweenSpecification(Map<String, List<K>> betwenArg, Map<Object,
            String> equalArg, List<Map<Object, String>> orArg, List<Map<Object, String>> likeMap) {
        return (Specification<T>)
                (root, criteriaQuery, criteriaBuilder) ->
                {
                    List<Predicate> predicateList = equalArg.size() == 0 ? new ArrayList<>() :
                            getEqualsPredicateList(equalArg, root, criteriaBuilder);
                    betwenArg.forEach((k, v) -> predicateList.add(createBetweenPredicate(criteriaBuilder, root, v, k)));
                    if (orArg.size() != 0) {
                        orArg.forEach(map -> predicateList
                                .add(criteriaBuilder.or(getEqualsPredicateList(map, root, criteriaBuilder)
                                        .toArray(new Predicate[0]))));
                    }
                    if (likeMap.size() != 0) {
                        predicateList.add(criteriaBuilder.or(likeMap.stream()
                                        .map(map -> criteriaBuilder.or(getLikePredicateList(map, root, criteriaBuilder)
                                                .toArray(new Predicate[0]))).toArray(Predicate[]::new)));
//                        likeMap.forEach(map -> predicateList
//                                .add(criteriaBuilder.or(getLikePredicateList(map, root, criteriaBuilder)
//                                        .toArray(new Predicate[0]))));
                    }
                    return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
                };
    }

    public <K> Specification<T> getOrAndEqualsBetweenSpecification(Map<String, List<K>> betwenArg, Map<Object,
            String> equalArg, List<Map<Object, String>> orArg) {
        return (Specification<T>)
                (root, criteriaQuery, criteriaBuilder) ->
                {
                    List<Predicate> predicateList = equalArg.size() == 0 ? new ArrayList<>() :
                            getEqualsPredicateList(equalArg, root, criteriaBuilder);
                    betwenArg.forEach((k, v) -> predicateList.add(createBetweenPredicate(criteriaBuilder, root, v, k)));
                    if (orArg.size() != 0) {
                        orArg.forEach(map -> predicateList
                                .add(criteriaBuilder.or(getEqualsPredicateList(map, root, criteriaBuilder)
                                        .toArray(new Predicate[0]))));
                    }
                    return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
                };
    }

    public Specification<T> getEqualsSpecification(Map<Object, String> equalArg) {
        return (Specification<T>)
                (root, criteriaQuery, criteriaBuilder) ->
                {
                    List<Predicate> predicateList = getEqualsPredicateList(equalArg, root, criteriaBuilder);
                    return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
                };
    }

    private List<Predicate> getEqualsPredicateList(Map<Object, String> equalArg, Root<T> root,
                                                   CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList = new ArrayList<>();
        equalArg.forEach((k, v) -> {
            String[] split = v.split("\\.");
            Path<Object> path = null;
            if (split.length > 0) {
                path = getPath(root, split);
            }
            predicateList.add(createEqualPredicate(criteriaBuilder, path, k));
        });
        return predicateList;
    }

    private List<Predicate> getLikePredicateList(Map<Object, String> likeArg, Root<T> root,
                                                 CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList = new ArrayList<>();
        likeArg.forEach((k, v) -> {
            String[] split = v.split("\\.");
            Path<String> path = null;
            if (split.length > 0) {
                for (String alias : split) {
                    path = path == null ? root.get(alias) : path.get(alias);
                }
            }
            predicateList.add(createLikePredicate(criteriaBuilder, path, String.valueOf(k)));
        });
        return predicateList;
    }

    private Predicate createEqualPredicate(CriteriaBuilder criteriaBuilder, Path<Object> path, Object obj) {
        return criteriaBuilder.equal(path, obj);
    }

    private Predicate createLikePredicate(CriteriaBuilder criteriaBuilder, Path<String> path, String str) {
        return criteriaBuilder.like(criteriaBuilder.lower(path), str);
    }

    protected abstract <K> Predicate createBetweenPredicate(CriteriaBuilder criteriaBuilder, Root<T> root,
                                                            List<K> betweenArg, String alias);

    private Path<Object> getPath(Root<T> root, String[] split) {
        Path<Object> path = null;
        for (String alias : split) {
            path = path == null ? root.get(alias) : path.get(alias);
        }
        return path;
    }
}
