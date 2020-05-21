package com.Sales.SalesWeb.controller.requestDto.ProductResuest;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.NoMatchersException;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import lombok.Getter;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
public abstract class ProductRequest {
    protected static final Pattern sortPattern =
            Pattern.compile("^(ORDER|Order|order)\\s?(BY|By|by) (.*) (Asc|Desc|ASC|DESC|asc|desc)$");

    public Map<String, List<BigDecimal>> toMapBetween() {
        BigDecimal minPrice = getMinPrice();
        BigDecimal maxPrice = getMaxPrice();
        minPrice = minPrice == null ? new BigDecimal(0.00) : minPrice;
        if (minPrice.compareTo(new BigDecimal(0.00)) != -1) {
            if (maxPrice == null) {
                return new HashMap<String, List<BigDecimal>>();
            }
            if (maxPrice.compareTo(new BigDecimal(0.00)) != -1) {
                BigDecimal finalMinPrice = minPrice;
                return new HashMap<String, List<BigDecimal>>() {{
                    put("price", getListBetweenArg(finalMinPrice, maxPrice));
                }};
            }
            throw new ApiException("maxPrice don't have valide value", "maxPrice < 0",
                    ExceptionType.ArgumentValueMismatch);
        }
        throw new ApiException("minPrice don't have valide value", "minPrice < 0",
                ExceptionType.ArgumentValueMismatch);
    }

    public Sort createSort() {
        String sort = getSort();
        if (sort != null) {
            Matcher matcher = sortPattern.matcher(sort);
            if (matcher.find()) {
                String[] orders = matcher.group(3).split(",");
                Sort creatingSort = Sort.by(orders);
                return matcher.group(4).toUpperCase().equals("ASC") ? creatingSort.ascending()
                        : creatingSort.descending();
            }
            throw new NoMatchersException(sortPattern.toString());
        }
        return null;
    }

    public abstract List<Map<Object, String>> toOrsPredicateMap();

    public abstract Map<Object, String> toAndsPredicateMap();

    protected abstract String getSort();

    protected abstract BigDecimal getMinPrice();

    protected abstract BigDecimal getMaxPrice();

    private <T> List<T> getListBetweenArg(T... arg) {
        return Arrays.stream(arg).collect(Collectors.toList());
    }
}
