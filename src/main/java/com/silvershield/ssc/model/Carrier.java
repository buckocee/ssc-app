package com.silvershield.ssc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "physical_address_id")
    private Address physicalAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mailing_address_id")
    private Address mailingAddress;

    public enum Status{
        ACTIVE, INACTIVE
    }
}
