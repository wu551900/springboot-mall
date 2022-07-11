package com.youngwu.springbootmall.service;

import com.youngwu.springbootmall.dto.*;
import com.youngwu.springbootmall.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product getProductById(Integer productId);

    CreateProductResponse createProduct(CreateProductRequest request);

    UpdateProductResponse updateProduct(UpdateProductRequest request);

    DeleteProductResponse deleteProduct(DeleteProductRequest request);


}
