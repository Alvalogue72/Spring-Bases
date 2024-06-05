package com.alvaro.curso.springboot.di.factura.springbootdifactura.models;

public class Item {

    private Product product;
    private Integer quantity;

    public Item() {
    }

    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    /* Cuando devuelves un objeto desde un controlador en Spring, por defecto, 
    Spring serializa todas las propiedades del objeto a JSON,
    incluyendo los valores devueltos por los métodos getters. 
    Esto significa que incluso si getImporte() es un método de acceso
    que calcula un valor y no es un atributo real de la clase, 
    Spring lo incluirá en la respuesta JSON si lo llama durante la serialización.
    Si cambias el nombre de tu método de getImporte a mostrarImporte() ya no saldrá en la respuesta. 
    Todos los métodos get seran serializados. */
    public int getImporte() {
        return quantity * product.getPrice();
    }

}
