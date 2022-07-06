package com.youngwu.springbootmall.service.impl;

import com.youngwu.springbootmall.repository.ProductRepository;
import com.youngwu.springbootmall.model.Product;
import com.youngwu.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductById(Integer productId) {
        return productRepository.findByProductId(productId);
    }
}
