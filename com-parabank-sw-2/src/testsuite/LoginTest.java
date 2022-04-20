package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Find username field and sending valid username
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("vitton@ymail.com");

        //Find password field and sending valid password
        WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys("123456");

        //Find login button and click on it
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //This is from requirement
        String expectedMessage = "Accounts Overview";

        //actual message
        WebElement actual = driver.findElement(By.xpath("//h1[text()='Accounts Overview']"));
        String actualMessage = actual.getText();

        Assert.assertEquals("Not navigate to login page",expectedMessage, actualMessage);
    }
    @Test
    public void verifyTheErrorMessage(){
        //Find username field and sending invalid username
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("ram@gmail.com");

        //Find password field and sending invalid password
        WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys("123");

        //Find login button and click on it
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //This is from requirement
        String expectedMessage = "The username and password could not be verified.";

        //actual message
        WebElement actual = driver.findElement(By.xpath("//p[text()='The username and password could not be verified.']"));
        String actualMessage = actual.getText();

        Assert.assertEquals("Not navigate to login page",expectedMessage, actualMessage);
    }
    @Test
    public void userShouldLogOutSuccessfully(){
        //Find username field and sending valid username
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("vitton@ymail.com");

        //Find password field and sending valid password
        WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys("123456");

        //Find login button and click on it
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //Find logout button and click on it
        WebElement logOut = driver.findElement(By.xpath("//a[text()='Log Out']"));
        logOut.click();

        //This is from requirement
        String expectedMessage = "Customer Login";

        //actual message
        WebElement actual = driver.findElement(By.xpath("//div[@id='leftPanel']//h2[text()='Customer Login']"));
        String actualMessage = actual.getText();

        Assert.assertEquals("Not navigate to login page",expectedMessage, actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
