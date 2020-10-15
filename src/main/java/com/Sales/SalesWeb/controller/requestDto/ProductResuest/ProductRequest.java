package com.Sales.SalesWeb.controller.requestDto.ProductResuest;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.NoMatchersException;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.repository.CategoryRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Getter
@Setter
public abstract class ProductRequest {

    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    String sort;  // Order By *,*,* Asc/Desc

    protected static final Pattern sortPattern =
            Pattern.compile("^(ORDER|Order|order)\\s?(BY|By|by) (.*) (Asc|Desc|ASC|DESC|asc|desc)$");

    public Map<String, List<BigDecimal>> toMapBetween() {
        this.minPrice = this.minPrice == null ? new BigDecimal(0.00) : this.minPrice;
        if (this.minPrice.compareTo(new BigDecimal(0.00)) != -1) {
            if (this.maxPrice == null) {
                return new HashMap<String, List<BigDecimal>>();
            }
            if (this.maxPrice.compareTo(new BigDecimal(0.00)) != -1) {
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

    private <T> List<T> getListBetweenArg(T... arg) {
        return Arrays.stream(arg).collect(Collectors.toList());
    }

    public abstract List<Map<Object, String>> toOrsPredicateMap(CategoryRepository categoryRepository);
}