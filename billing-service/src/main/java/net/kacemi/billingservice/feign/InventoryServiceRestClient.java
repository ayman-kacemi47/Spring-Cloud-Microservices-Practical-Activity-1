package net.kacemi.billingservice.feign;

import net.kacemi.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("inventory-service")
public interface InventoryServiceRestClient {
    @GetMapping("/products/{id}")
    Product findProductById(@PathVariable("id") Long id);
}
