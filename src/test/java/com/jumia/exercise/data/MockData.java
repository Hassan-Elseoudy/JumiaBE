package com.jumia.exercise.data;

import com.jumia.exercise.model.Country;
import com.jumia.exercise.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static List<Country> getCountries() {
        return List.of(
                new Country(0, "Cameroon", "237", "\\(237\\) ?[2368]\\d{7,8}$"),
                new Country(1, "Ethiopia", "251", "\\(251\\) ?[1-59]\\d{8}$")
        );
    }

    public static List<Customer> getNotValidCustomers() {
        return List.of(
                new Customer(0, "SUGAR STARRK BARRAGAN", "(237) 6780009592"),
                new Customer(1, "WILLIAM KEMFANG", "(237) 6622284920"),
                new Customer(2, "shop23 sales", "(251) 9773199405"),
                new Customer(3, "ZEKARIAS KEBEDE", "(251) 9119454961")
        );
    }

    public static List<Customer> getValidCustomers() {
        return List.of(
                new Customer(4, "EMILE CHRISTIAN KOUKOU DIKANDA HONORE", "(237) 697151594"),
                new Customer(5, "MICHAEL MICHAEL", "(237) 677046616"),
                new Customer(6, "ABRAHAM NEGASH", "(251) 911203317"),
                new Customer(7, "Filimon Embaye", "(251) 914701723")

        );
    }

    public static List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.addAll(getNotValidCustomers());
        customers.addAll(getValidCustomers());
        return customers;
    }

}
