package com.example.rpimeasure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // marks class as request handler
public class DemoController {

    @Autowired // tells spring to inject customerRepository bean
    private CustomerRepository customerRepository;

    @PostMapping("/add") // maps method to POST request
    public String addCustomer(@RequestParam String first, @RequestParam String last) {
        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customerRepository.save(customer);
        return "Added new customer to repo!";
    }

    @GetMapping("/list") // maps method to GET request
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        // PathVariable maps value in place of the id from the URL
        return customerRepository.findCustomerById(id);
    }
}
