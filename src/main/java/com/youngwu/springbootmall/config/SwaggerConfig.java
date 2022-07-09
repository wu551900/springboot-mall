package com.youngwu.springbootmall.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    /**
     * 用於讀取yml中swagger是否開啟的設置
     */
    @Value("${springfox.documentation.swagger-ui.enabled}")
    Boolean swaggerEnabled;

    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                //是否開啟swagger
                .enable(swaggerEnabled)
                .select()
                //掃描指定路徑下的文件
                .apis(RequestHandlerSelectors.basePackage("com.youngwu.springbootmall.controller"))
                //指定路徑處理, PathSelectors.any()代表不過濾任何路徑
                //.paths(PathSelectors.any())
                .build();
    }
}
