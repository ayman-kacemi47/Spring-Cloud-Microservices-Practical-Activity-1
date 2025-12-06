package net.kacemi.billingservice.model;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Product {
    private Long id;
    private String name;
    private int quantity;
    private double price;
}
