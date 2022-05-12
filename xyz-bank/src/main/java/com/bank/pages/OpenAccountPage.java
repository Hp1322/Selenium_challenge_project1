package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {
    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement searchCustomer;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement selectCurrency;

    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processButton;

    public void selectSearchedCustomer(String customer) {
        Reporter.log("Selecting customer "+customer+" from dropdown "+searchCustomer.toString() + "<br>");
        selectByVisibleTextFromDropDown(searchCustomer, customer);
    }

    public void selectCurrency(String currency) {
        Reporter.log("Selecting currency "+currency+" from dropdown "+selectCurrency.toString() + "<br>");
        selectByVisibleTextFromDropDown(selectCurrency, currency);
    }
    public void clickOnProcessButton(){
        Reporter.log("Clicking on processButton "+ processButton.toString()+ "<br>");
        clickOnElement(processButton);
    }
    public String getAccountCreatedSuccessfullyText(){
        Reporter.log("getting alert text : "+getTextFromAlert()+"<br>");
        return getTextFromAlert();
    }

}
