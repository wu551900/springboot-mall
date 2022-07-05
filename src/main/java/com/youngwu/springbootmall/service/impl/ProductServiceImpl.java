package com.youngwu.springbootmall.service.impl;

import com.youngwu.springbootmall.dao.ProductDao;
import com.youngwu.springbootmall.model.Product;
import com.youngwu.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
