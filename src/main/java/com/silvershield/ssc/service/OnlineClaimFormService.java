package com.silvershield.ssc.service;

import com.silvershield.ssc.model.Claim;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class OnlineClaimFormService {

    /**
     * Submits basic info claim form. Next steps:
     * 1. fill out paperwork and submit with:
     * 1.1 rate confirmation
     * 1.2 bill of lading
     * 1.3 invoice for each load
     * <p>
     * TODO - update data model to claim -> load -> invoice
     *
     * @param claim
     */

    public void submitCalimForm(Claim claim) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            driver.get("http://fedservicecorp.com/claimform-pfa.aspx");
            driver.findElement(By.id("ContentPlaceHolder2_ucInquiry_txtBrokerBusinessName"))
                    .sendKeys(String.format("%s%s", claim.getBroker().getBusinessName(), Keys.TAB));
            driver.findElement(By.id("ContentPlaceHolder2_ucInquiry_txtBrokerMC"))
                    .sendKeys(String.format("%s%s", claim.getBroker().getMcNumber(), Keys.TAB));
            // TODO - is silvershield the third party?
//            driver.findElement(By.id("ContentPlaceHolder2_ucInquiry_txtThirdPartyCompanyName"))
//                    .sendKeys(claim.getBroker().getBusinessName() + Keys.TAB);
//            driver.findElement(By.id("ContentPlaceHolder2_ucInquiry_txtThirdPartyContactName"))
//                    .sendKeys(claim.getBroker().getBusinessName() + Keys.TAB);
//            driver.findElement(By.id("ContentPlaceHolder2_ucInquiry_txtThirdPartyPhone"))
//                    .sendKeys(claim.getBroker().getBusinessName() + Keys.TAB);
//            driver.findElement(By.id("ContentPlaceHolder2_ucInquiry_txtThirdPartyEmail"))
//                    .sendKeys(claim.getBroker().getBusinessName() + Keys.TAB);
            driver.findElement(By.id("ContentPlaceHolder2_ucInquiry_txtCarrierBusinessName"))
                    .sendKeys(String.format("%s%s", claim.getCarrier().getBusinessName(), Keys.TAB));
            driver.findElement(By.id("ContentPlaceHolder2_ucInquiry_txtCarrierContactName"))
                    .sendKeys(String.format("%s%s", claim.getCarrier().getContactName(), Keys.TAB));
            driver.findElement(By.id("ContentPlaceHolder2_ucInquiry_txtCarrierMCNumber"))
                    .sendKeys(String.format("%s%s", claim.getCarrier().getMcNumber(), Keys.TAB));
            driver.findElement(By.id("ContentPlaceHolder2_ucInquiry_txtCarrierPhone"))
                    .sendKeys(String.format("%s%s", claim.getCarrier().getPhoneNumber(), Keys.TAB));
            driver.findElement(By.id("ContentPlaceHolder2_ucInquiry_txtCarrierEmail"))
                    .sendKeys(String.format("%s%s", claim.getCarrier().getEmail(), Keys.TAB));
            driver.findElement(By.id("ContentPlaceHolder2_ucInquiry_txtInquiryTotalAmountOwed"))
                    .sendKeys(String.format("%f%s", claim.getAmount(), Keys.TAB));
            driver.findElement(By.id("ContentPlaceHolder2_ucInquiry_txtInquiryOldestLoadDt"))
                    .sendKeys(String.format("%s%s",
                            new SimpleDateFormat("MM/dd/yyyy").format(claim.getLoad().getLoadDate()), Keys.TAB));
            driver.findElement(By.id("ContentPlaceHolder2_ucInquiry_txtInquiryTotalNumberOfInvoices"))
                    .sendKeys(String.format("%d%s", claim.getInvoices().size(), Keys.TAB));
            driver.findElement(By.id("ContentPlaceHolder2_ucInquiry_txtInquiryCommodityHauled"))
                    .sendKeys(String.format("%s%s%s", claim.getLoad().getDescription(), Keys.TAB, Keys.ENTER));

        } finally {
            driver.quit();
        }
    }

/**
 * 1. https://cerasis.com/how-to-file-a-freight-claim/
 * 2. http://fedservicecorp.com/
 * 3. form -> http://fedservicecorp.com/claimform-pfa.aspx
 * <input name="ctl00$ContentPlaceHolder2$ucInquiry$txtBrokerBusinessName" type="text" id="ContentPlaceHolder2_ucInquiry_txtBrokerBusinessName" class="width250">
 * <input name="ctl00$ContentPlaceHolder2$ucInquiry$txtBrokerMC" type="text" id="ContentPlaceHolder2_ucInquiry_txtBrokerMC" maxlength="8">
 * <input name="ctl00$ContentPlaceHolder2$ucInquiry$txtThirdPartyCompanyName" type="text" id="ContentPlaceHolder2_ucInquiry_txtThirdPartyCompanyName" class="width250">
 * <input name="ctl00$ContentPlaceHolder2$ucInquiry$txtThirdPartyContactName" type="text" id="ContentPlaceHolder2_ucInquiry_txtThirdPartyContactName">
 * <input name="ctl00$ContentPlaceHolder2$ucInquiry$txtThirdPartyPhone" type="text" id="ContentPlaceHolder2_ucInquiry_txtThirdPartyPhone">
 * <input name="ctl00$ContentPlaceHolder2$ucInquiry$txtThirdPartyEmail" type="text" id="ContentPlaceHolder2_ucInquiry_txtThirdPartyEmail" class="width250">
 * <input name="ctl00$ContentPlaceHolder2$ucInquiry$txtCarrierBusinessName" type="text" id="ContentPlaceHolder2_ucInquiry_txtCarrierBusinessName" class="width250">
 * <input name="ctl00$ContentPlaceHolder2$ucInquiry$txtCarrierContactName" type="text" id="ContentPlaceHolder2_ucInquiry_txtCarrierContactName" class="width250">
 * <input name="ctl00$ContentPlaceHolder2$ucInquiry$txtCarrierMCNumber" type="text" id="ContentPlaceHolder2_ucInquiry_txtCarrierMCNumber" maxlength="8">
 * <input name="ctl00$ContentPlaceHolder2$ucInquiry$txtCarrierPhone" type="text" id="ContentPlaceHolder2_ucInquiry_txtCarrierPhone">
 * <input name="ctl00$ContentPlaceHolder2$ucInquiry$txtCarrierEmail" type="text" id="ContentPlaceHolder2_ucInquiry_txtCarrierEmail" class="width250">
 * <input name="ctl00$ContentPlaceHolder2$ucInquiry$txtInquiryTotalAmountOwed" type="text" id="ContentPlaceHolder2_ucInquiry_txtInquiryTotalAmountOwed" onkeypress="return isNumberKey(event)" class="width250">
 * <input name="ctl00$ContentPlaceHolder2$ucInquiry$txtInquiryOldestLoadDt" type="text" id="ContentPlaceHolder2_ucInquiry_txtInquiryOldestLoadDt">
 * <input name="ctl00$ContentPlaceHolder2$ucInquiry$txtInquiryTotalNumberOfInvoices" type="text" id="ContentPlaceHolder2_ucInquiry_txtInquiryTotalNumberOfInvoices">
 * <input name="ctl00$ContentPlaceHolder2$ucInquiry$txtInquiryCommodityHauled" type="text" id="ContentPlaceHolder2_ucInquiry_txtInquiryCommodityHauled" class="width250">
 */
}
