package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

public class LoginTest {

    private WebDriver driver;
    protected ProfilePage profilePage;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
    }

    //Test to verify unsuccessful login
    @Test
    public void unSuccessfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("invalid");
        loginPage.setPassword("invalidPassword");
        loginPage.loginButton().click();
        Assert.assertEquals("Invalid username or password!", loginPage.alertTextValue());
    }

    //Test to verify successful login
    @Test
    public void successfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("satdemoqa");
        loginPage.setPassword("Test@123");
        profilePage = loginPage.clickLogin();
        Assert.assertTrue(profilePage.userNameValue().contains("satdemoqa"), "Username value is incorrect");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
