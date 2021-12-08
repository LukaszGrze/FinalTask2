package SecondTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HistoryPage {
    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    private WebElement price;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/table/tbody/tr[1]/th")
    private WebElement reference;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/table/tbody/tr[1]/td[4]")
    private WebElement status;

    private final WebDriver driver;

    public HistoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String checkPrice() {
        return price.getText();
    }
    public String checkReference() {
        return reference.getText();
    }
    public String checkStatus() {
        return status.getText();
    }

}
