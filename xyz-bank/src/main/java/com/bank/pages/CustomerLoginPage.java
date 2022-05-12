package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {
    public CustomerLoginPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement yourName;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;

    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement yourNameText;

    public void selectYourName(String yourNam){
        Reporter.log("Selecting your Name "+yourNam+" from dropdown "+yourName.toString() + "<br>");
        selectByVisibleTextFromDropDown(yourName, yourNam);
    }
    public void clickOnLoginButton(){
        Reporter.log("Clicking on loginButton "+ loginButton.toString()+ "<br>");
        clickOnElement(loginButton);
    }
    public String getYourName(){
        Reporter.log("getting your Name text "+yourNameText.toString()+"<br>");
        return  getTextFromElement(yourNameText);
    }
}
