package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomersPage extends Utility {
    public CustomersPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//button[contains(text(),'Logout')]")
    WebElement logout;

    @FindBy (xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[2]")
    WebElement depositTab;

    @FindBy (xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[3]")
    WebElement withdrawTab;

    @FindBy (xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
    WebElement amountBox;

    @FindBy (xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
    WebElement depositButton;

    @FindBy (xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
    WebElement withdrawButton;

    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositSuccessfulText;

    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement transactionSuccessfulText;

    public String verifyLogoutTab(){
        Reporter.log("getting logout text "+logout.toString()+"<br>");

        return  getTextFromElement(logout);
    }
    public void clickOnLogout(){
        Reporter.log("Clicking on logout "+ logout.toString()+ "<br>");
        clickOnElement(logout);
    }
    public void clickOnDepositTab(){
        Reporter.log("Clicking on deposit Tab "+ depositTab.toString()+ "<br>");
        clickOnElement(depositTab);
    }
    public void clickOnWithdrawTab(){
        Reporter.log("Clicking on withdraw Tab "+ withdrawTab.toString()+ "<br>");
        clickOnElement(withdrawTab);
    }
    public void enterAmountToDepositBox(String amount){
        Reporter.log("Enter amount "+amount+ " to amount field "+amountBox.toString() + "<br>");
        sendTextToElement(amountBox, amount);
    }
    public void clickOnDepositButton(){
        Reporter.log("Clicking on depositButton "+ depositButton.toString()+ "<br>");
        clickOnElement(depositButton);
    }
    public void clickOnWithdrawButton(){
        Reporter.log("Clicking on withdrawButton "+ withdrawButton.toString()+ "<br>");
        clickOnElement(withdrawButton);
    }
    public String getDepositSuccessful(){
        Reporter.log("getting deposit Successfull text "+depositSuccessfulText.toString()+"<br>");

        return  getTextFromElement(depositSuccessfulText);
    }
    public String getTransactionSuccessful(){
        Reporter.log("getting transaction Successfull text "+transactionSuccessfulText.toString()+"<br>");

        return  getTextFromElement(transactionSuccessfulText);
    }
}
