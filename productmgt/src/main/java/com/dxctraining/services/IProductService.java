package com.dxctraining.services;

import com.dxctraining.entities.Product;

import java.util.List;

public interface IProductService {
    Product save(Product product);
    void remove(String id);
    Product findById(String id);
    Product productByName(String name);
}
