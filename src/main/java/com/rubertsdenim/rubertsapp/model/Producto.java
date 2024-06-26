package com.rubertsdenim.rubertsapp.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Document(collection = "Inventario")
public class Producto {

    @Id
    private ObjectId idProducto;

    private String nombre;
    private String categoria;
    private int cantidad;
    private String color;

    public Producto() {
    }

    public Producto(ObjectId idProducto, String nombre, String categoria, int cantidad, String color) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.color = color;
    }

}
