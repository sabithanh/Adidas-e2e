package net.adidas.pageobjects;

import net.adidas.driver.Setup;
import net.adidas.driver.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    public final static String URL = "https://www.adidas.co.uk/";
    protected WebDriver driver;
    public Wait wait;


    public BasePage() {
        this.driver = Setup.driver;
        this.wait = new Wait(driver);
    }

    public void goToHomePage(){
        driver.get(URL);
        wait.forLoading(5);
    }

    public Actions moveToElement(By elementLocator) {
        Actions act =  new Actions(driver);
        return act.moveToElement(driver.findElement(elementLocator));
    }
}
