package com.dxctraining.controller;

import com.dxctraining.dto.CreateProduct;
import com.dxctraining.dto.ProductDto;
import com.dxctraining.entities.Product;
import com.dxctraining.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;


    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/add")
    public ProductDto addProducts(@RequestBody CreateProduct data)
    {
        String name= data.getName();
        Product product=new Product(name);
        product=productService.save(product);
        ProductDto convertDto=productDto(product);
        return convertDto;
    }

    public ProductDto productDto(Product product) {
        ProductDto dto=new ProductDto(product.getName(), product.getId());
        return dto;
    }


    @GetMapping("get/{id}")
    public ProductDto productById(@PathVariable("id") String id)
    {
        Product product=productService.findById(id);
        ProductDto convertDto=productDto(product);
        return convertDto;
    }
    @GetMapping("byname/{name}")
    public ProductDto productByName(@PathVariable("name") String name)
    {
        Product product=productService.productByName(name);
        ProductDto convertDto=productDto(product);
        return convertDto;
    }


}
