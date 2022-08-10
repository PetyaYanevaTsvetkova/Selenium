@TablesPageTest
Feature: Add table to cart

  Background:
    Given Navigate to Table Page

  @AddTableToCart
  Scenario: Add table to cart
    Given The products from Table Page are shown in table view. Chose option to show them in list
    When Add Table to Cart
    Then Assert that the table is added successfully and the quantity is 1
    And  Increase the amount in the cart by one more
    And Assert that the price is as expected $398.00