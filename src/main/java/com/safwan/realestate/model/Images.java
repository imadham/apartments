package com.safwan.realestate.model;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Images {
    public Images(Apartment apartment, Byte[] base64) {
        this.base64 = base64;
        this.apartment = apartment;
    }

    public Byte[] getBase64() {
        return base64;
    }

    public void setBase64(Byte[] base64) {
        this.base64 = base64;
    }

    public Images(Byte[] base64) {
        this.base64 = base64;
    }

    @Lob
    @Column(name = "base64Image")
    private Byte[]  base64;

    public Images() {
    }

    public Images(Long id, Apartment apartment, Byte[] base64) {
        this.id = id;
        this.apartment = apartment;
        this.base64 = base64;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @ManyToOne
    @JoinColumn(name = "apartment__id")
    private Apartment apartment;
}
