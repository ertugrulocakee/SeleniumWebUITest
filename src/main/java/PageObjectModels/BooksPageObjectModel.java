package PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class BooksPageObjectModel extends BasePageObjectModel{

    By listOptionsLocator = By.id("faceted-search-list-total");
    By bookLocator = new By.ByCssSelector("a.pr-img-link");

    private  List<WebElement> getAllBooks(){

       return findAllElements(bookLocator);

    }

    public BooksPageObjectModel(WebDriver webDriver) {
        super(webDriver);
    }

    public  boolean isOnBooksPage(){

        return isDisplayed(listOptionsLocator);

    }

    public  void selectBook(){

        Random r=new Random();
        int number =r.nextInt(getAllBooks().size());

        getAllBooks().get(number).click();

    }

}
