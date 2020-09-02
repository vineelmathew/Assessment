package com.dxctraining.services;

import com.dxctraining.entities.WishList;
import com.dxctraining.exceptions.InvalidArgumentException;
import com.netflix.discovery.converters.Auto;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Import({ WishListServiceImple.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class WishListServiceImpleTest {

    @Autowired
    private IWishListService wishListService;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void test1()
    {
        Executable executable=()->wishListService.save(null);
        Assertions.assertThrows(InvalidArgumentException.class,executable); //pass
    }

    @Test
    public void test2()
    {
      String tid="1";
      Integer tcustomerid=99;
      String tproduct="p1";
        WishList wish1=new WishList(tcustomerid,tproduct);
        wish1=wishListService.save(wish1);
        String fetchedid=wish1.getId();
        Assertions.assertEquals(tid,fetchedid); //fails
    }
}
