package com.jpm.spt.situ.sandbox.boot.service;


import com.jpm.spt.situ.sandbox.boot.dbo.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

/**
 * Created by v545192 on 6/12/2015.
 */
public interface CityRepository extends Repository<City, Long> {
    Page<City> findAll(Pageable pageable);

    Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String name,
                                                                       String country, Pageable pageable);

    City findByNameAndCountryAllIgnoringCase(String name, String country);

    Page<City> findByCountryContainingAllIgnoringCase(String country, Pageable pageable);
}
