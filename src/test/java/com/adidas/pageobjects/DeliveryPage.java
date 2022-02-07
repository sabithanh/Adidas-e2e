package net.adidas.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DeliveryPage extends BasePage {

    @FindBy(css = "[data-auto-id=\"delivery-option\"] p[class^=\"delivery-option__title___\"]")
    List<WebElement> collectionPointList;

    @FindBy(css = "[data-auto-id=\"pickpoint-search-input\"]")
    WebElement pickUpLocation;

    @FindBy(css = "[data-auto-id=\"pickup-point-search-button\"]")
    WebElement searchCollectionPointBtn;

    @FindBy(css = "[data-auto-id=\"select-store-button\"]")
    WebElement collectBtn;

    @FindBy(css = "[data-auto-id=\"store-name\"]")
    List<WebElement> storeName;

    @FindBy(css = "[data-auto-id=\"store-name\"]")
    WebElement selectedStoreName;

    @FindBy(css = "[data-auto-id=\"selected-store-header\"]")
    WebElement selectedCollectionPoint;


    @FindBy(css = "input#billingAddress-firstName")
    WebElement firstName;

    @FindBy(css = "input#billingAddress-lastName")
    WebElement lastName;

    @FindBy(css = "input#billingAddress-address1")
    WebElement address;

    @FindBy(css = "input#billingAddress-city")
    WebElement city;

    @FindBy(css = "input#billingAddress-zipcode")
    WebElement zipcode;

    @FindBy(css = "input#billingAddress-emailAddress")
    WebElement email;

    @FindBy(css = "[data-auto-id=\"review-and-pay-button\"]")
    WebElement reviewAndPayBtn;

    public DeliveryPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyDeliveryPageOpened() {
        String URL = driver.getCurrentUrl();
        wait.forLoading(10);
        Assert.assertEquals("https://www.adidas.co.uk/delivery", URL);
    }

    public void selectCollectionPointOrderOption() {
        wait.forLoading(6);
        wait.forPresenceOfElements(10, By.cssSelector("[data-auto-id=\"delivery-option\"] p[class^=\"delivery-option__title___\"]"), "Collection list");
        WebElement collectionPoint = collectionPointList.get(2);

        if (collectionPoint != null) {
            collectionPoint.click();
        }
    }

    public void searchLocation(String location) {
        pickUpLocation.sendKeys(location);
        wait.forElementToBeDisplayed(10, searchCollectionPointBtn, "Search button");
        moveToElement(By.cssSelector("[data-auto-id=\"pickup-point-search-button\"]")).click().perform();
        searchCollectionPointBtn.click();
    }

    public String selectCollectionPoint() {
        wait.forElementToBeDisplayed(15, collectBtn, "Collect button");
        String storeNameTxt = storeName.get(0).getText();
        if (collectBtn.isDisplayed()) {
            collectBtn.click();
        }
        return storeNameTxt;
    }

    public void verifySelectedCollectionPoint(String collectionPoint) {
        wait.forElementToBeDisplayed(10, selectedCollectionPoint, "Selected collection point");
        Assert.assertEquals(collectionPoint, selectedStoreName.getText());
    }

    public void proceedToReviewPay() {
        firstName.sendKeys("Test First Name");
        lastName.sendKeys("Test Last Name");
        address.sendKeys("Test Address");
        city.sendKeys("Test City");
        zipcode.sendKeys("WC2N 5DU");
        wait.forElementToBeDisplayed(5, email, "Email text box");
        email.sendKeys("Test@last.com");
        reviewAndPayBtn.click();
    }
}
