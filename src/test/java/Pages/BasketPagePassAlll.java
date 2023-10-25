package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPagePassAlll {
    private WebDriver driver;
    private By basketButton = By.cssSelector("a.shopping_cart_link");


    public BasketPagePassAlll(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBasketButton() {
        driver.findElement(basketButton).click();
    }
}
