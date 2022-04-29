package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Utility extends BaseTest {
    //click method
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    //send text to element
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    //List
    public List<WebElement> listOfWebElementsList(By by){
        return driver.findElements(by);
    }

}
