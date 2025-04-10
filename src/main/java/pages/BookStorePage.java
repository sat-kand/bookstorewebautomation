package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BookStorePage {

    WebDriver driver;

    By searchBox = By.id("searchBox");
    By bookLink = By.xpath("//a[contains(text(),'Git Pocket Guide')]");
    By bookTitle = By.id("title-wrapper");
    By bookAuthor = By.id("author-wrapper");
    By bookPublisher = By.id("publisher-wrapper");

    public BookStorePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchBook(String title) {
        WebElement searchElement = driver.findElement(searchBox);
        searchElement.sendKeys(title);
    }

    public void clickBook() {
        driver.findElement(bookLink).click();
    }

    public void validateSearchResult() {
        assert driver.findElement(bookLink).isDisplayed(): "Search Result not displayed";

    }

    public void validateBookDetails(String expectedTitle, String expectedAuthor, String expectedPublisher) {
        String actualTitle = driver.findElement(bookTitle).getText();
        String actualAuthor = driver.findElement(bookAuthor).getText();
        String actualPublisher = driver.findElement(bookPublisher).getText();

        assert actualTitle.contains(expectedTitle) : "Title mismatch!";
        assert actualAuthor.contains(expectedAuthor) : "Author mismatch!";
        assert actualPublisher.contains(expectedPublisher) : "Publisher mismatch!";
    }
}
