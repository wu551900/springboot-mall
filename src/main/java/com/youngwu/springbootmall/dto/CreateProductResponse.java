package com.youngwu.springbootmall.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreateProductResponse {
    @ApiModelProperty(value = "回傳狀態", required = true)
    String status;
}
