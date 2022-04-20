package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        //Find register link and click on it
        WebElement registerLink = driver.findElement(By.xpath("//a[text()='Register']"));
        registerLink.click();
        //This is from requirement
        String expectedMessage = "Signing up is easy!";

        //actualmessage
        WebElement actualMsg = driver.findElement(By.xpath("//h1[text()='Signing up is easy!']"));
        String actualMessage = actualMsg.getText();

        Assert.assertEquals("not able to navigate register page", expectedMessage, actualMessage);

    }
   @Test
    public void userSholdRegisterAccountSuccessfully(){
       //Find register link and click on it
       WebElement registerLink = driver.findElement(By.xpath("//a[text()='Register']"));
       registerLink.click();
       //Find firstname field element
       WebElement firstName = driver.findElement(By.xpath("//input[@name='customer.firstName']"));
       //Sending first name
       firstName.sendKeys("hello");

       //Find last name field element and sending lastname
       WebElement lastName = driver.findElement(By.xpath("//input[@name='customer.lastName']"));
       lastName.sendKeys("good");

       //Find address field element and sending address
       WebElement address = driver.findElement(By.xpath("//input[@id='customer.address.street']"));
       address.sendKeys("morning");

       //Find city field element and sending city name
       WebElement city =  driver.findElement(By.xpath("//input[@id='customer.address.city']"));
       city.sendKeys("welcome");

       //Find state field element and sending state name
       WebElement state = driver.findElement(By.xpath("//input[@id='customer.address.state']"));
       state.sendKeys("great");

       //Find Zip code field element and sending zip code
       WebElement zipCode = driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"));
       zipCode.sendKeys("done");

       //Find phone field element and sending phone numeber
       WebElement phone = driver.findElement(By.xpath("//input[@name='customer.phoneNumber']"));
       phone.sendKeys("123456");

       //Find SSN field element and sending ssn numeber
       WebElement ssn = driver.findElement(By.xpath("//input[@name='customer.ssn']"));
       ssn.sendKeys("88");

       //Find username field element and sending user name
       WebElement userName = driver.findElement(By.xpath("//input[@name='customer.username']"));
       userName.sendKeys("vitton@ymail.com");

       //Find password field element and sending password
       WebElement password = driver.findElement(By.xpath("//input[@name='customer.password']"));
       password.sendKeys("123456");

       //Find confirm field element and sending confirm password
       WebElement confirmPassword = driver.findElement(By.xpath("//input[@name='repeatedPassword']"));
       confirmPassword.sendKeys("123456");

       //Find register button and click on it
       WebElement registerButton = driver.findElement(By.xpath("//input[@value='Register']"));
       registerButton.click();

       //This is from requirement
       String expectedMessage = "Your account was created successfully. You are now logged in.";

       //actualmessage
       WebElement actualMsg = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
       String actualMessage = actualMsg.getText();

       Assert.assertEquals("not able to navigate register page", expectedMessage, actualMessage);
   }
   @After
    public void tearDown(){
        closeBrowser();
   }
}
