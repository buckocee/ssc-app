package com.silvershield.ssc.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "carriers_staging_clean")
public class CarrierStagingDTO {

    @Id
    @Column(name = "id", insertable = false, updatable = false)
    private Integer id;

    // Unique USDOT Number of the Motor Carrier
    @Column(name = "dot_number", insertable = false, updatable = false)
    private Integer dotNumber;

    // Legal name of a carrier
    @Column(name = "legal_name", insertable = false, updatable = false)
    private String legalName;

    // Carrier's Doing-Business-As name
    @Column(name = "dba_name", insertable = false, updatable = false)
    private String doingBusinessAsName;

    // Codes identifying carriers' type of Operation; A = Interstate, B = Intrastate Hazmat, C = Intrastate Non-Hazmat
    @Column(name = "carrier_operation", insertable = false, updatable = false)
    private String carrierOperation;

    // Carrier is subject to placardable HM threshold ( Y = Yes, N = No)
    @Column(name = "hm_flag", insertable = false, updatable = false)
    private String hmFlag;

    // Carrier is subject to passengercarrier Threshold (Y = Yes, N = No)
    @Column(name = "pc_flag", insertable = false, updatable = false)
    private String pcFlag;

    // Physical street address of a carrier
    @Column(name = "phy_street", insertable = false, updatable = false)
    private String phyStreet;

    // Physical city of a carrier
    @Column(name = "phy_city", insertable = false, updatable = false)
    private String phyCity;

    // Physical state of a carrier
    @Column(name = "phy_state", insertable = false, updatable = false)
    private String phyState;

    // Physical zip code of a carrier
    @Column(name = "phy_zip", insertable = false, updatable = false)
    private String phyZip;

    // Physical country of a carrier
    @Column(name = "phy_country", insertable = false, updatable = false)
    private String phyCountry;

    // Mail street address of a carrier
    @Column(name = "mailing_street", insertable = false, updatable = false)
    private String mailingStreet;

    // Mail city of a carrier
    @Column(name = "mailing_city", insertable = false, updatable = false)
    private String mailingCity;

    // Mail state of a carrier
    @Column(name = "mailing_state", insertable = false, updatable = false)
    private String mailingState;

    // Mail zip code of a carrier
    @Column(name = "mailing_zip", insertable = false, updatable = false)
    private String mailingZip;

    // Mail country of a carrier
    @Column(name = "mailing_country", insertable = false, updatable = false)
    private String mailingCountry;

    // Contact telephone number
    @Column(name = "telephone", insertable = false, updatable = false)
    private String telephone;

    // Fax Number
    @Column(name = "fax", insertable = false, updatable = false)
    private String fax;

    // Contact email address
    @Column(name = "email_address", insertable = false, updatable = false)
    private String emailAddress;

    // Latest date MCS-150 was filed
    @Column(name = "mcs150_date", insertable = false, updatable = false)
    private String mcs150Date;

    // Vehicle Mileage Traveled (VMT) reported on the carrier's MCS-150 form
    @Column(name = "mcs150_mileage", insertable = false, updatable = false)
    private String mcs150Mileage;

    // Year for which VMT was reported
    @Column(name = "mcs150_mileage_year", insertable = false, updatable = false)
    private String mcs150MileageYear;

    // Date when carrier information was added to MCMIS Database System
    @Column(name = "add_date", insertable = false, updatable = false)
    private String addDate;

    // FMCSA State office with oversight for this carrier
    @Column(name = "oic_state", insertable = false, updatable = false)
    private String oicState;

    // Number of power units reported
    @Column(name = "nbr_power_unit", insertable = false, updatable = false)
    private String nbrPowerUnit;

    // Number of drivers reported
    @Column(name = "driver_total", insertable = false, updatable = false)
    private String driverTotal;

}
