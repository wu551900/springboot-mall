package com.youngwu.springbootmall.controller;


import com.youngwu.springbootmall.dto.CreateProductRequest;
import com.youngwu.springbootmall.dto.CreateProductResponse;
import com.youngwu.springbootmall.dto.UpdateProductRequest;
import com.youngwu.springbootmall.dto.UpdateProductResponse;
import com.youngwu.springbootmall.model.Product;
import com.youngwu.springbootmall.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "ProductController", tags = {"ProductController"})
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("查詢產品")
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);


        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @ApiOperation("新增產品")
    @PostMapping("/products")
    public CreateProductResponse createProduct(@RequestBody @Valid CreateProductRequest request) {
        return productService.createProduct(request);
    }

    @ApiOperation("修改產品")
    @PostMapping("/updateProducts")
    public UpdateProductResponse updateProduct(@RequestBody @Valid UpdateProductRequest request) {
        return productService.updateProduct(request);
    }


}
