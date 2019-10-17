package steps;

import cucumber.api.java.en.When;
import pages.ProductPage;

public class ProductSteps {

    ProductPage productPage = new ProductPage();

    @When("добавляем в сравнение")
    public void clickToAddToComparison() {
        productPage.click(productPage.addToComparison);
        productPage.back();
    }


}
