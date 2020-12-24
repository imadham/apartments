package com.safwan.realestate.model;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ApartmentImpl implements ApartmentService {
    private final ApartmentRepository apartmentRepository;

    public ApartmentImpl(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public List<Apartment> findAllByNameLike(String name) {
        return apartmentRepository.findAllByNameLike(name);
    }

    @Override
    public List<Apartment> findByPriceGreaterThan(double price) {
        return apartmentRepository.findByPriceGreaterThan(price);
    }

    @Override
    public List<Apartment> findByPriceLessThan(double price) {
        return apartmentRepository.findByPriceLessThan(price);
    }

    @Override
    public List<Apartment> findByAreaLessThan(double area) {
        return apartmentRepository.findByAreaLessThan(area);
    }

    @Override
    public List<Apartment> findByAreaGreaterThan(double area) {
        return apartmentRepository.findByAreaGreaterThan(area);
    }

    @Override
    public Set<Apartment> findAll() {
        Set<Apartment> apartments = new HashSet<>();
        apartmentRepository.findAll().forEach(apartments::add);
        return apartments;
    }

    @Override
    public Apartment findById(Long aLong) {
        return apartmentRepository.findById(aLong).orElse(null);
    }

    @Override
    public Apartment save(Apartment object) {
        return apartmentRepository.save(object);
    }

    @Override
    public void delete(Apartment object) {
        apartmentRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        apartmentRepository.deleteById(aLong);

    }
}
