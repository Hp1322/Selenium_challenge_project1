package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {
    public AddCustomerPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")
    WebElement firstNameField;

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/input[1]")
    WebElement lastNameField;

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/input[1]")
    WebElement postCodeField;

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]")
    WebElement addCustomerButton;

    public String getCustomerAddedSuccessfullyText(){

        return getTextFromAlert();
    }

    public void enterFirstName(String firstName){
        Reporter.log("Enter firstName "+firstName+ " to first Name field "+firstNameField.toString() + "<br>");
        sendTextToElement(firstNameField, firstName);
    }
    public void enterLastName(String lastName){
        Reporter.log("Enter lastName "+lastName+ " to last Name field "+lastNameField.toString() + "<br>");
        sendTextToElement(lastNameField, lastName);
    }
    public void enterPostcode(String postcode){
        Reporter.log("Enter postcode "+postcode+ " to postcode field "+postCodeField.toString() + "<br>");
        sendTextToElement(postCodeField, postcode);
    }
    public void clickOnAddCustomerButton(){
        Reporter.log("Clicking on Add Customer Button "+ addCustomerButton.toString()+ "<br>");
        clickOnElement(addCustomerButton);
    }

}
