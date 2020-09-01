package com.dxctraining.controllers;

import com.dxctraining.dto.CreateSupplier;
import com.dxctraining.dto.CustomerDto;
import com.dxctraining.entities.Customer;
import com.dxctraining.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

@Autowired
    private ICustomerService customerService;

@PostMapping(value = "/add")
public CustomerDto addSupplier(@RequestBody CreateSupplier data)
{
String name= data.getName();
Customer customer=new Customer(name);
customer=customerService.save(customer);
CustomerDto res=customerDto(customer);
return res;
}
    public CustomerDto customerDto(Customer customer) {
     CustomerDto convDto=new CustomerDto(customer.getId(),customer.getName());
     return convDto;
    }

    @GetMapping("/get/{id}")
    public CustomerDto findById(@PathVariable("id") Integer id)
    {
        Customer customer= customerService.findById(id);
        CustomerDto res=customerDto(customer);
        return  res;
    }
    @GetMapping("/byname/{name}")
    public List<CustomerDto> findByName(@PathVariable("name") String name)
    {
       List<Customer>list=customerService.findByName(name);
       List<CustomerDto>res=CustomerNameList(list);
       return res;
    }

    public List<CustomerDto> CustomerNameList(List<Customer> list) {
    List<CustomerDto>names=new ArrayList<>();
    for(Customer customer:list)
    {
        CustomerDto res=customerDto(customer);
        names.add(res);
    }
    return names;
    }
}
