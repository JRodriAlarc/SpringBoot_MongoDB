package com.rubertsdenim.rubertsapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.rubertsdenim.rubertsapp.model.Producto;

public interface ProductoRepositorio extends MongoRepository<Producto, Integer>{

}
