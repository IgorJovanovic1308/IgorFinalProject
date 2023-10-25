package Tests;

import Base.BaseTestPassAll;
import Pages.BasketPagePassAlll;
import Pages.HomePagePassAll;
import Pages.LoginPagePassAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestsPassAll extends BaseTestPassAll {
    private boolean isBasketTest = false;

    @BeforeMethod
    public void setUp() {

        driver.get("https://www.saucedemo.com/");
        LoginPagePassAll loginPage = new LoginPagePassAll(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @AfterMethod
    public void tearDown() {

        if (!isBasketTest) {
            driver.quit();
        }

        isBasketTest = false;
    }

    @Test
    public void testLoginRemoveAddToCart() throws InterruptedException {
        HomePagePassAll homePagePassAll = new HomePagePassAll(driver);

        homePagePassAll.clickAddToCartBackpack();
        homePagePassAll.clickAddToCartBikeLight();
        Thread.sleep(1000);

        BasketPagePassAlll basketPage = new BasketPagePassAlll(driver);
        basketPage.clickBasketButton();
        Thread.sleep(2000);


        WebElement removeBackpack = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeBackpack.click();

        WebElement removeBikeLight = driver.findElement(By.id("remove-sauce-labs-bike-light"));
        removeBikeLight.click();


        WebElement continueShoppingButton = driver.findElement(By.id("continue-shopping"));
        continueShoppingButton.click();
        Thread.sleep(2000);


        homePagePassAll.clickAddToCartBackpack();
        basketPage.clickBasketButton();
        isBasketTest = true;
        Thread.sleep(1000);


        WebElement checkoutButton = driver.findElement(By.cssSelector(".btn.btn_action.btn_medium.checkout_button"));
        checkoutButton.click();
        Thread.sleep(1000);

        WebElement firstNameField = driver.findElement(By.id("first-name"));
        firstNameField.sendKeys("Petar");
        Thread.sleep(1000);

        WebElement lastNameField = driver.findElement(By.id("last-name"));
        lastNameField.sendKeys("Petrovic");
        Thread.sleep(1000);

        WebElement postalCodeField = driver.findElement(By.id("postal-code"));
        postalCodeField.sendKeys("11000");

        WebElement continueButton = driver.findElement(By.cssSelector(".submit-button.btn.btn_primary.cart_button.btn_action"));
        continueButton.click();
        Thread.sleep(1000);

        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
        Thread.sleep(1000);


        WebElement backToProductsButton = driver.findElement(By.id("back-to-products"));
        backToProductsButton.click();
        Thread.sleep(1000);


        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        Thread.sleep(1000);


        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();
        Thread.sleep(1000);


        driver.quit();
    }
}
