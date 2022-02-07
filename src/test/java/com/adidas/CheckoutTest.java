package net.adidas;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/Checkout.feature"},
        plugin = {"pretty",
                "json:target/cucumber_json_reports/checkout.json",
                "html:target/checkout-html"},
        glue = {"net.adidas.driver",
                "net.adidas.pageobjects",
                "net.adidas.stepdefinitions"})

public class CheckoutTest {
}


