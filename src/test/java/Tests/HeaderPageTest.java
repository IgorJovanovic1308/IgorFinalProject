package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderPageTest extends BaseTest {

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
    }

    @Test
    public void openBurgerMenu() {
        // Testiranje otvaranja menija putem HeaderPage klase
        headerPage.clickOnBurgerMenuButton();
    }

    @Test
    public void openBurgerMenuAndLogout() {
        // Testiranje otvaranja menija putem HeaderPage klase
        headerPage.clickOnBurgerMenuButton();

        // Pronalaženje elementa za odjavljivanje po ID i izvršavanje klika
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();
    }
}
