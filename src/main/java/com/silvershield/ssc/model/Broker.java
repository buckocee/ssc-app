package com.silvershield.ssc.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "brokers")
public class Broker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mc_number")
    private String mcNumber;

    @Column(name = "dot_number")
    private String dotNumber;

    @Column(name = "business_name")
    private String businessName;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToOne
    @JoinColumn(name = "addressId")
    private Address address;

    public enum Status{
        ACTIVE, INACTIVE
    }
}
