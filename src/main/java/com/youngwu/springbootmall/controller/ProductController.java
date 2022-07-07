package com.youngwu.springbootmall.controller;


import com.youngwu.springbootmall.dto.CreateProductRequest;
import com.youngwu.springbootmall.dto.CreateProductResponse;
import com.youngwu.springbootmall.model.Product;
import com.youngwu.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);


        if(product!=null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public CreateProductResponse createProduct(@RequestBody @Valid CreateProductRequest request) {
        return productService.createProduct(request);
    }
}
