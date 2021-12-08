package SecondTask;

import SecondTask.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StorePageBase {

    MainPage mainPage;
    LoginPage loginPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    ClothesPage clothesPage;
    YourAccountPage yourAccountPage;
    HistoryPage historyPage;
    protected WebDriver driver;


    String URL = "https://mystore-testlab.coderslab.pl/";
    String expectedDiscount = "SAVE 20%";
    String expectedAddress = "Donnie Darko\n" + "Company\n" + "Address\n" + "City\n" + "77-999\n" + "United Kingdom";
    String expectedStatus = "Awaiting check payment";
    String username = "donnie.darko11111@gmail.com";
    String password = "donnie";

    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        mainPage = new MainPage(driver);
    }

    @After
    public void driverQuit() {
        driver.quit();
    }


}
