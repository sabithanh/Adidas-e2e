Feature: Checkout

  Scenario: Search for a product and checkout
    Given User opens the website
    When user searches for the word "running"
    And from the opened page (PLP) click on the first product
    Then the correct page with correct url should be opened
    When the user picks any size and click on Add to Bag button
    Then one item should be added to the bag
    When user clicks on View Bag button and navigate to the cart page
    Then the cart page should be opened by the title "YOUR BAG"
    When user clicks on the Checkout button
    Then the delivery page should be opened
    When the user clicks on From A Collection Point from the Get Your Order module
    And type "London" in the location text box and click Search for Collection Points button
    And pick any collection point from the list
    Then the correct collection point is selected
    When the user proceeds to the payment step by Review and Pay Button
    Then the major payment methods “PayPal” and “Credit Card” are present



