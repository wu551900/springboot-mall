package com.youngwu.springbootmall.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteProductRequest {
    @ApiModelProperty(value = "產品ID", required = true)
    private String productId;
}
