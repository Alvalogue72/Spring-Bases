package com.alvaro.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvaro.springboot.di.app.springbootdi.models.Product;
import com.alvaro.springboot.di.app.springbootdi.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    
    // Inyección mediante atributo
    // @Autowired
    // @Qualifier("productFoo")
    private ProductRepository repository;

    private Environment environment;

    @Value("${config.price.tax}")
    private Double tax;
    
    // Inyección mediante setter
    /* @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    } */
    
    // Inyección mediante constructor, el cuál no necesita de la anotación @AUTOWIRED
    // @QUALIFIER Indica que componente ("productFoo") se va inyectar
    public ProductServiceImpl(@Qualifier("productJson") ProductRepository repository, Environment environment) {
        this.repository = repository;
        this.environment = environment;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {

            System.out.println(environment.getProperty("config.price.tax", Double.class));

            Double priceTax = p.getPrice() * tax;

            // Product newProd = new Product(p.getId(), p.getName(), priceImp.longValue());
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;

            // p.setPrice(priceTax.longValue());
            // return p;

        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

}
