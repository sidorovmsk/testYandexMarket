package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class CatalogPage extends BasePageObject {
    @FindBy(xpath = "//div[@class='n-snippet-card2__header']")
    public List<WebElement> productCollection;

    @FindBy(xpath = "//span[@class='NVoaOvqe58']")
    public List<WebElement> makerCollection;

    @FindBy(xpath = "//span[text()='С доставкой']")
    public WebElement clickDelivery;

    @FindBy(xpath = "//*[@id='glpricefrom']")
    public WebElement depositAmount1;

    @FindBy(xpath = "//*[@id='glpriceto']")
    public WebElement depositAmount2;

 @FindBy(xpath = "/html/body/div[1]/div[1]/noindex/div/div/div[2]/div/div[2]/div[1]/a[2]/span[2]")
    public WebElement clickToGoToComparison;


    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name, "pages.CatalogPage");
    }
}
