package net.adidas.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    @FindBy(css= "[data-auto-id=\"glass-cart-title\"]")
    WebElement cartTitle;

    @FindBy(css= "[data-auto-id=\"glass-checkout-button-right-side\"]")
    WebElement checkOutBtn;

    public CartPage(){
        PageFactory.initElements(driver, this );
    }

    public void verifyCartPageIsOpened(String cartTitleString ){
        wait.forElementToBeDisplayed(5, cartTitle, "Cart Title");
        Assert.assertEquals(cartTitleString, cartTitle.getText());
    }

    public void checkOut(){
        checkOutBtn.click();
    }
}
