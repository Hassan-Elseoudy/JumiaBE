package com.jumia.exercise.service;

import com.jumia.exercise.controller.dto.CustomerResponseV1;

import java.util.List;

public interface CustomerService {

    List<CustomerResponseV1> getMany(Integer countryId, Boolean isValid, Integer page, Integer size);
}
