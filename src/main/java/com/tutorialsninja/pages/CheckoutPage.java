package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class CheckoutPage extends Utility {
    By checkoutText = By.xpath("//h1[contains(text(),'Checkout')]");
    By newCustomerText = By.xpath("//h2[contains(text(),'New Customer')]");
    By guestCheckoutRadioButton = By.xpath("//div[@id='checkout-checkout']//input[@value='guest']");
    By continueButton = By.xpath("//input[@id='button-account']");
    By continueButtonBillingDetails = By.xpath("//input[@id='button-guest']");

    By firstName = By.id("input-payment-firstname");
    By lastName = By.id("input-payment-lastname");
    By email = By.id("input-payment-email");
    By telephone = By.id("input-payment-telephone");
    By address = By.id("input-payment-address-1");
    By city = By.id("input-payment-city");
    By postCode = By.id("input-payment-postcode");
    By country = By.id("input-payment-country");
    By regionOrState = By.id("input-payment-zone");
    By commentBox = By.name("comment");
    By termsAndConditionsRadioBox = By.name("agree");
    By continueButtonCommentDetails = By.id("button-payment-method");
    By paymentMethodWarning = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    public String getCheckoutText() {
        return getTextFromElement(checkoutText);
    }

    public String getNewCustomerText() {
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckoutRadioButton() {
        clickOnElement(guestCheckoutRadioButton);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }
    public void clickOnContinueBillingButton() {
        clickOnElement(continueButtonBillingDetails);
    }
    public void clickOnContinueCommentButton() {
        clickOnElement(continueButtonCommentDetails);
    }
    public void enterBillingDetails()throws InterruptedException {
        sendTextToElement(firstName,"DP");
        sendTextToElement(lastName,"Patel");
        sendTextToElement(email,"DPPatel123@gmail.com");
        sendTextToElement(telephone,"0123421681");
        sendTextToElement(address,"24,Danes Gate");
        sendTextToElement(city,"Albana");
        sendTextToElement(postCode,"AB41CD");
        selectByVisibleTextFromDropDown(country,"United States");
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(regionOrState, "Graham");
    }
    public void enterComment(){
        sendTextToElement(commentBox,"ABC Comments");
    }
    public void clickOnAgreeToTermsAndConditions(){
        clickOnElement(termsAndConditionsRadioBox);
    }
    public Boolean isPaymentWarningAppearing(){
        return getTextFromElement(paymentMethodWarning).contains("Warning: Payment method required!");
    }
}
