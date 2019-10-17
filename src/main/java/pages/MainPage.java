package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class MainPage extends BasePageObject {

    @FindBy(xpath = "//div[contains(@class,'n-w-tab n-w-tab_interaction_hover-navigation-menu n-w-tab_type_navigation-menu-vertical i-bem n-w-tab_js_inited')]")
    public List<WebElement> mainMenu;

    @FindBy(xpath = "//a[contains(@class,'link n-w-navigation-menu__node-link b-zone b-spy-events i-bem')]")
    public List<WebElement> subMenu;

    @FindBy(xpath = "//div[@class='n-region-notification__actions-cell']")
    public WebElement acceptRegion;

    @FindBy(xpath = "//div[@class='n-w-tab__control b-zone b-spy-events i-bem n-w-tab__control_js_inited']")
    public WebElement clickAllCategory;

    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name, "pages.MainPage");
    }

}
