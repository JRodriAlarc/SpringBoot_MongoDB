package com.rubertsdenim.rubertsapp.service;

import java.util.List;
import org.bson.types.ObjectId;
import com.rubertsdenim.rubertsapp.model.Producto;

public interface IProductoServicio {

    public List<Producto> listarProductos();

    public Producto buscarProductoPorId(ObjectId idProducto);

    public void guardarProducto(Producto producto);

    public void eliminarProductoPorId(ObjectId idProducto);
}
