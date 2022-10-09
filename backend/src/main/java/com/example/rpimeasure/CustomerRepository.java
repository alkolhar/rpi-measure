package com.example.rpimeasure;

import org.springframework.data.repository.CrudRepository;

/**
 * Spring Data JPA will derive a query based on this method's signatures
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Customer findCustomerById(Integer id);
}
