package SecondTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(css = "a[class='btn btn-primary']")
    private WebElement secondProceedButton;

    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage setSecondProceedButton() {
        secondProceedButton.click();
        return new CheckoutPage(driver);
    }

}
