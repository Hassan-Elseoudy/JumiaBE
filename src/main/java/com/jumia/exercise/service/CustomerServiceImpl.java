package com.jumia.exercise.service;

import com.jumia.exercise.controller.dto.CustomerResponseV1;
import com.jumia.exercise.model.Country;
import com.jumia.exercise.model.Customer;
import com.jumia.exercise.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CountryService countryService;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CountryService countryService, CustomerRepository customerRepository) {
        this.countryService = countryService;
        this.customerRepository = customerRepository;
    }

    /**
     * Used to get many customers with specified filters.
     * @param countryId filter by country Id.
     * @param state filter by state (valid regex number or not)
     * @return List of customers.
     */
    @Override
    public List<CustomerResponseV1> getMany(Integer countryId, Boolean state) {
        List<Customer> customers = new ArrayList<>();

        if (countryId != null) { // If country filter is activated, then get customers by code.
            customers.addAll(customerRepository.findAllByPhoneStartingWith("(" + countryService.getOne(countryId).getCode() + ")"));
        }

        if (state != null) { // If we have previous filters, we need to filter the previous result by the state.
            customers = customers.stream().filter(customer -> isMatchingState(customer.getPhone(), state)).collect(Collectors.toList());
            if (countryId == null) // If we don't have any filters activated, then we should get all customers and filter by state.
                customers.addAll(customerRepository.findAll().stream().filter(customer -> isMatchingState(customer.getPhone(), state)).collect(Collectors.toList()));
        }

        if (state == null && countryId == null) { // There's no Filtration Activated, Just find Customers.
            customers.addAll(customerRepository.findAll());
        }

        return customers
                .stream()
                .map(customer -> {
                    Country customerCountry = countryService.getCountryByNumber(customer.getPhone());
                    return CustomerResponseV1.toDto(customer, countryService.isValidPhoneNumber(customer.getPhone(), customerCountry.getRegex()), customerCountry.getId());
                }).collect(Collectors.toList()); // Wrap Model into Dto with state and country Id.
    }

    private boolean isMatchingState(String number, boolean isValidState) {
        Country customerCountry = countryService.getCountryByNumber(number);
        return isValidState == countryService.isValidPhoneNumber(number, customerCountry.getRegex());
    }

}
