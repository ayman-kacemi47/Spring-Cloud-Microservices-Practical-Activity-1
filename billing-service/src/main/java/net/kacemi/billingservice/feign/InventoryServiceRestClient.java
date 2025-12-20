package net.kacemi.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.kacemi.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("inventory-service")
public interface InventoryServiceRestClient {
    @GetMapping("/products/{id}")
    @CircuitBreaker(name = "inv-service",fallbackMethod = "getDefaultProduct")
    Product findProductById(@PathVariable("id") Long id);


    default Product getDefaultProduct(Long id, Exception e){
        e.printStackTrace();
      return new Product(id,null,0,0);
    };
}
