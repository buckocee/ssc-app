package com.silvershield.ssc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "address")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address {
    public Address(Integer id, String streetAddress, String unitSuiteFloor, String city, String state, String country, String zipCode) {
        this.id = id;
        this.streetAddress = streetAddress;
        this.unitSuiteFloor = unitSuiteFloor;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return getStreetAddress().equals(address.getStreetAddress()) &&
                Objects.equals(getUnitSuiteFloor(), address.getUnitSuiteFloor()) &&
                getCity().equals(address.getCity()) &&
                getState().equals(address.getState()) &&
                getCountry().equals(address.getCountry()) &&
                getZipCode().equals(address.getZipCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStreetAddress(), getUnitSuiteFloor(), getCity(), getState(), getCountry(), getZipCode());
    }

    public Address() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getUnitSuiteFloor() {
        return unitSuiteFloor;
    }

    public void setUnitSuiteFloor(String unitSuiteFloor) {
        this.unitSuiteFloor = unitSuiteFloor;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "apt_number")
    private String unitSuiteFloor;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "zip_code")
    private String zipCode;
}
