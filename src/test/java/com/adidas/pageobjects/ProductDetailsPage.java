package net.adidas.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends BasePage {

    @FindBy(css = ".gl-modal__close")
    WebElement closeBtn;

    @FindBy(css = "[data-auto-id=\"size-selector\"]")
    WebElement sizeSelector;

    @FindBy(css = "[data-auto-id=\"add-to-bag\"]")
    WebElement addToBagBtn;

    @FindBy(css = "[data-auto-id=\"added-to-bag-modal-title\"]")
    WebElement addedToBagTitle;

    @FindBy(css = "[data-auto-id=\"view-bag-desktop\"]")
    WebElement viewBagBtn;

    public ProductDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    public void closePopUp() {
        wait.forElementToBeDisplayed(10, closeBtn, "Close popup button");
        if (closeBtn.isEnabled()) {
            this.closeBtn.click();
        }
    }

    public void addProductToBag() {
        wait.forElementToBeDisplayed(10, sizeSelector, "Size selector");
        if (sizeSelector.isEnabled()) {
            sizeSelector.click();
        }
        wait.forElementToBeDisplayed(10, sizeSelector, "Size selector");
        addToBagBtn.click();
    }

    public void verifyOneItemAddedToBag() {
        wait.forElementToBeDisplayed(15, addedToBagTitle, "Title popup");
        Assert.assertEquals("SUCCESSFULLY ADDED TO BAG!", addedToBagTitle.getText());
    }

    public void openCartPage() {
        viewBagBtn.click();
    }

    public void verifyProduct(String value) {
        Assert.assertEquals(driver.getCurrentUrl(), value);
    }
}
