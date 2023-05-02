package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountsTest extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    AccountCreationPage accountCreationPage = new AccountCreationPage();
    AccountPage accountPage = new AccountPage();
    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        homePage.clickOnMyAccount();
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        Assert.assertEquals(homePage.getRegisterAccountText(), "Register Account", "Register page not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        homePage.clickOnMyAccount();
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Login");
        //2.3 Verify the text “Register Account”.
        Assert.assertEquals(homePage.getLoginAccountText(), "Returning Customer", "Login page not displayed");
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        //3.1 Click on My Account Link.
        homePage.clickOnMyAccount();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");
        //3.3 Enter First Name
        registerPage.sendFirstName("DP");
        //3.4 Enter Last Name
        registerPage.sendLastName("Patel");
        //3.5 Enter Email
        registerPage.sendEmail("DPPatel");
        //3.6 Enter Telephone
        registerPage.sendTelephone("07613544677");
        //3.7 Enter Password
        registerPage.sendPassword("AimHigh123");
        //3.8 Enter Password Confirm
        registerPage.sendConfirmPassword("AimHigh123");
        //3.9 Select Subscribe Yes radio button
        registerPage.clickOnSubscribeToNewsletter();
        //3.10 Click on Privacy Policy check box
        registerPage.clickOnPrivacyPolicy();
        //3.11 Click on Continue button
        registerPage.clickOnContinueAfterPrivacyButton();
        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(accountCreationPage.getAccountCreationMessage(),"Your Account Has Been Created!","account not created");
        //3.13 Click on Continue button
        accountCreationPage.clickOnContinueAfterAccountCreation();
        //3.14 Click on My Account Link.
        accountPage.clickOnMyAccountLink();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        accountPage.selectMyAccountOption("Logout");
        //3.16 Verify the text “Account Logout”
        Assert.assertEquals(logoutPage.getTextFromLogout(),"Account Logout","not logged out");
        //3.17 Click on Continue button
        accountPage.clickOnContinueAfterLogout();

    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        //4.1 Click on My Account Link.
        homePage.clickOnMyAccount();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Login");
        //4.3 enter email
        loginPage.sendEmail("DPPatel123@gmail.com");
        //enter password
        loginPage.sendPassword("AimHigh123");
        //click login
        loginPage.clickOnLogin();
        //verify if expected equals actual
        Assert.assertEquals(accountPage.getMyAccountText(),"My Account","Not on my account");
        //click my account
        accountPage.clickOnMyAccountLink();
        //choose logout
        homePage.selectMyAccountOptions("Logout");
        //verify if logout has occured
        Assert.assertEquals(logoutPage.getTextFromLogout(),"Account Logout","Not logged out");
    }
}
