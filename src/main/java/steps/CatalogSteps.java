package steps;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CatalogPage;

import java.util.List;

public class CatalogSteps {

    CatalogPage catalogPage = new CatalogPage();

    @When("выбираем товар под номером \"(.*)\"")
    public void stepAddProduct(String productName) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement webElement =
                catalogPage.productCollection.get(Integer.parseInt(productName)).findElement(By.xpath(".//a[@class='link n-link_theme_blue']|//a[@class='link n-link_theme_blue link_type_cpc']"));
      //  productsInComparison.add(webElement);
        webElement.click();
    }

    @When("кликаем производителя \"(.*)\"")
    public void loadCategory(String itemName) {
        catalogPage.selectMenuItem(catalogPage.makerCollection, itemName);
    }

    @When("жмем на с доставкой")
    public void withDelivery() {
        catalogPage.click(catalogPage.clickDelivery);
    }

    @When("цена от \"(.*)\"")
    public void priceFrom(String amount) {
        catalogPage.depositAmount1.sendKeys(amount);
    }

    @When("цена до \"(.*)\"")
    public void priceUpTo(String amount) {
        catalogPage.depositAmount2.sendKeys(amount);
    }

    @When("переход в сравнение")
    public void goToComparison() {
        catalogPage.clickToGoToComparison.click();
    }


}
