package com.dxctraining.controllers;

import com.dxctraining.dto.CustomerDto;
import com.dxctraining.entities.Customer;
import com.dxctraining.exceptions.CustomerNotFoundException;
import com.dxctraining.exceptions.InvalidArgumentException;
import com.dxctraining.services.ICustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.function.Executable;

import javax.persistence.EntityManager;


@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest
public class CustomerControllerTest {

    @Autowired
    private CustomerController controller;
    @Autowired
    private EntityManager entityManager;

    @Test
    public void testCustomerId()
    {
        String tName="vineel";
        Customer customer=new Customer();
        customer.setName(tName);
        customer=entityManager.merge(customer);
        Integer tId=customer.getId();
        CustomerDto dto=controller.findById(tId);
        Assertions.assertEquals(tName,dto.getName());
        Assertions.assertEquals(tId,dto.getId());

    }
    @Test
    public void testCustomerById()
    {
        Executable execute=()->controller.findById(64);
        Assertions.assertThrows(CustomerNotFoundException.class,execute);
    }


}
