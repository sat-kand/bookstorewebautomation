package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    WebDriver driver;

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    //declaring locator for the elements in profile page
    private final By userNameLocator = By.id("userName-value");
    public String userNameValue(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameLocator));
        return header.getText();
    }
}
