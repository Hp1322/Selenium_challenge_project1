package amazon;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import javax.swing.text.Utilities;
import java.util.ArrayList;
import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void getAllProductName() throws InterruptedException {
        //accept cookies
        clickOnElement(By.xpath("//input[@class='a-button-input celwidget']"));
        Thread.sleep(1000);
        //sending name
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");
        // click on button
        clickOnElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input nav-progressive-attribute']"));

        //click on dell checkbox
        clickOnElement(By.xpath("//ul[@aria-labelledby='p_89-title']//li[@aria-label='Dell']//i[@class='a-icon a-icon-checkbox']"));
        Thread.sleep(1000);
       //getting list
        List<WebElement> default1 = listOfWebElementsList(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

        System.out.println(default1.size());



        for (WebElement data:default1) {
            System.out.println(data.getText());
        }

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
