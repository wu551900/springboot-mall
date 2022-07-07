package com.youngwu.springbootmall.service;

import com.youngwu.springbootmall.dto.CreateProductRequest;
import com.youngwu.springbootmall.dto.CreateProductResponse;
import com.youngwu.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    CreateProductResponse createProduct(CreateProductRequest productRequest);
}
