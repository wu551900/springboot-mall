package com.youngwu.springbootmall.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterUserResponse {
    @ApiModelProperty(value = "回傳狀態", required = true)
    String status;
}
