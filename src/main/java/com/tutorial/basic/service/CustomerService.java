package com.tutorial.basic.service;

import com.tutorial.basic.dao.CustomerDAO;
import com.tutorial.basic.exception.CustomerNotFoundException;
import com.tutorial.basic.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer addCustomer(Customer customer) {
        return customerDAO.save(customer);
    }

    public List<Customer> getCustomers() {   // vd016
        return customerDAO.findAll();
    }

    public Customer getCustomer(int customerId) {

        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);

        if(!optionalCustomer.isPresent()){
            throw new CustomerNotFoundException("Customer not available..."); //vdo20
        }
        return optionalCustomer.get(); //vdo 17
    }

    public Customer updateCustomer(int customerId, Customer customer) {
        customer.setCustomerId(customerId);
        return customerDAO.save(customer); //vdo18
    }

    public void deleteCustomer(int customerId) {
        customerDAO.deleteById(customerId); //vdo17
    }

}

