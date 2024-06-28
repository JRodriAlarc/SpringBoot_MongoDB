package com.rubertsdenim.rubertsapp;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rubertsdenim.rubertsapp.model.Producto;
import com.rubertsdenim.rubertsapp.service.ProductoServicio;

@Controller
public class ControladorInicio {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/inventario")
    public String verInventario(Model model){
        List<Producto> productos = productoServicio.listarProductos();
        model.addAttribute("productos", productos);
        return "inventario";
    }

    @GetMapping("/inventario/create")
    public String agregarInventario(Model model) {
        model.addAttribute("producto", new Producto());
        return "create";
    }

    @PostMapping("/inventario/create")
    public String registrarNuevoProducto(@ModelAttribute("producto") Producto producto) {
        producto.setIdProducto(new ObjectId());
        productoServicio.guardarProducto(producto);
        return "redirect:/inventario";
    }

}
