package com.safwan.realestate.model;

import java.util.List;

public interface ApartmentService extends CrudService <Apartment, Long> {
    List<Apartment> findAllByNameLike(String name);
    List<Apartment> findByPriceGreaterThan (double price);
    List<Apartment> findByPriceLessThan (double price);
    List<Apartment> findByAreaLessThan (double area);
    List<Apartment> findByAreaGreaterThan (double area);

}
