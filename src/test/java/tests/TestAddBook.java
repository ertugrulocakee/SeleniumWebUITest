package tests;

import PageObjectModels.BasketPageObjectModel;
import PageObjectModels.BookDetailPageObjectModel;
import PageObjectModels.BooksPageObjectModel;
import PageObjectModels.HomePageObjectModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;


public class TestAddBook extends BaseTest {

     HomePageObjectModel homePage;
     BasketPageObjectModel basketPage;
     BookDetailPageObjectModel bookDetailPage;
     BooksPageObjectModel booksPage;


     @Test
     @Order(1)
     public  void  searchBook() throws FileNotFoundException {

         homePage = new HomePageObjectModel(driver);
         booksPage = new BooksPageObjectModel(driver);

         homePage.isOnHomePage();

         homePage.searchBox().search();
         Assertions.assertTrue(booksPage.isOnBooksPage() , "Not on books page!");

     }

    @Test
    @Order(2)
    public  void  selectBook(){

        bookDetailPage = new BookDetailPageObjectModel(driver);

        booksPage.selectBook();
        Assertions.assertTrue(bookDetailPage.isOnBookDetailPage(), "Not on book detail page!");

    }

    @Test
    @Order(3)
    public  void  addBook(){

        bookDetailPage.addToBasket();

        Assertions.assertTrue(bookDetailPage.isOnBookDetailPage(), "Not on book detail page!");

        try {
            Thread.sleep(2000);
            Assertions.assertTrue(homePage.isBookCountUp(), "Book count did not increase!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    @Order(4)
    public  void  goToBasket(){

         basketPage = new BasketPageObjectModel(driver);

        homePage.openBasket();

        try {

            Thread.sleep(2000);
            homePage.goToBasketPage();

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertTrue(basketPage.checkIfBookAdded() , "Book was not added to basket!");

        basketPage.addBook();

        try {

            Thread.sleep(3000);
            basketPage.removeBook();

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(2000);
            Assertions.assertTrue(basketPage.checkIfEmpty(), "There are two books in the basket!");
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
