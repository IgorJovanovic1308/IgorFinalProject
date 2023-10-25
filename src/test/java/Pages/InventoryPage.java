package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class InventoryPage extends BaseTest {
    public InventoryPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartButton;

    public void clickOnAddToCart() {

        addToCartButton.click();
    }
}
