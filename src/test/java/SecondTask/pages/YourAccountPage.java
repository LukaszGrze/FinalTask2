package SecondTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {
    @FindBy(id = "category-3")
    private WebElement clothesButton;
    @FindBy(id = "history-link")
    private WebElement historyButton;

    private final WebDriver driver;

    public YourAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ClothesPage selectClothes() {

        clothesButton.click();
        return new ClothesPage(driver);
    }

    public HistoryPage selectHistory(){
        historyButton.click();
        return new HistoryPage(driver);
    }
}
