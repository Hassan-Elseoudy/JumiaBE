package com.jumia.exercise.repository;

import com.jumia.exercise.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

    /**
     * Find All Customers By Number Starting with specific code.
     * @param code country code
     * @param pageable paged list
     * @return Page of customer.
     */
    Page<Customer> findAllByPhoneStartingWith(String code, Pageable pageable);

    /**
     * Find customers paginated
     * @param pageable paged list
     * @return Page of customer
     */
    Page<Customer> findAll(Pageable pageable);
}
