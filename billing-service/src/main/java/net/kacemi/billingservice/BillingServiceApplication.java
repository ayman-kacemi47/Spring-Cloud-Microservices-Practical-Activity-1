package net.kacemi.billingservice;

import net.kacemi.billingservice.entites.Bill;
import net.kacemi.billingservice.entites.ProductItem;
import net.kacemi.billingservice.repositories.BillRepository;
import net.kacemi.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx,BillRepository billRepository,ProductItemRepository productRepository) {

        return args -> {
            List<Long> customerIds = List.of(1L, 2L, 3L);
            List<Long> productIds = List.of(1L, 2L, 3L);
            customerIds.forEach(customerId -> {
                    Bill bill = Bill.builder().billingDate(new Date()).customerId(customerId).build();
                    billRepository.save(bill);
                    productIds.forEach(productId -> {
                        ProductItem productItem = new ProductItem();
                        productItem.setPrice(1000+Math.random()*6000);
                        productItem.setQuantity(1 + new Random().nextInt(20));
                        productItem.setProductId(productId);
                        productItem.setBill(bill);
                        productRepository.save(productItem);
                    });

            });
        };
    }
}
