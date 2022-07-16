package com.youngwu.springbootmall.repository;

import com.youngwu.springbootmall.constant.ProductCategory;
import com.youngwu.springbootmall.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByProductId(Integer productId);

    List<Product> findByCategory(ProductCategory category, Sort sortBy);
    List<Product> findByProductNameContaining(String search, Sort sortBy);
    List<Product> findByCategoryAndProductNameContaining(ProductCategory category, String search, Sort sortBy);
}
