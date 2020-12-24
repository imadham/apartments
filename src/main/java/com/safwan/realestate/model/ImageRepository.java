package com.safwan.realestate.model;

import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ImageRepository extends CrudRepository<Images, Long> {
        Set<Images> findAllById(Long id) ;
        Set<Images> findAllByApartment(Apartment apartment);

        }
