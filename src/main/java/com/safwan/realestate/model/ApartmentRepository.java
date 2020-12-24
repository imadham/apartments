package com.safwan.realestate.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApartmentRepository extends CrudRepository <Apartment, Long> {
    List<Apartment> findAllByNameLike(String name);
    List<Apartment> findByPriceGreaterThan (double price);
    List<Apartment> findByPriceLessThan (double price);
    List<Apartment> findByAreaLessThan (double area);
    List<Apartment> findByAreaGreaterThan (double area);

}
