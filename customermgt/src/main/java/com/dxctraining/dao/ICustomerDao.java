package com.dxctraining.dao;

import com.dxctraining.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerDao extends JpaRepository<Customer,Integer> {
    List<Customer> findByName(String name);
}
