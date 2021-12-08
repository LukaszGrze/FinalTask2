package SecondTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ClothesPage {
    @FindBy(xpath = "//img[@alt='Brown bear printed sweater']")
    private WebElement hpSweaterButton;
    @FindBy(id = "group_1")
    private WebElement sizeDropdown;
    @FindBy(id = "quantity_wanted")
    private WebElement quanityField;
    @FindBy(className = "discount-percentage")
    private WebElement discount;
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement firstProceedButton;
    @FindBy(css = ".add-to-cart")
    private WebElement addProduct;
    @FindBy(css = ".regular-price")
    private WebElement regularPrice;
    @FindBy(css = ".current-price")
    private WebElement currentPrice;

    private final WebDriver driver;

    public ClothesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void selectProduct() {
        hpSweaterButton.click();
    }

    public void selectSizeAndQuanity(String size, String quanity) {
        new Select(sizeDropdown).selectByVisibleText(size);
        quanityField.clear();
        quanityField.sendKeys(quanity);
    }

    public CartPage addToCard() {
        addProduct.click();
        firstProceedButton.click();
        return new CartPage(driver);
    }

    public String checkDiscount() {
        return discount.getText();
    }

    public String checkRegular(){
        return regularPrice.getText();
    }
    public String checkCurrent(){
        return currentPrice.getText();
    }

}
