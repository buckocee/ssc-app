package com.silvershield.ssc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "carriers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Carrier {

    public Carrier(Integer id, String mcNumber, String dotNumber, Status status, String businessName,
                   String phoneNumber, String faxNumber, String email, List<Claim> claims,
                   Address physicalAddress, Address mailingAddress) {
        this.id = id;
        this.mcNumber = mcNumber;
        this.dotNumber = dotNumber;
        this.status = status;
        this.businessName = businessName;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.email = email;
        this.claims = claims;
        this.physicalAddress = physicalAddress;
        this.mailingAddress = mailingAddress;
    }

    public Carrier() {

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }

    public Address getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(Address physicalAddress) {
        this.physicalAddress = physicalAddress;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "status", updatable = false)
    private Status status;

    @Column(name = "business_name", updatable = false)
    private String businessName;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "fax")
    private String faxNumber;

    @Column
    private String contactName;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "carrier")
    private List<Claim> claims;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "physical_address_id")
    private Address physicalAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mailing_address_id")
    private Address mailingAddress;

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public enum Status {
        ACTIVE, INACTIVE
    }
}
