package Elements;

import PageObjectModels.BasePageObjectModel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.Scanner;

public class SearchBox extends BasePageObjectModel {

    By searchBoxLocator = By.xpath("//input[@id='search-input']");
    By submitButtonLocator = new By.ByCssSelector("span.common-sprite.button-search");

    public SearchBox(WebDriver webDriver) {
        super(webDriver);
    }

    public  void  search() throws FileNotFoundException {


        write(searchBoxLocator,word());

        select(submitButtonLocator);

    }

    private  String word() throws FileNotFoundException {

        File file = new File("csv/selenium.csv");
        String result = "";

        Scanner s = new Scanner(file);
        while(s.hasNextLine()) {
            String instance = s.nextLine();
            String[] split = instance.split(";");
            for(int i = 0; i < split.length; i++) {
                result += split[i];
                result += " ";
            }

        }
        s.close();
        return  result;
    }

}
