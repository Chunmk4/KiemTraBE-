package com.example.demo3.service;


import com.example.demo3.model.City;

import java.util.List;

public interface ICityService {
    List<City> findAll();

    void save(City city);

    City findById(int id);

    void update(int id, City city);

    void remove(int id);
}