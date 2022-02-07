package net.adidas.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage extends BasePage {

    @FindBy(css = "[data-auto-id=\"product_container\"] [data-index=\"0\"] a[data-auto-id=\"glass-hockeycard-link\"]")
    WebElement firstProduct;

    public ProductListPage() {
        PageFactory.initElements(driver, this);
    }

    public String selectFirstProduct(){
        wait.forElementToBeDisplayed(3, firstProduct, "First Product");
        String url = firstProduct.getAttribute("href");
        if(firstProduct.isDisplayed()){
            firstProduct.click();
        }
        return url;
    }
}
