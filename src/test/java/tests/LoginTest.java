package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser", "Test@123");
        Assert.assertTrue(driver.getCurrentUrl().contains("profile"), "Login failed!");
    }
}
