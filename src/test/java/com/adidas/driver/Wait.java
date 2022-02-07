package net.adidas.driver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Wait {

    private final WebDriver driver;

    public Wait(WebDriver driver) {
        this.driver = driver;
    }

    private void waitUntilCondition(ExpectedCondition condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    /**
     *
     * @param timeout Timeout in seconds
     */
    public void forLoading(int timeout) {
        forLoading(timeout / 2, timeout / 2);
    }

    /**
     *
     * @param timeout Wait timeout in seconds
     * @param sleepTimeout Sleep timeout in seconds
     */
    public void forLoading(int timeout, int sleepTimeout) {
        ExpectedCondition<Object> expectation = ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";");
        String timeoutMessage = "Page didn't load after " + timeout + " seconds.";
        try {
            // ideally this shouldn't be needed, but some pages take some time to actually render elements after page ready
//            Thread.sleep(sleepTimeout * 1000L);
            waitUntilCondition(expectation, timeoutMessage, timeout);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    /**
     *
     * @param timeout Timeout in seconds
     * @param webElement WebElement to wait for
     * @param webElementName Name of the WebElement
     */
    public void forElementToBeDisplayed(int timeout, WebElement webElement, String webElementName) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(webElement);
        String timeoutMessage = webElementName + " wasn't displayed after " + timeout + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    /**
     *
     * @param timeout Timeout in seconds
     * @param elementLocator WebElement locator
     * @param elementName Name of the WebElement
     */
    public void forPresenceOfElements(int timeout, By elementLocator, String elementName) {
        ExpectedCondition<List<WebElement>> condition = ExpectedConditions.presenceOfAllElementsLocatedBy(elementLocator);
        String timeoutMessage = elementName + " elements were not displayed after " + timeout + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }
}