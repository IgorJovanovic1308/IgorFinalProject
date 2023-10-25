package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePagePassAll {
    private WebDriver driver;
    private By addToCartBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By addToCartBikeLightButton = By.id("add-to-cart-sauce-labs-bike-light");


    public HomePagePassAll(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCartBackpack() {
        driver.findElement(addToCartBackpackButton).click();
    }

    public void clickAddToCartBikeLight() {
        driver.findElement(addToCartBikeLightButton).click();
    }


}