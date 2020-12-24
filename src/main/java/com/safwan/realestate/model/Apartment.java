package com.safwan.realestate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Apartment {
    public Apartment(String name, double price, String address, double area, Set<Images> images) {
        this.name = name;
        this.price = price;
        this.address = address;
        this.area = area;
        this.images = images;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", area=" + area +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "address")
    private String address;
    @Column(name = "area")
    private double area;

    public Set<Images> getImages() {
        return images;
    }

    public void setImages(Set<Images> images) {
        this.images = images;
    }

    @Column(name = "image")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apartment")
    private Set<Images> images = new HashSet<>();
    //String image ;

    public Apartment(Long id, String name, double price, String address, double area) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.address = address;
        this.area = area;
    }

    public Apartment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }


}
