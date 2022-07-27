package com.youngwu.springbootmall.dto.product;

import com.youngwu.springbootmall.constant.OrderByColumn;
import com.youngwu.springbootmall.constant.ProductCategory;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Young
 */
@Data
public class ProductQueryParams {
    private ProductCategory category;

    private String search;

    @Enumerated(EnumType.STRING)
    private OrderByColumn orderBy;

    private String sort;

    private Integer page;

    private Integer pageSize;
}
