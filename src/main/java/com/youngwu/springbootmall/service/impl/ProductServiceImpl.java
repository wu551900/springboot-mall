package com.youngwu.springbootmall.service.impl;

import com.youngwu.springbootmall.constant.ProductCategory;
import com.youngwu.springbootmall.dto.*;
import com.youngwu.springbootmall.model.Product;
import com.youngwu.springbootmall.repository.ProductRepository;
import com.youngwu.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        ProductCategory category = productQueryParams.getCategory();
        String search = productQueryParams.getSearch();

        if (category != null && search != null) {
            return productRepository.findByCategoryAndProductNameContaining(category, search);
        }

        if (category != null) {
            return productRepository.findByCategory(category);
        }

        if (search != null) {
            return productRepository.findByProductNameContaining(search);
        }
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer productId) {
        return productRepository.findByProductId(productId);
    }

    @Override
    public CreateProductResponse createProduct(CreateProductRequest request) {

        Product product = new Product();
        setProductInfo(product, request.getProductName(), request.getCategory(), request.getImageUrl(), request.getPrice(), request.getStock(), request.getDescription());

        Date now = new Date();
        product.setCreatedDate(now);
        product.setLastModifiedDate(now);

        productRepository.save(product);

        CreateProductResponse response = new CreateProductResponse();
        response.setStatus("Success");

        return response;
    }

    @Override
    public UpdateProductResponse updateProduct(UpdateProductRequest request) {

        Optional<Product> productOptional = productRepository.findById(Integer.valueOf(request.getProductId()));
        UpdateProductResponse response = new UpdateProductResponse();

        // 檢查產品是否存在
        if (!productOptional.isEmpty()) {
            Product product = productOptional.get();
            setProductInfo(product, request.getProductName(), request.getCategory(), request.getImageUrl(), request.getPrice(), request.getStock(), request.getDescription());

            Date now = new Date();
            product.setLastModifiedDate(now);

            productRepository.save(product);
            response.setStatus("Update Success");
        } else {
            response.setStatus("Update failed");
        }
        return response;
    }

    @Override
    public DeleteProductResponse deleteProduct(DeleteProductRequest request) {

        Optional<Product> productOptional = productRepository.findById(Integer.valueOf(request.getProductId()));

        DeleteProductResponse response = new DeleteProductResponse();

        if (!productOptional.isEmpty()) {
            productRepository.deleteById(Integer.valueOf(request.getProductId()));
            response.setStatus("Delete Success");
        } else {
            response.setStatus("Delete failed");
        }
        return response;
    }

    private void setProductInfo(Product product, String productName, ProductCategory category, String imageUrl, Integer price, Integer stock, String description) {
        product.setProductName(productName);
        product.setCategory(category);
        product.setImageUrl(imageUrl);
        product.setPrice(price);
        product.setStock(stock);
        product.setDescription(description);
    }
}
