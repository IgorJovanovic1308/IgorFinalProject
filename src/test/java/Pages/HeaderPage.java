package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends BaseTest {
    public HeaderPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenuButton;

    public HeaderPage(WebDriver driver) {

    }

    public void clickOnBurgerMenuButton() {

        burgerMenuButton.click();
    }
}
