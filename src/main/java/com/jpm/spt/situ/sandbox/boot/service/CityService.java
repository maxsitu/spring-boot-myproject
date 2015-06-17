package com.jpm.spt.situ.sandbox.boot.service;

import com.jpm.spt.situ.sandbox.boot.dbo.City;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by v545192 on 6/12/2015.
 */
public interface CityService {
    City getCity(String name, String country);
    List<City> getCities(String country, Pageable pageable);
}
