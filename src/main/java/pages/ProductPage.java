package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePageObject {

    @FindBy(xpath = "//html/body/div[1]/div[5]/div[2]/div/div/div/div[2]/div/div/span[1]")
    public WebElement addToComparison;


    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name, "pages.MainPage");
    }
}
