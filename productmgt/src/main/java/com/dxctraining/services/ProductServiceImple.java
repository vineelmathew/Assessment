package com.dxctraining.services;

import com.dxctraining.dao.IProductDao;
import com.dxctraining.entities.Product;
import com.dxctraining.exceptions.InvalidArgumentException;
import com.dxctraining.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImple implements IProductService{

    @Autowired
    private IProductDao productDao;

    @Override
    public Product save(Product product) {
        validate(product);
        product=productDao.save(product);
        return product;
    }

    private void validate(Product product) {
        if(product==null)
        {
            throw new InvalidArgumentException("product cant be null");
        }
    }

    private void validate(String id)
    {
        if(id==null || id.isEmpty())
        {
            throw new InvalidArgumentException("ID can't be null or empty");
        }
    }


    @Override
    public void remove(String id) {
        productDao.deleteById(id);
    }

    @Override
    public Product findById(String id) {
        validate(id);
        Optional<Product>product=productDao.findById(id);
        if(!product.isPresent())
        {
            throw new ProductNotFoundException("product not found="+id);
        }
        Product product1=product.get();
        return product1;
    }

    @Override
    public Product productByName(String name) {
     validate(name);
     Product products=productDao.findByName(name);
     return products;
    }
}
