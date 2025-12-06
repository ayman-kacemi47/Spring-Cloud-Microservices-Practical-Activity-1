package net.kacemi.billingservice.web;


import lombok.Getter;
import net.kacemi.billingservice.entites.Bill;
import net.kacemi.billingservice.entites.ProductItem;
import net.kacemi.billingservice.feign.CustomerServiceRestClient;
import net.kacemi.billingservice.feign.InventoryServiceRestClient;
import net.kacemi.billingservice.model.Customer;
import net.kacemi.billingservice.repositories.BillRepository;
import net.kacemi.billingservice.repositories.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerServiceRestClient customerServiceRestClient;
    @Autowired
    private InventoryServiceRestClient inventoryServiceRestClient;

    @GetMapping("/bills/{id}")
    public Bill getBill(@PathVariable long id) {
        Bill bill = billRepository.findById(id).get();

//        List<ProductItem> productItems = productItemRepository.findByBill(bill);
//        bill.setProductItems(productItems);

        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(inventoryServiceRestClient.findProductById(productItem.getProductId()));
        });

        Customer customer = customerServiceRestClient.findCustomerById(bill.getCustomerId());
         bill.setCustomer(customer);


        return bill;

    }

}
