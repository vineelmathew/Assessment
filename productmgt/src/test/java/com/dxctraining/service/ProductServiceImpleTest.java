package com.dxctraining.service;

import com.dxctraining.dao.IProductDao;
import com.dxctraining.dto.ProductDto;
import com.dxctraining.entities.Product;
import com.dxctraining.exceptions.InvalidArgumentException;
import com.dxctraining.services.IProductService;
import com.dxctraining.services.ProductServiceImple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@DataMongoTest
@Import(ProductServiceImple.class)
public class ProductServiceImpleTest {

    @Autowired
    private IProductService iProductService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test1_Name() {
        Executable executable = () -> iProductService.productByName(null);
        Assertions.assertThrows(InvalidArgumentException.class, executable);
    }

    @Test
    public void productTest() {
        String productName = "iphone";
        Product product = new Product(productName);
        iProductService.save(product);
        Product tId = iProductService.findById(product.getId());
        Assertions.assertEquals(null, tId.getId());//fails
        Executable executable = () -> iProductService.findById(null);
        Assertions.assertThrows(InvalidArgumentException.class, executable);
    }

    @Test
    public void testId() {
        String name = "samsung";
        Product product = new Product(name);
        iProductService.save(product);
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        List<Product> nameslist = mongoTemplate.find(query, Product.class);
        Assertions.assertEquals(name,nameslist.get(0).getName());
    }


}
