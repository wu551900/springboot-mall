package com.youngwu.springbootmall.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterUserRequest {

    @ApiModelProperty(value = "用戶電子信箱", required = true)
    private String email;

    @ApiModelProperty(value = "用戶", required = true)
    private String password;
}
