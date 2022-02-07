package net.adidas.driver;

import io.cucumber.java.Before;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.logging.Logger;

public class Setup {

    public static WebDriver driver;
    final Logger log = Logger.getLogger("CheckoutSteps");

    @Before
    public void setWebDriver() throws IOException {
        ConfigSettings configSettings = new ConfigSettings();
        configSettings.getConfigSettings();

        String browser = ConfigSettings.getWebBrowser();

        if (browser == null) {
            browser = "chrome";
        }
        if (ConfigSettings.getDriver().equals("")) {
            Assert.fail("Webdriver path is not set. Please set 'driver' value in src/test/resources/config.properties");
        }
        switch (browser) {
            case "chrome":
                log.info("Using Chrome browser");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("disable-infobars");
                System.setProperty("webdriver.chrome.driver", ConfigSettings.getDriver());
                driver = new ChromeDriver(chromeOptions);
                driver.manage().deleteAllCookies();
                break;
            case "firefox":
                log.info("Using Firefox browser");
                System.setProperty("webdriver.gecko.driver", ConfigSettings.getDriver());
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
    }
}
