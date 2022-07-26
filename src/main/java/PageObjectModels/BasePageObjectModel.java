package PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePageObjectModel {

     WebDriver webDriver;


    public BasePageObjectModel(WebDriver webDriver) {

        this.webDriver = webDriver;

    }


    public WebElement findElement(By locator){

         return  webDriver.findElement(locator);

    }


    public List<WebElement> findAllElements(By locator){

        return webDriver.findElements(locator);

    }

    public  void select(By locator){

        findElement(locator).click();

    }


    public  void write(By locator,String text){

        findElement(locator).sendKeys(text);
    }

    public  void  remove(By locator){

        findElement(locator).clear();

    }

    public  Boolean isDisplayed(By locator){

        return  findElement(locator).isDisplayed();

    }


    public void shortStop(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public  void averageStop(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public  void longStop(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
