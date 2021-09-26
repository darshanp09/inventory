package com.io.management.dao;

import com.io.management.model.Pro;
import com.io.management.model.Product;

import java.util.List;


public interface ProductDao {

    void addProduct(Product product);

    Product getProductById(int id);

    List<Product> getAllProducts();

    void deleteProduct(int id);

    List<Product> getProductBySearch(String productSearchName);

    public List<Pro> getAllReportProduct();

    void truncateData();
}
