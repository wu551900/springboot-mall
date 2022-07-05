package com.youngwu.springbootmall.dao;

import com.youngwu.springbootmall.model.Product;

public interface ProductDao {


    Product getProductById(Integer productId);
}
