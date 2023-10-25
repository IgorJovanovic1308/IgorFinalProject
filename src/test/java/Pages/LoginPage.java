package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(id = "inventory_container")
    public WebElement productList;

    public WebElement errorMessage;

    public LoginPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username) {

        usernameField.sendKeys(username);
    }

    public void setPassword(String password) {

        passwordField.sendKeys(password);
    }

    public void clickSubmit() {

        loginButton.click();
    }
}
