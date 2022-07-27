package com.youngwu.springbootmall.dto.product;

import com.youngwu.springbootmall.constant.ProductCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateProductRequest {

    @NotNull
    @ApiModelProperty(value = "產品名稱", required = true)
    private String productName;

    @NotNull
    @ApiModelProperty(value = "產品類別", required = true, example = "FOOD, CAR, E_BOOK")
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
