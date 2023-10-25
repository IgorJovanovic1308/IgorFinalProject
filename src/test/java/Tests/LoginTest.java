package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {

        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test
    public void userCanLogIn() {

        String validUsername = excelReader.getStringData("Sheet1", 1, 0);
        String validPassword = excelReader.getStringData("Sheet1", 1, 1);


        loginPage.setUsername(validUsername);
        loginPage.setPassword(validPassword);
        loginPage.clickSubmit();


        Assert.assertTrue(loginPage.productList.isDisplayed());
    }

    @Test
    public void userCannotLogin() {

        String invalidUsername = excelReader.getStringData("Sheet1", 1, 1);
        String invalidPassword = excelReader.getStringData("Sheet1", 1, 3);


        loginPage.setUsername(invalidUsername);
        loginPage.setPassword(invalidPassword);
        loginPage.clickSubmit();

    }
}
