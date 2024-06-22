package com.peters.controllers;

import com.peters.dtos.ProductDto;
import com.peters.dtos.ProductResponse;
import com.peters.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;

    @QueryMapping
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

    @QueryMapping
    public List<ProductResponse> getProductsByCategory(@Argument String category){
        return productService.getProductsByCategory(category);
    }

    @MutationMapping
    public ProductResponse saveNewProduct(
            @Argument String productName,
            @Argument String productCategory,
            @Argument Float price,
            @Argument Integer stock) {

        ProductDto productDto = new ProductDto();
        productDto.setProductName(productName);
        productDto.setProductCategory(productCategory);
        productDto.setPrice(Double.valueOf(price));
        productDto.setStock(stock);

        return productService.saveNewProduct(productDto);
    }

    @MutationMapping
    public ProductResponse updateProductStock(@Argument String id, @Argument int stock){
        return productService.updateProductStock(id, stock);
    }

    @MutationMapping
    public void deleteProduct(@Argument String id){
        productService.deleteProduct(id);
    }
}
