package Base;

import Pages.HeaderPage;
import Pages.LoginPage;
import Pages.InventoryPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;
    public ExcelReader excelReader;
    public InventoryPage inventoryPage;
    public HeaderPage headerPage;

    @BeforeClass
    public void setUp() throws IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        loginPage = new LoginPage(driver);
        excelReader = new ExcelReader("C:\\Users\\Win7\\Desktop\\Logins.xlsx");
        inventoryPage = new InventoryPage();
        headerPage = new HeaderPage();
    }

    @AfterClass
    public void tearDown() {

    }
}
