package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //declaring element locator and web elements in login page
    private By userNameLocator = By.id("userName");
    private WebElement userNameField(){
        return driver.findElement(userNameLocator);
    }
    public void setUserName(String userName){
        userNameField().sendKeys(userName);
    }

    private By passwordLocator = By.id("password");
    private WebElement passwordField(){
        return driver.findElement(passwordLocator);
    }
    public void setPassword(String password){
        passwordField().sendKeys(password);
    }

    private By loginButtonLocator = By.id("login");
    public WebElement loginButton(){
        return driver.findElement(loginButtonLocator);
    }
    private By alertTextLocator = By.id("name");
    private WebElement alertText(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(alertTextLocator));
        return alert;
    }
    public String alertTextValue(){
        String text =  alertText().getText();
        return text;
    }

    public ProfilePage clickLogin(){
        loginButton().click();
        return new ProfilePage(driver);
    }
}
