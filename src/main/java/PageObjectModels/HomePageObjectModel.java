package PageObjectModels;

import Elements.SearchBox;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObjectModel extends BasePageObjectModel{

    SearchBox searchBox;

    By logoLocator = new By.ByCssSelector("div.logo-icon");

    By countValueLocator = By.id("cart-items");

    By basketLocator = By.id("cart");

    By goToBasketPageLocator = By.id("js-cart");

    public HomePageObjectModel(WebDriver webDriver) {
        super(webDriver);

        searchBox = new SearchBox(webDriver);

    }

    public SearchBox searchBox(){

        return  this.searchBox;

    }


    private  int getBasketCount(){

        String count = findElement(countValueLocator).getText();
        System.out.println(count);
        return  Integer.parseInt(count);

    }

    public  boolean isOnHomePage(){

        return  isDisplayed(logoLocator);

    }


    public boolean isBookCountUp(){

         return getBasketCount() > 0;
    }

    public  void openBasket(){

       select(basketLocator);

    }

    public  void goToBasketPage(){

        select(goToBasketPageLocator);

    }


}
