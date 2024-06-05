package com.alvaro.springboot.di.app.springbootdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.alvaro.springboot.di.app.springbootdi.repositories.ProductRepositoriesJson;
import com.alvaro.springboot.di.app.springbootdi.repositories.ProductRepository;

@Configuration
@PropertySource(value = "classpath:config.properties", encoding = "UTF-8")
public class AppConfig {

    /* @Bean("productJson")
    ProductRepository productRepository() {
        return new ProductRepositoriesJson();
    } */

    @Value("classpath:json/product.json")
    private Resource resource;

    @Bean("productJson")
    ProductRepository productRepository() {
        return new ProductRepositoriesJson(resource);
    }


}
