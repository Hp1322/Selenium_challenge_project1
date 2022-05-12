package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BankManagerLoginPage extends Utility {
    public BankManagerLoginPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]")
    WebElement addCustomerButton;

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[2]")
    WebElement openAccountButton;

    public void clickOnAddCustomerButton(){
        Reporter.log("Clicking on Add Customer Button "+ addCustomerButton.toString()+ "<br>");
        clickOnElement(addCustomerButton);
    }
    public void clickOnOpenAccountButton(){
        Reporter.log("Clicking on Open Account Button "+ openAccountButton.toString()+ "<br>");
        clickOnElement(openAccountButton);
    }
}
