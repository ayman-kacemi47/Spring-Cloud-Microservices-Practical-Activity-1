package net.kacemi.inventoryservice;

import net.kacemi.inventoryservice.entites.Product;
import net.kacemi.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder().name("Computer").price(22000).quantity(23).build());
            productRepository.save(Product.builder().name("Printer").price(7888).quantity(7).build());
            productRepository.save(Product.builder().name("Smart pone").price(14000).quantity(50).build());
        };
    }
}
