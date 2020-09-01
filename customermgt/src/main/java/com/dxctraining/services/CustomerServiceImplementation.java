package com.dxctraining.services;

import com.dxctraining.dao.ICustomerDao;
import com.dxctraining.entities.Customer;
import com.dxctraining.exceptions.CustomerNotFoundException;
import com.dxctraining.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CustomerServiceImplementation implements ICustomerService{

    @Autowired
    private ICustomerDao customerDao;


    @Override
    public Customer save(Customer customer) {
        validate(customer);
        customer=customerDao.save(customer);
        return customer;
    }

    private void validate(Customer customer) {
        if(customer==null)
        {
            throw new InvalidArgumentException("customer cant be null");
        }
    }

    @Override
    public void remove(Integer id) {
        customerDao.deleteById(id);

    }

    @Override
    public List<Customer> customerlist() {
        List<Customer>list=customerDao.findAll();
        return list;
    }
    @Override
    public Customer findById(Integer id) {
      Optional<Customer> optional=customerDao.findById(id);
      if(!optional.isPresent())
      {
          throw new CustomerNotFoundException("customer not found at="+id);
      }
      Customer customer= optional.get();
      return customer;
    }

    public List<Customer> findByName(String name)
    {
        List<Customer>list=customerDao.findByName(name);
        return list;
    }
}
