package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage {
    private WebDriver driver;

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By dashboardTitle = By.className("pagetitle");
    private By userDropdown = By.className("caret"); // This finds all dropdown elements with the class 'caret'
    private By logoutOption = By.xpath("//a[normalize-space()='Logout']");

    // Methods
    public String getDashboardTitle() {
        return driver.findElement(dashboardTitle).getText();
    }

    public void clickUserDropdown() {
        // Get all elements with the class name 'caret' and click the second one
        List<WebElement> dropdowns = driver.findElements(userDropdown);
        dropdowns.get(1).click(); // Directly click the second dropdown
    }

    public void clickLogout() {
        WebElement logoutBtn = driver.findElement(logoutOption);
        logoutBtn.click();
    }
}
