package com.dxctraining.controllers;

import com.dxctraining.dto.CreateWishList;
import com.dxctraining.dto.CustomerDto;
import com.dxctraining.dto.ProductDto;
import com.dxctraining.dto.WishListDto;
import com.dxctraining.entities.WishList;
import com.dxctraining.services.IWishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wishlists")
public class WishListController {

    @Autowired
    private IWishListService wishListService;


    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public WishListDto addWishLists(@RequestBody CreateWishList data) {
        String productId = data.getProductId();
        Integer customerId = data.getCustomerId();
        WishList wishList = new WishList(customerId, productId);
        CustomerDto customerDto = getCustomerById(customerId);
        ProductDto productDto = getProductById(productId);
        wishList = wishListService.save(wishList);
        WishListDto convDto = convertToDto(wishList, productId, customerId, customerDto.getName(),
                productDto.getName());
        return convDto;
    }

    private WishListDto convertToDto(WishList wishList, String productId, Integer customerId,
                                     String customername, String productname) {
        WishListDto dto = new WishListDto(wishList.getId(),
                productId, customerId);
        dto.setCustomerName(customername);
        dto.setProductName(productname);
        return dto;
    }

    public ProductDto getProductById(String productId) {
        String url = "http://localhost:7777/products/get/" + productId;
        ProductDto dto = restTemplate.getForObject(url, ProductDto.class);
        return dto;
    }

    public CustomerDto getCustomerById(Integer customerId) {
        String url = "http://localhost:8686/customers/get/" + customerId;
        CustomerDto dto = restTemplate.getForObject(url, CustomerDto.class);
        return dto;
    }
    @GetMapping("get/{id}")
    public List<WishListDto> wishlistByCustomerId(@PathVariable("id") Integer customerId)
    {
        List<WishList>wishLists=wishListService.fetchAll(customerId);
        List<WishListDto>result=new ArrayList<>();
        for(WishList wishList:wishLists)
        {
            String productId=wishList.getProductId();
            Integer cid=wishList.getCustomerId();
            ProductDto productDto = getProductById(productId);
            CustomerDto customerDto=getCustomerById(cid);
            WishListDto dto = new WishListDto(wishList.getId(),
                    productId, customerId);
            dto.setCustomerName(customerDto.getName());
            dto.setProductName(productDto.getName());
            result.add(dto);
        }
        return result;
    }


}
