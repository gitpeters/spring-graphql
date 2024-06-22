package com.peters.services;

import com.peters.dtos.ProductDto;
import com.peters.dtos.ProductResponse;
import com.peters.models.Product;
import com.peters.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements IProductService{
    private final ProductRepository productRepository;
    @Override
    public List<ProductResponse> getAllProducts() {
        log.info("Retrieve all products");
        List<Product> products = productRepository.findAll();
        if(!products.isEmpty()){
            return products.stream().map(this::mapProductToProductResponse).toList();
        }
        return List.of();
    }

    private ProductResponse mapProductToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .productCategory(product.getProductCategory())
                .stock(product.getStock())
                .price(product.getPrice())
                .createdAt(product.getCreatedAt())
                .build();
    }

    @Override
    public List<ProductResponse> getProductsByCategory(String category) {
        log.info("Retrieve all products by category");
        List<Product> products = productRepository.findAllByProductCategory(category);
        if(!products.isEmpty()){
            return products.stream().map(this::mapProductToProductResponse).toList();
        }
        return List.of();
    }

    @Override
    public ProductResponse updateProductStock(String id, int stock) {
        log.info("Update product stock");
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("No product found for this id ->"+id));
        product.setStock(product.getStock()+stock);
        productRepository.save(product);
        return mapProductToProductResponse(product);
    }

    @Override
    public ProductResponse saveNewProduct(ProductDto productDto) {
        Product product = buildProduct(productDto);
        productRepository.save(product);
        return mapProductToProductResponse(product);
    }

    private Product buildProduct(ProductDto productDto) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setProductCategory(productDto.getProductCategory());
        product.setStock(productDto.getStock());
        return product;
    }

    @Override
    public void deleteProduct(String id) {
        log.info("Delete product");
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("No product found for this id ->"+id));
        productRepository.delete(product);
    }
}
