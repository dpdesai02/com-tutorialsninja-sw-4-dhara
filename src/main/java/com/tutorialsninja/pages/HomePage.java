package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {

    By topMenuListField = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    By desktopTab = By.linkText("Desktops");
    By laptopsAndNoteBooksTab = By.linkText("Laptops & Notebooks");
    By componentsTab = By.linkText("Components");
    By myAccounts = By.xpath("//span[contains(text(),'My Account')]");
    By registerAccountText = By.xpath("//h1[contains(text(),'Register Account')]");
    By loginAccountText = By.xpath("//h2[contains(text(),'Returning Customer')]");

    //    By currencySelector = By.xpath("//span[contains(text(),'Currency')]");
//    By currencyGBP = By.className("GBP");
//
//    public void chooseGBP() {
//        mouseHoverToElementAndClick(currencySelector);
//        mouseHoverToElementAndClick(currencyGBP);
//    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(topMenuListField);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(topMenuListField);
        }
    }

    public void mouseHoverAndClickOnDesktop() {
        mouseHoverToElementAndClick(desktopTab);
    }

    public void mouseHoverAndClickOnLaptopsAndNotebooks() {
        mouseHoverToElementAndClick(laptopsAndNoteBooksTab);
    }

    public void mouseHoverAndClickOnComponents() {
        mouseHoverToElementAndClick(componentsTab);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountsList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountsList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountsList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }

    public void clickOnMyAccount() {
        clickOnElement(myAccounts);
    }

    public String getRegisterAccountText() {
        return getTextFromElement(registerAccountText);
    }

    public String getLoginAccountText() {
        return getTextFromElement(loginAccountText);
    }


}
