package PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasketPageObjectModel extends BasePageObjectModel{

    By tableRow = new By.ByCssSelector("small.muted");

    By addBookLocator = By.xpath("//form/input[@name='quantity']");

    By refreshLocator = new By.ByCssSelector("i.fa.fa-refresh.green-icon");

    By removeLocator = new By.ByCssSelector("i.fa.fa-times.red-icon");


    public BasketPageObjectModel(WebDriver webDriver) {
        super(webDriver);
    }

    private List<WebElement> getBooks(){

        return  findAllElements(tableRow);
    }

    public  boolean checkIfBookAdded(){

        System.out.println(getBooks().size());
        return  getBooks().size() > 0;

    }

    public  boolean checkIfEmpty(){

        System.out.println(getBooks().size());
        return  getBooks().size() == 0;

    }


    public void addBook(){

       String value = findElement(addBookLocator).getAttribute("value");

       int newValue = Integer.parseInt(value) + 1;

       String newValueString = String.valueOf(newValue);

        shortStop();

        remove(addBookLocator);

        shortStop();

        write(addBookLocator,newValueString);

        select(refreshLocator);

    }

    public  void removeBook(){

        select(removeLocator);

    }

}
