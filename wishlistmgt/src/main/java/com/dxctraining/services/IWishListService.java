package com.dxctraining.services;

import com.dxctraining.entities.WishList;

import java.util.List;

public interface IWishListService {
    WishList save(WishList wishList);
    List<WishList>fetchAll(Integer id);
}
