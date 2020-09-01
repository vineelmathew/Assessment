package com.dxctraining.dao;

import com.dxctraining.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IProductDao extends MongoRepository<Product,String> {

Product findByName(String name);
}
