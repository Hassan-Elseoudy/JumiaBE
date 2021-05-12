package com.jumia.exercise.service;

import com.jumia.exercise.model.Country;

public interface CountryService {

    /**
     * Find country with specific customer number.
     * @param number customer number
     * @return Country
     */
    Country getCountryByNumber(String number);

    /**
     * Used to validate if customer's number matching some country regex.
     * @param number customer number
     * @param regex country number's regex
     * @return true if matching, false if not.
     */
    boolean isValidPhoneNumber(String number, String regex);

    /**
     * get country by Id
     * @param id country id
     * @return Country
     */
    Country getOne(Integer id);

}
