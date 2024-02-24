package com.example.inventoryservice;

import com.example.inventoryservice.Entities.Product;
import com.example.inventoryservice.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import java.util.List ;
@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
          productRepository.saveAll(List.of(
            Product.builder().name("iphone 15 pro").price(12000).qty(10).build(),
            Product.builder().name("S24 ultra").price(14000).qty(20).build(),
            Product.builder().name("tufaha").price(12).qty(40).build()
          ));
        };
    }
}
