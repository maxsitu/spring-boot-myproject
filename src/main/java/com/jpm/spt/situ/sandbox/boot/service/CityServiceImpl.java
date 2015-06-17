package com.jpm.spt.situ.sandbox.boot.service;

import com.jpm.spt.situ.sandbox.boot.dbo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by v545192 on 6/12/2015.
 */
@Component("cityService")
@Transactional
public class CityServiceImpl implements CityService{

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City getCity(String name, String country) {
        Assert.notNull(name, "Name must not be null");
        Assert.notNull(country, "Country must not be null");
        return this.cityRepository.findByNameAndCountryAllIgnoringCase(name, country);
    }

    @Override
    public List<City> getCities(String country, Pageable pageRequest) {
        Page<City> cityPage = cityRepository.findByCountryContainingAllIgnoringCase(country,  pageRequest);
        return cityPage.getContent();
    }
}
