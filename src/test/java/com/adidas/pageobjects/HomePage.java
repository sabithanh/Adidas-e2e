package net.adidas.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(css = ".gl-modal__close")
    WebElement closeBtn;

    @FindBy(css = ".gl-cta--primary") WebElement goBtn;

    @FindBy(css = "[data-auto-id=\"searchinput\"]")
    WebElement searchField;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void closePopUp() {
        if (closeBtn.isDisplayed()) {
            this.closeBtn.click();
        }
    }

    public void searchProduct(String searchCriteria) {
        searchField.sendKeys(searchCriteria);
        searchField.sendKeys(Keys.ENTER);
    }
}
