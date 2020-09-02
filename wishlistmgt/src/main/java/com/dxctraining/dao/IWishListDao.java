package com.dxctraining.dao;

import com.dxctraining.entities.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IWishListDao extends JpaRepository<WishList,String>
{
    @Query("From WishList where CustomerId=:id")
    List<WishList>fetchAll(@Param("id") Integer id);
}
