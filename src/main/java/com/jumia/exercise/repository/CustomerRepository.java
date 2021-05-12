package com.jumia.exercise.repository;

import com.jumia.exercise.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /**
     * Find All Customers By Number Starting with specific code.
     * @param code country code
     * @return Set of customer.
     */
    Set<Customer> findAllByPhoneStartingWith(String code);
}
