package com.youngwu.springbootmall.controller;


import com.youngwu.springbootmall.constant.OrderByColumn;
import com.youngwu.springbootmall.constant.ProductCategory;
import com.youngwu.springbootmall.dto.product.*;
import com.youngwu.springbootmall.model.Product;
import com.youngwu.springbootmall.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@Api(value = "產品功能", tags = {"產品功能"})
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("查詢產品列表")
    @GetMapping("/products")
    public List<Product> getProducts(
            // 查詢條件 Filtering
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,

            // 排序 Sorting
            @RequestParam(defaultValue = "createdDate") OrderByColumn orderBy,
            @RequestParam(defaultValue = "desc") String sort,

            //分頁
            @RequestParam(defaultValue = "0") @Min(0) @Max(50) Integer page,
            @RequestParam(defaultValue = "24") @Min(1) @Max(40) Integer pageSize
    ) {
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setPage(page);
        productQueryParams.setPageSize(pageSize);


        return productService.getProducts(productQueryParams);
    }

    @ApiOperation("查詢產品")
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);

        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @ApiOperation("新增產品")
    @PostMapping("/products")
    public CreateProductResponse createProduct(@RequestBody @Valid CreateProductRequest request) {
        return productService.createProduct(request);
    }

    @ApiOperation("修改產品")
    @PostMapping("/updateProducts")
    public UpdateProductResponse updateProduct(@RequestBody @Valid UpdateProductRequest request) {
        return productService.updateProduct(request);
    }

    @ApiOperation("刪除產品")
    @PostMapping("deleteProducts")
    public DeleteProductResponse deleteProduct(@RequestBody @Valid DeleteProductRequest request) {
        return productService.deleteProduct(request);
    }
}
