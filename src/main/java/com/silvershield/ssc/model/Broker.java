package com.silvershield.ssc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brokers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Broker implements Serializable {

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
