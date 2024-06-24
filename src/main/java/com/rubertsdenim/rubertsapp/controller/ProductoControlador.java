package com.rubertsdenim.rubertsapp.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
