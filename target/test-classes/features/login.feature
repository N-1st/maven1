@CartTest
Feature: Add to Cart
Scenario: User adds a product to the cart.
Given User is saucedemo page
When User enters "standard_user" and "secret_sauce" and clicklogin
Then verify the product is added to the cart
