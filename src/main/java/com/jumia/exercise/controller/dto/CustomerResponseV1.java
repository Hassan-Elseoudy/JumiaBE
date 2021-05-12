package com.jumia.exercise.controller.dto;

import com.jumia.exercise.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerResponseV1 {
    private Integer id;
    private String name;
    private String phone;
    private boolean isValidPhone;
    private Integer countryId;

    /**
     * Wrap Model into DTO
     * @param customer Customer
     * @param isValidPhone If phone matches regex
     * @param countryId Country Id
     * @return CustomerResponseV1
     */
    public static CustomerResponseV1 toDto (Customer customer, boolean isValidPhone, Integer countryId){
        return new CustomerResponseV1(customer.getId(), customer.getName(), customer.getPhone(), isValidPhone, countryId);
    }

}
