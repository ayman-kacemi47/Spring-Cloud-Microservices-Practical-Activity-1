package net.kacemi.billingservice.repositories;

import net.kacemi.billingservice.entites.Bill;
import net.kacemi.billingservice.entites.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    List<ProductItem> findByBillId(Long billId);

    List<ProductItem> findByBill(Bill bill);
}
