package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BookStorePage {

    WebDriver driver;
    public BookStorePage(WebDriver driver) {
        this.driver = driver;
    }

    //declaring locator for the elements in books page
    private By searchBox = By.id("searchBox");
    private By bookLink = By.xpath("//a[contains(text(),'Git Pocket Guide')]");

    //method to search for books in the list
    public void searchBook(String title) {
        WebElement searchElement = driver.findElement(searchBox);
        searchElement.sendKeys(title);
    }

    //method to click the book details
    public void clickBook() {
        driver.findElement(bookLink).click();
    }

    //Validating the search results with the search text
    public void validateSearchResult() {
        assert driver.findElement(bookLink).isDisplayed(): "Search Result not displayed";

    }
}
