package com.silvershield.ssc.model;

import lombok.Data;

import javax.persistence.*;
import java.nio.file.Path;
import java.util.Date;

@Entity
@Data
@Table(name = "loads")
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
