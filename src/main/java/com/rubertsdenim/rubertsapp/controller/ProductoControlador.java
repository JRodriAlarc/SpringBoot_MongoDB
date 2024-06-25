package com.rubertsdenim.rubertsapp.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubertsdenim.rubertsapp.exception.RecursoNoEncontrado;
import com.rubertsdenim.rubertsapp.model.Producto;
import com.rubertsdenim.rubertsapp.service.ProductoServicio;

@RestController
@RequestMapping("/inventario")
//@Cross0rigin (value = "http://localhost:5500")
public class ProductoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);
    
    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> obteneProductos(){
        List<Producto> productos = this.productoServicio.listarProductos();
        logger.info("Productos Obtenidos: ");
        productos.forEach((producto -> logger.info(producto.toString())));
        return productos;
    }
    
    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto){
        logger.info("Producto a Agregar" + producto);
        return this.productoServicio.guardarProducto(producto);
    }
    
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable ObjectId id){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        
        if(producto != null)
            return ResponseEntity.ok(producto);
        else
            throw new RecursoNoEncontrado("No se encontro el Producto con ID: " + id);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable ObjectId id, @RequestBody Producto productoRecibido){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        producto.setNombre(productoRecibido.getNombre());
        producto.setColor(productoRecibido.getColor());
        producto.setCantidad(productoRecibido.getCantidad());
        producto.setCategoria(productoRecibido.getCategoria());
        this.productoServicio.guardarProducto(producto);
        return ResponseEntity.ok(producto);
    }
}
