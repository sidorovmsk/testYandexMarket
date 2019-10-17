package steps;

import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.ComparisonPage;
import util.DriverManager;

public class ComparisonSteps {

    ComparisonPage comparisonPage = new ComparisonPage();

    @When("итоговая сумма меньше \"(.*)\"")
    public void stepCheckTotalAmount(int expectedAmount) {
        Assert.assertTrue("Итоговая сумма больше %s", comparisonPage.getTotalAmount() < expectedAmount);

    }

    @When("удалить и проверить отсутствие товара под маркой \"(.*)\"")
    public void stepCheckAfterDel(String name) {
        Actions actions = new Actions(DriverManager.getDriver());
        WebElement webElement = DriverManager.getDriver().findElement(By.xpath("(//*[text()[contains(.,'" + name + "')]]/following-sibling::div//span)[3]"));

        actions.moveToElement(webElement).build().perform();
        webElement.click();

        Assert.assertFalse("Не удалился", webElement.isDisplayed());

    }

    @When("удалить список и проверить отсутствие товаров")
    public void stepCheckAfterAllDel() {

        comparisonPage.toAllDel.click();
        Assert.assertTrue("Не удалился", comparisonPage.checkEmpty.isDisplayed());

    }

    @When("проверяем товары в списке сравнения")
    public void stepCheckProduct() {

        //  Assert.assertTrue("message", string, );
    }

    // (//*[text()[contains(.,'Felix')]]/following-sibling::div//span)[3]
}
