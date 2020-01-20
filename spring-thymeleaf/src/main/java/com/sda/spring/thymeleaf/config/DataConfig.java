package com.sda.spring.thymeleaf.config;

import com.sda.spring.thymeleaf.model.Product;
import com.sda.spring.thymeleaf.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {

    @Autowired
    public ProductRepository productRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            Product product = new Product();
            product.setName("suruburi");
            product.setPrice(15);

            productRepository.save(product);
        };
    }
}
