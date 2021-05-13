package com.jumia.exercise;

import com.jumia.exercise.repository.CountryRepository;
import com.jumia.exercise.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static com.jumia.exercise.data.MockData.getCountries;
import static com.jumia.exercise.data.MockData.getCustomers;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
abstract public class JumiaApplicationTests {

	@Autowired
	public MockMvc mockMvc;

	@Autowired
	public CountryRepository countryRepository;

	@Autowired
	public CustomerRepository customerRepository;

	void setUp() {
		countryRepository.deleteAll();
		customerRepository.deleteAll();
		customerRepository.saveAll(getCustomers());
		countryRepository.saveAll(getCountries());
	}

	void tearDown() {
		countryRepository.deleteAll();
		customerRepository.deleteAll();
	}


}