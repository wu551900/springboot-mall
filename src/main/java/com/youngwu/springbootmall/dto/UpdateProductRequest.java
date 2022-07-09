package com.youngwu.springbootmall.dto;

import com.youngwu.springbootmall.constant.ProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateProductRequest {

    @NotNull
    @ApiModelProperty(value = "產品ID", required = true)
    private String productId;

    @NotNull
    @ApiModelProperty(value = "產品名稱", required = true)
    private String productName;

    @NotNull
    @ApiModelProperty(value = "產品類別", required = true)
    private ProductCategory category;

    @NotNull
    @ApiModelProperty(value = "產品圖片連結", required = true)
    private String imageUrl;

    @NotNull
    @ApiModelProperty(value = "產品價格", required = true)
    private Integer price;

    @NotNull
    @ApiModelProperty(value = "產品庫存數量", required = true)
    private Integer stock;

    @ApiModelProperty(value = "產品敘述")
    private String description;


}
