package com.alvaro.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
// import org.springframework.web.context.annotation.RequestScope;
// import org.springframework.web.context.annotation.SessionScope;

import com.alvaro.springboot.di.app.springbootdi.models.Product;


// CONTEXTOS DE ALCANCE
// Default es singleton

// @REQUESTSCOPE Los datos ya no se alamacena en memoria no es singleton, es por usuario (por request/porpetición) cambia el contexto.
// @RequestScope

// @SESSIONSCOPE Durante varios request varias peticiones (cerramos el navegador y se reinician los datos) (ciclo de vida)
// @SessionScope

// @PRIMARY Indica que este repositorio ("porductList") es el que se va a inyectar
@Primary
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data ;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria corsair 32", 300L),
            new Product(2L, "CPU Intel Core i9", 850L),
            new Product(3L, "Teclado Razer Mini 60%", 180L),
            new Product(4L, "Motherboard Gigabyte", 490L)
        );
    }

    @Override
    public List<Product> findAll() {
        return this.data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null) ;
    }



}
