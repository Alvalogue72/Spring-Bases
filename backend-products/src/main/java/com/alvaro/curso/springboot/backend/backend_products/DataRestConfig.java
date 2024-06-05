package com.alvaro.curso.springboot.backend.backend_products;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.alvaro.curso.springboot.backend.backend_products.entities.Product;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    // PARA QUE APAREZCAN LOS ID EN EL JSON AL UTILIZAR @REPOSITORYRESTRESOURCE (API SPRING DATA REST)
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Product.class);
    }

    
}
