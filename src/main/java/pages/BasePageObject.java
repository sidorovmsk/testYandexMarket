package pages;

import annotation.FieldName;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverManager;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public abstract class BasePageObject {
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 60);

    Actions actions = new Actions(DriverManager.getDriver());

    public BasePageObject() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void fillField(WebElement field, String value) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("return arguments[0].style.border='1px solid magenta';", field);
        field.clear();
        field.sendKeys(value);
        js.executeScript("return arguments[0].style.border='1px solid black';", field);
    }


    public void click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public void back() {
        DriverManager.getDriver().navigate().back();
    }

    public void selectMenuItem(List<WebElement> menuItems, String itemName) {
        for (WebElement item : menuItems) {
            if (item.getText().equalsIgnoreCase(itemName)) {
                item.click();
                return;
            }
        }
        Assert.fail("Не найден элмент коллеции - " + itemName);
    }

    public void moveSelectMenuItem(List<WebElement> menuItems, String itemName) {
        for (WebElement item : menuItems) {
            if (item.getText().equalsIgnoreCase(itemName)) {
                actions.moveToElement(item).build().perform();
                return;
            }
        }
        Assert.fail("Не найден элмент коллеции - " + itemName);
    }


    public WebElement getField(String name, String className) throws Exception {
        Class example = Class.forName(className);
        List<Field> fields = Arrays.asList(example.getFields());
        for (Field field : fields) {
            if (field.getAnnotation(FieldName.class).name().equals(name)) {
                return DriverManager.getDriver().findElement(By.xpath(field.getAnnotation(FindBy.class).xpath()));
            }
        }
        Assert.fail("Не объявлен элемент с наименованием " + name);
        return null;
    }

    public abstract WebElement getField(String name) throws Exception;

}