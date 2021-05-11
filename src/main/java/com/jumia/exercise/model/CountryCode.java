package com.jumia.exercise.model;

@Data
public class CountryCode {

    @Id
    private Integer id;
    private String name;
    private String code;
    private String regex;
}
