package com.silvershield.ssc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.silvershield.ssc.auth.User;
import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "claims")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer claimId;

    @Column(name = "submit_date")
    private ZonedDateTime submitDate;

    @Column(name = "update_date")
    private ZonedDateTime updateDate;

    @Column(name = "payable_date")
    private ZonedDateTime invoicePayableDate;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @Column(name = "carrier_id")
    private Integer carrierId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrier_id", insertable = false, updatable = false)
    private Carrier carrier;

    @JsonIgnore
    @Column(name = "broker_id")
    private Integer brokerId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "broker_id", insertable = false, updatable = false)
    private Broker broker;

    @JsonIgnore
    @OneToOne(mappedBy = "claim", cascade = CascadeType.REMOVE)
    private Load load;

    @Column(name = "load_date")
    private ZonedDateTime loadDate;

    @Column(name = "load_type")
    private ZonedDateTime loadType;

    @JsonIgnore
    @Column(name = "invoice")
    @Lob
    private byte[] invoice;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "distance")
    private Double haulageDistance;

    @JsonIgnore
    @Column(name = "invoice_name")
    private String invoiceName;

    @Column(name = "created_by")
    private Integer userId;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", insertable = false, updatable = false)
    private User createdBy;

    @JsonIgnore
    @Column(name = "updated_by")
    private Integer updatedById;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", insertable = false, updatable = false)
    private User updatedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public enum Status{
        CREATED, DRAFT, SUBMITTED, PENDING, APPROVED, REJECTED
    }


}
