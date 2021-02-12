package com.silvershield.ssc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.silvershield.ssc.auth.User;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "claims")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Claim {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrier_id", insertable = false, updatable = false)
    private Carrier carrier;

    public Integer getClaimId() {
        return claimId;
    }

    public void setClaimId(Integer claimId) {
        this.claimId = claimId;
    }

    public ZonedDateTime getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(ZonedDateTime submitDate) {
        this.submitDate = submitDate;
    }

    public ZonedDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(ZonedDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public ZonedDateTime getInvoicePayableDate() {
        return invoicePayableDate;
    }

    public void setInvoicePayableDate(ZonedDateTime invoicePayableDate) {
        this.invoicePayableDate = invoicePayableDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }

    public Broker getBroker() {
        return broker;
    }

    public void setBroker(Broker broker) {
        this.broker = broker;
    }

    public Load getLoad() {
        return load;
    }

    public void setLoad(Load load) {
        this.load = load;
    }

    public ZonedDateTime getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(ZonedDateTime loadDate) {
        this.loadDate = loadDate;
    }

    public ZonedDateTime getLoadType() {
        return loadType;
    }

    public void setLoadType(ZonedDateTime loadType) {
        this.loadType = loadType;
    }

    @JsonIgnore
    @Column(name = "invoice")
    @Lob
    private List<byte[]> invoices;

    public List<byte[]> getInvoices() {
        return invoices;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getHaulageDistance() {
        return haulageDistance;
    }

    public void setHaulageDistance(Double haulageDistance) {
        this.haulageDistance = haulageDistance;
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public Integer getUpdatedById() {
        return updatedById;
    }

    public void setUpdatedById(Integer updatedById) {
        this.updatedById = updatedById;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Status getStatus() {
        return status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    public void setStatus(Status status) {
        this.status = status;
    }

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

    public void setInvoices(List<byte[]> invoice) {
        this.invoices = invoice;
    }

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

    @Transient
    private String submittedBy;

    public String getSubmittedBy() {
        return Objects.isNull(createdBy) ? "" :
            String.format("%s %s", createdBy.getFirstName(), createdBy.getLastName());
    }

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
