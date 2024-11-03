package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.className("btn-primary");
    private By errorMessages = By.className("alert-msg");
    private By alertDanger = By.className("alert-danger");
    private By logoutSuccessMessage = By.className("alert-success");

    // Methods
    public void enterUsername(String username) {
        WebElement userNameField = driver.findElement(usernameInput);
        userNameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(passwordInput);
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }

    public String getErrorMessage(int index) {
        return driver.findElements(errorMessages).get(index).getText();
    }

    public String getAlertDangerText() {
        return driver.findElement(alertDanger).getText();
    }

    public String getLogoutSuccessMessage() {
        return driver.findElement(logoutSuccessMessage).getText();
    }
}

