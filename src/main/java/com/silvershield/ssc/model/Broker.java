package com.silvershield.ssc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "brokers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Broker implements Serializable {
    public Broker(Integer id, String mcNumber, String dotNumber, String businessName, Status status, String phoneNumber, String faxNumber, String state, String city, Address mailingAddress) {
        this.id = id;
        this.mcNumber = mcNumber;
        this.dotNumber = dotNumber;
        this.businessName = businessName;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.state = state;
        this.city = city;
        this.mailingAddress = mailingAddress;
    }

    public Broker() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMcNumber() {
        return mcNumber;
    }

    public void setMcNumber(String mcNumber) {
        this.mcNumber = mcNumber;
    }

    public String getDotNumber() {
        return dotNumber;
    }

    public void setDotNumber(String dotNumber) {
        this.dotNumber = dotNumber;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mc_number", updatable = false)
    private String mcNumber;

    @Column(name = "dot_number", updatable = false)
    private String dotNumber;

    @Column(name = "business_name", updatable = false)
    private String businessName;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "phone", updatable = false)
    private String phoneNumber;

    @Column(name = "fax", updatable = false)
    private String faxNumber;

    @Column(name = "state", updatable = false)
    private String state;

    @Column(name = "city", updatable = false)
    private String city;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "addressId", updatable = false)
    private Address mailingAddress;

    public enum Status{
        ACTIVE, INACTIVE
    }
}
