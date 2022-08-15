package com.tutorial.basic.service;

import com.tutorial.basic.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Component
public class CustomerService {

    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer){
        customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerList.add(customer);
        customerIdCount++;
        return customer;
    }

    public List<Customer> getCustomer(){
        return customerList;
    }

    public Customer getCustomer(int customerId){
        return customerList
                .stream()
                .filter(customer -> customer.getCustomerId() == customerId)
                .findFirst()
                .get();
    }

    public Customer updateCustomer(int customerId, Customer customer){
             customerList
                    .stream()
                    .forEach(customer1 -> {
                        if(customer1.getCustomerId() == customerId){
                            customer1.setCustomerFirstName(customer.getCustomerFirstName());
                            customer1.setCustomerLastName(customer.getCustomerLastName());
                            customer1.setCustomerEmail(customer.getCustomerEmail());
                        }
                    });
             return customerList
                     .stream()
                     .filter(customer1 -> customer1.getCustomerId() == customerId)
                     .findFirst()
                     .get();
    }

    public void deleteCustomer(int customerId){
        customerList
                .stream()
                .forEach(customer -> {
                    if(customer.getCustomerId() == customerId) {
                        customerList.remove(customer);
                    }
                });
    }

}
