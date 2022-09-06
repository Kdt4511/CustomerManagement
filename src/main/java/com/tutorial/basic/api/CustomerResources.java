package com.tutorial.basic.api;

import com.tutorial.basic.model.Customer;
import com.tutorial.basic.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResources {

    @Autowired
    private CustomerService customerService;
//video 7
    @PostMapping //localhost:8080/customers --> and then give values
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    //vdo8
    @GetMapping //localhost:8080/customers
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }
    @GetMapping(value = "/{customerId}") //localhost:8080/customers/2 (2 is here customerId)
    public Customer getCustomer(@PathVariable("customerId") int customerId){
        return customerService.getCustomer(customerId);
    }

    //vdo9 update using put mapping
    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer){
        return customerService.updateCustomer(customerId, customer);
    }

    //vdo10
    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId){
        customerService.deleteCustomer(customerId);
    }
}
