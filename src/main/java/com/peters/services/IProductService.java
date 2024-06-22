package com.peters.services;

import com.peters.dtos.ProductDto;
import com.peters.dtos.ProductResponse;
import com.peters.models.Product;

import java.util.List;

public interface IProductService {
    List<ProductResponse> getAllProducts();
    List<ProductResponse> getProductsByCategory(String category);
    ProductResponse updateProductStock(String id, int stock);
    ProductResponse saveNewProduct(ProductDto productDto);
    void deleteProduct(String id);
}
