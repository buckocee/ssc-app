package com.silvershield.ssc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Carrier {

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

    @JsonIgnore
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
