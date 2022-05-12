package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BankTest extends TestBase {
    AccountPage accountPage;
    AddCustomerPage addCustomerPage;
    BankManagerLoginPage bankManagerLoginPage;
    CustomerLoginPage customerLoginPage;
    HomePage homePage;
    OpenAccountPage openAccountPage;
    CustomersPage customersPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        accountPage = new AccountPage();
        addCustomerPage = new AddCustomerPage();
        bankManagerLoginPage = new BankManagerLoginPage();
        customerLoginPage = new CustomerLoginPage();
        homePage = new HomePage();
        openAccountPage = new OpenAccountPage();
        customersPage = new CustomersPage();

    }

    @Test(groups = {"sanity","regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        SoftAssert softAssert = new SoftAssert();
        homePage.clickOnBankManagerLoginButton();
        bankManagerLoginPage.clickOnAddCustomerButton();
        addCustomerPage.enterFirstName("ram");
        addCustomerPage.enterLastName("shyam");
        addCustomerPage.enterPostcode("999-999");
        addCustomerPage.clickOnAddCustomerButton();
        switchToAlert();
        softAssert.assertEquals(addCustomerPage.getCustomerAddedSuccessfullyText().substring(0, 27), "Customer added successfully", "");
        acceptAlert();
        softAssert.assertAll();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() {
        SoftAssert softAssert = new SoftAssert();
        homePage.clickOnHomeButton();
        homePage.clickOnBankManagerLoginButton();
        bankManagerLoginPage.clickOnOpenAccountButton();
        openAccountPage.selectSearchedCustomer("ram shyam");
        openAccountPage.selectCurrency("Dollar");
        openAccountPage.clickOnProcessButton();
        try {
            switchToAlert();
            softAssert.assertEquals(openAccountPage.getAccountCreatedSuccessfullyText().substring(0, 28), "Account created successfully", "");
            acceptAlert();
        } catch (Exception e) {
            //exception handling
        }
        softAssert.assertAll();
    }

    @Test(groups = {"smoke","regression"})
    public void customerShouldLoginAndLogoutSuceessfully() {
        SoftAssert softAssert = new SoftAssert();
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLoginButton();
        customerLoginPage.selectYourName("ram shyam");
        customerLoginPage.clickOnLoginButton();
        softAssert.assertEquals(customersPage.verifyLogoutTab(),"Logout","");
        customersPage.clickOnLogout();
        softAssert.assertEquals(customerLoginPage.getYourName().substring(0,9),"Your Name","");
        softAssert.assertAll();

    }

    @Test(groups = {"smoke","regression"})
    public void customerShouldDepositMoneySuccessfully() {
        SoftAssert softAssert = new SoftAssert();
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLoginButton();
        customerLoginPage.selectYourName("ram shyam");
        customerLoginPage.clickOnLoginButton();
        customersPage.clickOnDepositTab();
        customersPage.enterAmountToDepositBox("100");
        customersPage.clickOnDepositButton();
        softAssert.assertEquals(customersPage.getDepositSuccessful(),"Deposit Successful","");
        softAssert.assertAll();

    }

    @Test(groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() {
        SoftAssert softAssert = new SoftAssert();
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLoginButton();
        customerLoginPage.selectYourName("ram shyam");
        customerLoginPage.clickOnLoginButton();
        customersPage.clickOnWithdrawTab();
        customersPage.enterAmountToDepositBox("50");
        customersPage.clickOnWithdrawButton();
        softAssert.assertEquals(customersPage.getTransactionSuccessful(),"Transaction successful","");
        softAssert.assertAll();

    }


}
