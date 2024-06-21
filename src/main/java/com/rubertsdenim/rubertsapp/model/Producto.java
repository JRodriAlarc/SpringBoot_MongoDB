package com.rubertsdenim.rubertsapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Document(collection = "Inventario")
public class Producto {

    @Id
    private int id;

    private String nombre;
    private String categoria;
    private int cantidad;
    private String color;
    
    public Producto(int id, String nombre, String categoria, int cantidad, String color) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.color = color;
    }

    
}
