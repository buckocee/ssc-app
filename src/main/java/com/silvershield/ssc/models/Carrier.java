package com.silvershield.ssc.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "carriers")
public class Carrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mc_number")
    private String mcNumber;

    @Column(name = "dot_number")
    private String dotNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "business_name")
    private String businessName;

    @OneToMany(mappedBy = "carrier")
    private List<Claim> claims;

    public enum Status{
        ACTIVE, INACTIVE
    }
}
