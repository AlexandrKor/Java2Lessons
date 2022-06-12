package com.GeekBreins.HomeWork3;

import java.util.Set;

public interface Phonebook {

    void add(String surname, String phoneNumber);

    Set<String> get(String surname);

    Set<String> getAllSurname();
}
