package net.kacemi.customerservice;

import net.kacemi.customerservice.entites.Customer;
import net.kacemi.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
           customerRepository.save(Customer.builder().name("Nabil EL AMARANI").email("nabil81@gmail.com").build());
           customerRepository.save(Customer.builder().name("Ayman KACEMI").email("nabil81@gmail.com").build());
           customerRepository.save(Customer.builder().name("Mohamed YOUSSFI").email("nabil81@gmail.com").build());
        };
    }

}
