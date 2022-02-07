package net.adidas.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage{
    @FindBy(css = "[data-auto-id=\"credit_card-radio-button\"]")
    WebElement creditCardOption;

    @FindBy(css = "[data-auto-id=\"paypal-radio-button\"]")
    WebElement payPalOption;

    public PaymentPage(){
        PageFactory.initElements(driver, this);
    }

    public void verifyPaymentMethodsPresent(){
        wait.forLoading(10);
        wait.forElementToBeDisplayed(10,creditCardOption,"Credit card option");
        Assert.assertTrue(creditCardOption.isDisplayed());
        Assert.assertTrue(payPalOption.isDisplayed());
    }
}
