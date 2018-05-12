package com.silvershield.ssc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.silvershield.ssc.auth.User;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "submit_date")
    private Timestamp submitDate;

    @Column(name = "update_date")
    private Timestamp updateDate;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "carrier")
    private Integer carrierId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "carrier", insertable = false, updatable = false)
    private Carrier carrier;

    @Column(name = "broker")
    private Integer brokerId;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "broker", insertable = false, updatable = false)
    private Broker broker;

    @Column(name = "created_by")
    private Integer createdById;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "created_by", insertable = false, updatable = false)
    private User createdBy;

    @Column(name = "updated_by")
    private Integer updatedById;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "updated_by", insertable = false, updatable = false)
    private User updatedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public enum Status{
        CREATED, DRAFT, SUBMITTED, PENDING, APPROVED, REJECTED
    }


}
