package com.dxctraining.services;

import com.dxctraining.dao.IWishListDao;
import com.dxctraining.entities.WishList;
import com.dxctraining.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Transactional
@Service
public class WishListServiceImple implements IWishListService{

    @Autowired
    private IWishListDao wishListDao;

    @Override
    public WishList save(WishList wishList) {
        validate(wishList);
        wishList.setId(generateId());
        wishList=wishListDao.save(wishList);
        return wishList;
    }
    @Override
    public List<WishList> fetchAll(Integer id) {
            List<WishList> wishLists = wishListDao.fetchAll(id);
            return wishLists;
        }

    public void validate(WishList wishList) {
        if(wishList==null)
        {
            throw new InvalidArgumentException("wishlist cant be null");
        }
    }
    public String generateId()
    {
        Random random=new Random();
        int gen= random.nextInt(1000);
        return "WL"+gen+"";
    }
}
