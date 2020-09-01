package com.dxctraining.services;

import com.dxctraining.entities.Customer;

import java.util.List;

public interface ICustomerService {
Customer save(Customer customer);
void remove(Integer id);
List<Customer>customerlist();
Customer findById(Integer id);
List<Customer>findByName(String name);
}
