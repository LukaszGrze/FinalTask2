package SecondTask.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class CheckoutPage {
    @FindBy(name = "confirm-addresses")
    private WebElement selectAddresses;
    @FindBy(name = "confirmDeliveryOption")
    private WebElement shippingMethod;
    @FindBy(id = "payment-option-1")
    private WebElement payByCheckOption;
    @FindBy(className = "custom-checkbox")
    private WebElement conditionsCheckbox;
    @FindBy(id = "payment-confirmation")
    private WebElement confirmationButton;
    @FindBy(xpath = "//div[@class='address']")
    private WebElement successMessage;
    @FindBy(xpath = "//*[@id=\"order-items\"]/div/table/tbody/tr[3]/td[2]")
    private WebElement priceBoxContent;
    @FindBy(xpath = "//*[@id=\"order-details\"]/ul/li[1]")
    private WebElement referenceBoxContent;
    @FindBy(className = "account")
    private WebElement accountButton;

    private final WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String setPriceBox;
    String setReferenceBox;


    public void selectAddress() {

        selectAddresses.click();
    }

    public void setShippingMethod() {

        shippingMethod.click();
    }

    public void paymentOptions() {
        payByCheckOption.click();
        conditionsCheckbox.click();
        confirmationButton.click();

    }

    public void getScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("d:\\screenshot.png"));
    }

    public String checkAddress() {
        return successMessage.getText();
    }


    public void setPriceBox() {
        this.setPriceBox = priceBoxContent.getText();
    }

    public String getPriceBox() {
        return setPriceBox;
    }

    public void setReferenceBox() {
        this.setReferenceBox = referenceBoxContent.getText();
    }

    public String getReferenceBox() {
        return setReferenceBox;
    }


    public YourAccountPage selectAccountButton() {
        accountButton.click();
        return new YourAccountPage(driver);

    }

}
