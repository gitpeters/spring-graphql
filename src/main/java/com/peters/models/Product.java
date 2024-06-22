package com.peters.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Table(name = "products")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String productName;
    private String productCategory;
    private Double price;
    private Integer stock;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public Product(String productName, String productCategory, Double price, Integer stock) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.price = price;
        this.stock = stock;
    }

    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
        modifiedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        modifiedAt = LocalDateTime.now();
    }


}
