package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseTest {

    @BeforeMethod()
    public void pageSetUp() {
        WebDriverWait wait;
        // Maksimizacija prozora i navigacija na određenu web stranicu
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @BeforeMethod
    public void userCanLogIn() {
        // Dobijanje korisničkog imena i lozinke iz Excel tabele
        String validUsername = excelReader.getStringData("Sheet1", 1, 0);
        String validPassword = excelReader.getStringData("Sheet1", 1, 1);

        // Unos korisničkog imena i lozinke, te klik na dugme za prijavu
        loginPage.setUsername(validUsername);
        loginPage.setPassword(validPassword);
        loginPage.clickSubmit();

        //Provera da li je lista proizvoda vidljiva
        //Assert.assertTrue(loginPage.productList.isDisplayed());
    }

    @Test(priority = 20)
    public void addingProductToCart() {
        // Testiranje dodavanja proizvoda u korpu putem InventoryPage klase
        inventoryPage.clickOnAddToCart();
    }
}
