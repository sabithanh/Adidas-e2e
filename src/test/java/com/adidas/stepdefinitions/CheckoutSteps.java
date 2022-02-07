package net.adidas.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.adidas.pageobjects.*;

import java.util.logging.Logger;

public class CheckoutSteps {
    final Logger log = Logger.getLogger("CheckoutSteps");

    private HomePage homePage;
    private ProductListPage productListPage;
    private ProductDetailsPage productDetailsPage;
    private CartPage cartPage;
    private DeliveryPage deliveryPage;
    private PaymentPage paymentPage;

    private String value;
    private String collectionPoint;

    public CheckoutSteps() {
        homePage = new HomePage();
        productListPage = new ProductListPage();
        productDetailsPage = new ProductDetailsPage();
        cartPage = new CartPage();
        deliveryPage = new DeliveryPage();
        paymentPage = new PaymentPage();
    }

    @Given("User opens the website")
    public void user_opens_the_website() {
        homePage.goToHomePage();
        homePage.closePopUp();
    }

    @When("user searches for the word {string}")
    public void user_searches_for_the_word(String searchWord) {
        homePage.searchProduct(searchWord);

    }

    @And("^from the opened page \\(PLP\\) click on the first product$")
    public void fromTheOpenedPagePLPClickOnTheFirstProduct() {
        value = productListPage.selectFirstProduct();
        log.info("User successfully selected the first product");
    }

    @Then("^the correct page with correct url should be opened$")
    public void theCorrectPageWithCorrectUrlShouldBeOpened() {
        productDetailsPage.closePopUp();
        productDetailsPage.verifyProduct(value);
    }

    @When("the user picks any size and click on Add to Bag button")
    public void theUserPicksAnySizeAndClickOnAddToBagButton() {
        productDetailsPage.addProductToBag();
    }

    @Then("^one item should be added to the bag$")
    public void oneItemShouldBeAddedToTheBag() {
        productDetailsPage.verifyOneItemAddedToBag();
    }


    @When("user clicks on View Bag button and navigate to the cart page")
    public void userClicksOnViewBagButtonAndNavigateToTheCartPage() {
        productDetailsPage.openCartPage();
    }

    @Then("^the cart page should be opened by the title \"([^\"]*)\"$")
    public void theCartPageShouldBeOpenedByTheTitle(String TitleToBeDisplayed) {
        cartPage.verifyCartPageIsOpened(TitleToBeDisplayed);
    }

    @When("^user clicks on the Checkout button$")
    public void userClicksOnTheCheckoutButton() {
        cartPage.checkOut();
    }

    @Then("^the delivery page should be opened$")
    public void theDeliveryPageShouldBeOpened() {
        deliveryPage.verifyDeliveryPageOpened();
    }

    @When("the user clicks on From A Collection Point from the Get Your Order module")
    public void theUserClicksOnFromACollectionPointFromTheGetYourOrderModule() {
        deliveryPage.selectCollectionPointOrderOption();
    }

    @And("type {string} in the location text box and click Search for Collection Points button")
    public void typeInTheLocationTextBoxAndClickSearchForCollectionPointsButton(String location) {
        deliveryPage.searchLocation(location);
    }

    @And("^pick any collection point from the list$")
    public void pickAnyCollectionPointFromTheList() {
        collectionPoint = deliveryPage.selectCollectionPoint();
    }

    @Then("^the correct collection point is selected$")
    public void theCorrectCollectionPointIsSelected() {
        deliveryPage.verifySelectedCollectionPoint(collectionPoint);
    }

    @When("the user proceeds to the payment step by Review and Pay Button")
    public void theUserProceedsToThePaymentStepByReviewAndPayButton() {
        deliveryPage.proceedToReviewPay();
    }

    @Then("^the major payment methods “PayPal” and “Credit Card” are present$")
    public void theMajorPaymentMethodsPayPalAndCreditCardArePresent() {
        paymentPage.verifyPaymentMethodsPresent();
    }



}
