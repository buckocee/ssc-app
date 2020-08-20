package com.silvershield.ssc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "loads")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "load_date")
    private Date loadDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "invoice_date")
    private Date invoiceIssueDate;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "claim_id")
    private Claim claim;

    @OneToOne
    @JoinColumn(name = "origin_address_id")
    private Address origin;

    @OneToOne
    @JoinColumn(name = "destination_address_id")
    private Address destination;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "invoice_amount")
    private Double invoiceAmount;

    @Column(name = "invoice_path")
    private String invoiceLocation;

    @Column(name = "invoice_upload_date")
    private Date invoiceUploadDate;

    public enum Type{

    }
}
