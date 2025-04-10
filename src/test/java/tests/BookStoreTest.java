package tests;

import org.testng.annotations.Test;
import pages.BookStorePage;

public class BookStoreTest extends BaseTest{

    String bookTitle = "Git Pocket Guide";
    String expectedUrl = "books";

//Test to search for a book from the list of books
    @Test
    public void verifySearchResults() {

        BookStorePage bookstorePage = new BookStorePage(driver);
        bookstorePage.searchBook(bookTitle);
        bookstorePage.validateSearchResult();
    }

    //Test to verify individual book details
    @Test
    public void verifyBookDetails() {

        BookStorePage bookstorePage = new BookStorePage(driver);
        bookstorePage.clickBook();
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains(expectedUrl) : "Page did not redirect to the expected URL. Current URL: " + currentUrl;
    }

}

