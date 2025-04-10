package tests;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BookStorePage;

public class BookStoreTest extends BaseTest{

    String bookTitle = "Git Pocket Guide";
    String expectedUrl = "https://demoqa.com/books#google_vignette";


    @Test
    public void verifySearchResults() {

        BookStorePage bookstorePage = new BookStorePage(driver);
        bookstorePage.searchBook(bookTitle);
        bookstorePage.validateSearchResult();
    }

    @Test
    public void verifyBookDetails() {

        BookStorePage bookstorePage = new BookStorePage(driver);
        bookstorePage.clickBook();
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.equals(expectedUrl) : "Page did not redirect to the expected URL. Current URL: " + currentUrl;
    }

//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }
}

