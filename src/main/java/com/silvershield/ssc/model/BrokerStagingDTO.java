package com.silvershield.ssc.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "brokers_staging")
public class BrokerStagingDTO {

    @Id
    @Column(name = "id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "mc_number", insertable = false, updatable = false)
    private String mcNumber;

    @Column(name = "dot_number", insertable = false, updatable = false)
    private String dotNumber;

    @Column(name = "name", insertable = false, updatable = false)
    private String businessName;

    @Column(name = "state", insertable = false, updatable = false)
    private String state;

    @Column(name = "city", insertable = false, updatable = false)
    private String city;
}
