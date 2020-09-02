package com.dxctraining.controllers;

import com.dxctraining.dto.CreateWishList;
import com.dxctraining.dto.WishListDto;
import com.dxctraining.entities.WishList;
import com.dxctraining.services.IWishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wishlists")
public class WishListController {

    @Autowired
    private IWishListService wishListService;

    @PostMapping("/add")
    public WishListDto addWishLists(@RequestBody CreateWishList data) {
        String productId = data.getProductId();
        Integer customerId = data.getCustomerId();
        WishList wishList = new WishList(customerId, productId);
        wishList = wishListService.save(wishList);
        WishListDto convDto = convertToDto(wishList);
        return convDto;
    }

    public WishListDto convertToDto(WishList wishList) {
        WishListDto dto = new WishListDto(wishList.getId(), wishList.getProductId(), wishList.getCustomerId());
        return dto;
    }

    @GetMapping("/get/{id}")
    public List<WishListDto> fetchAll(@PathVariable("id")Integer id)
    {
        List<WishList> list=wishListService.fetchAll(id);
        List<WishListDto>res=fetchAllList(list);
        return res;
    }

    public List<WishListDto> fetchAllList(List<WishList> list) {
        List<WishListDto>fetchedlist=new ArrayList<>();
        for(WishList wishList:list)
        {
            WishListDto convDto = convertToDto(wishList);
            fetchedlist.add(convDto);
        }
        return fetchedlist;
        }
}
