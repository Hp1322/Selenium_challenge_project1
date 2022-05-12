package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLoginButton;

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLoginButton;

    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homeButton;




    public void clickOnBankManagerLoginButton(){
        Reporter.log("Clicking on BankManager Login Button "+ bankManagerLoginButton.toString()+ "<br>");
        clickOnElement(bankManagerLoginButton);
    }

    public void clickOnCustomerLoginButton(){
        Reporter.log("Clicking on Customer Login Button "+ customerLoginButton.toString()+ "<br>");
        clickOnElement(customerLoginButton);
    }
    public void clickOnHomeButton(){
        Reporter.log("Clicking on Home Button "+ homeButton.toString()+ "<br>");
        clickOnElement(homeButton);
    }
}
