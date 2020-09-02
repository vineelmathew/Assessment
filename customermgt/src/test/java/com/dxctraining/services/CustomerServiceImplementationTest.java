package com.dxctraining.services;

import com.dxctraining.dao.ICustomerDao;
import com.dxctraining.entities.Customer;
import com.dxctraining.exceptions.CustomerNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Import({ CustomerServiceImplementation.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerServiceImplementationTest {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private EntityManager entityManager;

    @Test
    public void CustomerByIdTest() {
        Executable execute = () -> customerService.findById(64);
        Assertions.assertThrows(CustomerNotFoundException.class, execute);
    }
    @Test
    public void CustomerNullTest()
    {
        Executable executable=new Executable() {
            @Override
            public void execute() throws Throwable {
                customerService.save(null);
            }
        };
    }
    @Test
    public void CustomerNameTest()
    {
        String name="Mathew";
        Customer customer=new Customer();
        customer.setName(name);
        Customer test=customerService.save(customer);
        Assertions.assertEquals(name,test.getName());
        TypedQuery<Customer>query=entityManager.createQuery("from Customer",Customer.class);
        List<Customer> storedCustomers=query.getResultList();
        Assertions.assertEquals(21,storedCustomers.size()); //actual value is 1, fails here
        Customer Customerdb=storedCustomers.get(0);
        Assertions.assertEquals(name,Customerdb.getName());
    }


}
