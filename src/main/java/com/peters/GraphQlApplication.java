package com.peters;

import com.peters.models.Product;
import com.peters.repositories.ProductRepository;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class GraphQlApplication {


	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}

//	@Bean
//	CommandLineRunner initProductRecords() {
//		return args -> {
//			List<Product> products = new ArrayList<>(Arrays.asList(
//					new Product("Apple iPhone 14", "Electronics", 999.99, 150),
//					new Product("Samsung Galaxy S22", "Electronics", 849.99, 200),
//					new Product("Sony WH-1000XM4", "Electronics", 349.99, 120),
//					new Product("Nike Air Max 270", "Footwear", 129.99, 300),
//					new Product("Adidas Ultraboost 21", "Footwear", 179.99, 250),
//					new Product("Levi's 501 Original Jeans", "Clothing", 69.99, 400),
//					new Product("Patagonia Nano Puff Jacket", "Clothing", 199.99, 150),
//					new Product("Apple MacBook Pro 14", "Electronics", 1999.99, 80),
//					new Product("Dell XPS 13", "Electronics", 1099.99, 100),
//					new Product("Sony PlayStation 5", "Electronics", 499.99, 50),
//					new Product("Nintendo Switch", "Electronics", 299.99, 180),
//					new Product("Canon EOS R5", "Electronics", 3899.99, 40),
//					new Product("Bose QuietComfort 35 II", "Electronics", 299.99, 130),
//					new Product("Apple Watch Series 7", "Electronics", 429.99, 220),
//					new Product("Samsung Galaxy Tab S7", "Electronics", 649.99, 140),
//					new Product("Dyson V11 Vacuum Cleaner", "Home Appliances", 599.99, 90),
//					new Product("KitchenAid Stand Mixer", "Home Appliances", 399.99, 60),
//					new Product("Sony Bravia 65-inch OLED TV", "Electronics", 2499.99, 35),
//					new Product("GoPro HERO9 Black", "Electronics", 449.99, 110),
//					new Product("Microsoft Surface Pro 8", "Electronics", 1099.99, 95)
//			));
//			productRepository.saveAll(products);
//		};
//	}
}
