package com.silvershield.ssc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carriers_source_clean")
public class CarrierStagingDTO {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDotNumber() {
        return dotNumber;
    }

    public void setDotNumber(Integer dotNumber) {
        this.dotNumber = dotNumber;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getDoingBusinessAsName() {
        return doingBusinessAsName;
    }

    public void setDoingBusinessAsName(String doingBusinessAsName) {
        this.doingBusinessAsName = doingBusinessAsName;
    }

    public String getCarrierOperation() {
        return carrierOperation;
    }

    public void setCarrierOperation(String carrierOperation) {
        this.carrierOperation = carrierOperation;
    }

    public String getHmFlag() {
        return hmFlag;
    }

    public void setHmFlag(String hmFlag) {
        this.hmFlag = hmFlag;
    }

    public String getPcFlag() {
        return pcFlag;
    }

    public void setPcFlag(String pcFlag) {
        this.pcFlag = pcFlag;
    }

    public String getPhyStreet() {
        return phyStreet;
    }

    public void setPhyStreet(String phyStreet) {
        this.phyStreet = phyStreet;
    }

    public String getPhyCity() {
        return phyCity;
    }

    public void setPhyCity(String phyCity) {
        this.phyCity = phyCity;
    }

    public String getPhyState() {
        return phyState;
    }

    public void setPhyState(String phyState) {
        this.phyState = phyState;
    }

    public String getPhyZip() {
        return phyZip;
    }

    public void setPhyZip(String phyZip) {
        this.phyZip = phyZip;
    }

    public String getPhyCountry() {
        return phyCountry;
    }

    public void setPhyCountry(String phyCountry) {
        this.phyCountry = phyCountry;
    }

    public String getMailingStreet() {
        return mailingStreet;
    }

    public void setMailingStreet(String mailingStreet) {
        this.mailingStreet = mailingStreet;
    }

    public String getMailingCity() {
        return mailingCity;
    }

    public void setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
    }

    public String getMailingState() {
        return mailingState;
    }

    public void setMailingState(String mailingState) {
        this.mailingState = mailingState;
    }

    public String getMailingZip() {
        return mailingZip;
    }

    public void setMailingZip(String mailingZip) {
        this.mailingZip = mailingZip;
    }

    public String getMailingCountry() {
        return mailingCountry;
    }

    public void setMailingCountry(String mailingCountry) {
        this.mailingCountry = mailingCountry;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMcs150Date() {
        return mcs150Date;
    }

    public void setMcs150Date(String mcs150Date) {
        this.mcs150Date = mcs150Date;
    }

    public String getMcs150Mileage() {
        return mcs150Mileage;
    }

    public void setMcs150Mileage(String mcs150Mileage) {
        this.mcs150Mileage = mcs150Mileage;
    }

    public String getMcs150MileageYear() {
        return mcs150MileageYear;
    }

    public void setMcs150MileageYear(String mcs150MileageYear) {
        this.mcs150MileageYear = mcs150MileageYear;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getOicState() {
        return oicState;
    }

    public void setOicState(String oicState) {
        this.oicState = oicState;
    }

    public String getNbrPowerUnit() {
        return nbrPowerUnit;
    }

    public void setNbrPowerUnit(String nbrPowerUnit) {
        this.nbrPowerUnit = nbrPowerUnit;
    }

    public String getDriverTotal() {
        return driverTotal;
    }

    public void setDriverTotal(String driverTotal) {
        this.driverTotal = driverTotal;
    }

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
