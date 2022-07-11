package com.youngwu.springbootmall.service;

import com.youngwu.springbootmall.dto.*;
import com.youngwu.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    CreateProductResponse createProduct(CreateProductRequest request);

    UpdateProductResponse updateProduct(UpdateProductRequest request);

    DeleteProductResponse deleteProduct(DeleteProductRequest request);
}
