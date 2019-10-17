package steps;

import cucumber.api.java.en.When;
import pages.MainPage;


public class MainSteps {

    MainPage mainPage = new MainPage();

    @When("наводим на пункт меню \"(.*)\"")
    public void selectMenuItem(String itemName) {
        mainPage.moveSelectMenuItem(mainPage.mainMenu, itemName);
    }

    @When("выбран подпункт меню \"(.*)\"")
    public void selectSubMenuItem(String itemName) {
        mainPage.selectMenuItem(mainPage.subMenu, itemName);
    }

    @When("подтвержден регион")
    public void acceptRegion() {
        mainPage.click(mainPage.acceptRegion);
    }

    @When("открываем все категории")
    public void loadCategory() {
        mainPage.click(mainPage.clickAllCategory);
    }
}
