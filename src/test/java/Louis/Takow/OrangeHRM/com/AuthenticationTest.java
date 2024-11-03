package Louis.Takow.OrangeHRM.com;

import Pages.DashboardPage;
import base.Hooks;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AuthenticationTest extends Hooks {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Test
    public void NoUserCredentialsTest() {
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // click login button
        loginPage.clickLogin();

        // Assert error messages
        Assert.assertEquals(loginPage.getErrorMessage(0), "The username field is required.");
        Assert.assertEquals(loginPage.getErrorMessage(1), "The password field is required.");
        Assert.assertEquals(loginPage.getAlertDangerText(), "×\nError: Please check the form below for errors");
    }

    @Test
    public void OnlyUsernameEntryTest() {
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Insert the username
        loginPage.enterUsername("admin");
        loginPage.clickLogin();

        // Assert password field error message
        Assert.assertEquals(loginPage.getErrorMessage(0), "The password field is required.");
        Assert.assertEquals(loginPage.getAlertDangerText(), "×\nError: Please check the form below for errors");
    }

    @Test
    public void OnlyPasswordEntryTest() {
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Insert the password
        loginPage.enterPassword("password");
        loginPage.clickLogin();

        // Assert username field error message
        Assert.assertEquals(loginPage.getErrorMessage(0), "The username field is required.");
        Assert.assertEquals(loginPage.getAlertDangerText(), "×\nError: Please check the form below for errors");
    }

    @Test
    public void invalidUsernameAndPasswordTest() {
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Insert invalid credentials
        loginPage.enterUsername("invalid username");
        loginPage.enterPassword("invalid password");
        loginPage.clickLogin();

        // Assert error message
        Assert.assertEquals(loginPage.getAlertDangerText(), "×\nError: The username or password is incorrect.");
    }

    @Test
    public void validUsernameAndInvalidPasswordTest() {
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Insert valid username and invalid password
        loginPage.enterUsername("admin");
        loginPage.enterPassword("invalid password");
        loginPage.clickLogin();

        // Assert error message
        Assert.assertEquals(loginPage.getAlertDangerText(), "×\nError: The username or password is incorrect.");
    }

    @Test
    public void invalidUsernameAndValidPasswordTest() {
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Insert invalid username and valid password
        loginPage.enterUsername("invalid username");
        loginPage.enterPassword("password");
        loginPage.clickLogin();

        // Assert error message
        Assert.assertEquals(loginPage.getAlertDangerText(), "×\nError: The username or password is incorrect.");
    }

    @Test
    public void validCredentialsLoginAndLogoutTest() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Enter valid credentials and log in
        loginPage.enterUsername("admin");
        loginPage.enterPassword("password");
        loginPage.clickLogin();

        // Verify dashboard title
        Assert.assertEquals(dashboardPage.getDashboardTitle(), "Dashboard");

        // Log out
        dashboardPage.clickUserDropdown();
        dashboardPage.clickLogout();

        // Verify that the logout success message is displayed on the login page
        Assert.assertEquals(loginPage.getLogoutSuccessMessage(), "×\nSuccess: You have successfully logged out.");
    }
}
