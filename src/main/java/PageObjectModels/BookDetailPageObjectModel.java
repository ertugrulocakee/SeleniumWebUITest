package PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookDetailPageObjectModel extends BasePageObjectModel {

    By addBookLocator = new By.ByCssSelector("a#button-cart.add-to-cart.btn-orange.btn-ripple");

    public BookDetailPageObjectModel(WebDriver webDriver) {
        super(webDriver);
    }

    public  boolean isOnBookDetailPage(){

       return  isDisplayed(addBookLocator);

    }

    public  void addToBasket(){


        try {

            Thread.sleep(2000);
            select(addBookLocator);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
