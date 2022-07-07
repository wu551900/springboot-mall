package com.youngwu.springbootmall.service.impl;

import com.youngwu.springbootmall.dto.CreateProductRequest;
import com.youngwu.springbootmall.dto.CreateProductResponse;
import com.youngwu.springbootmall.repository.ProductRepository;
import com.youngwu.springbootmall.model.Product;
import com.youngwu.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductById(Integer productId) {
        return productRepository.findByProductId(productId);
    }

    @Override
    public CreateProductResponse createProduct(CreateProductRequest request) {
        Product product = new Product();

        product.setProductName(request.getProductName());
        product.setCategory(request.getCategory());
        product.setImageUrl(request.getImageUrl());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setDescription(request.getDescription());

        Date today = new Date();
        product.setCreatedDate(today);
        product.setLastModifiedDate(today);

        productRepository.save(product);

        CreateProductResponse response = new CreateProductResponse();
        response.setStatus("Success");

        return response;
    }
}
