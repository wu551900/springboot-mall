package com.youngwu.springbootmall.dto;

import com.youngwu.springbootmall.constant.ProductCategory;
import lombok.Data;

@Data
public class ProductQueryParams {
    private ProductCategory category;

    private String search;
}
