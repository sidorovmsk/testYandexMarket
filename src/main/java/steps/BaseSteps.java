package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.BasePageObject;
import util.DriverManager;
import util.TestProperties;

import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    public static Properties properties = TestProperties.getInstance().getProperties();

    public static BasePageObject pageObject;

    private static HashMap<String, String> variables = new HashMap<>();

    @Before
    public void startScenario() {
        WebDriver driver = DriverManager.getDriver();
        driver.get(properties.getProperty("app.url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }

    @After
    public void afterMethod(Scenario scenario) {
        if (scenario.isFailed()) {
            takeScreenshot();
        }
        DriverManager.quitDriver();
    }

    @Attachment(type = "image/png", value = "Скриншот в момент ошибки")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public static void setVariables(String key, String value) {
        variables.put(key, value);
    }


}

