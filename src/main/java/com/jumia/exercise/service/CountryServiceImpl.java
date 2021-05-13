package com.jumia.exercise.service;

import com.jumia.exercise.model.Country;
import com.jumia.exercise.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl (CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    /**
     * Find country with specific customer number, we need
     * to split over the user number to get the first part of number (code)
     * @param number customer number
     * @return Country
     * @throws NoSuchElementException  If there's no such Country with code.
     */
    @Override
    public Country getCountryByNumber(String number) {
        String countryCode = number.split("\\s+")[0].replace("(", "").replace(")", "");
        return countryRepository.findCountryByCode(countryCode).orElseThrow(NoSuchElementException::new);
    }

    /**
     * Used to validate if customer's number matching some country regex.
     * @param number customer number
     * @param regex country number's regex
     * @return true if matching, false if not.
     */
    @Override
    public boolean isValidPhoneNumber(String number, String regex) {
        return Pattern.matches(regex, number);
    }

    /**
     * get country by Id
     * @param id country id
     * @return Country
     * @throws NoSuchElementException  If there's no such Country with id.
     */
    @Override
    public Country getOne(Integer id) {
        return countryRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
