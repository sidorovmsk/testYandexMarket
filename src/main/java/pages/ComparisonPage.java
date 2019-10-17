package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComparisonPage extends BasePageObject {

    @FindBy(xpath = "//div[@class='price']")
    public List<WebElement> totalAmount;

    @FindBy(xpath = "//div[@class='price']")
    public WebElement tot;

    @FindBy(xpath = "//*[text()[contains(.,'Удалить список')]]")
    public WebElement toAllDel;

    @FindBy(xpath = "//*[text()[contains(.,'Как добавить товар в сравнение')]]")
    public WebElement checkEmpty;


    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name, "pages.MainPage");
    }

    public int getTotalAmount() {
        int sum = 0;
        for (int i = 0; i < totalAmount.size(); i++) {
            sum = sum + Integer.parseInt(totalAmount.get(i).getText().replaceAll("\\D", ""));
        }
        return sum;
    }
}
