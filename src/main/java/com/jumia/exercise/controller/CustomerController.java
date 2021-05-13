package com.jumia.exercise.controller;

import com.jumia.exercise.controller.dto.CustomerResponseV1;
import com.jumia.exercise.service.CustomerService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Get Many Customers filtered by Params.
     *
     * @param countryId Country Id
     * @param isValid   Get matching/non-matching regex number
     * @return List of Customer Responses
     */
    @GetMapping
    public ResponseEntity<List<CustomerResponseV1>> getMany(
            @ApiParam(name = "countryId", defaultValue = "0", allowableValues = "0,1,2,3,4", value = "Id of country, 0: Cameroon, 1: Ethiopia, 2: Morocco, 3: Mozambique, 4: Uganda")
            @RequestParam(name = "countryId", required = false) Integer countryId,
            @RequestParam(name = "state", required = false) Boolean isValid) {
        return ResponseEntity.ok(customerService.getMany(countryId, isValid));
    }

}
