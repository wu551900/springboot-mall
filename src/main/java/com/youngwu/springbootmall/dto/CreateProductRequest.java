package com.youngwu.springbootmall.dto;

import com.youngwu.springbootmall.constant.ProductCategory;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateProductRequest {

    @NotNull
    private String productName;

    @NotNull
    private ProductCategory category;

    @NotNull
    private String imageUrl;

    @NotNull
    private Integer price;

    @NotNull
    private Integer stock;

    private String description;
}
