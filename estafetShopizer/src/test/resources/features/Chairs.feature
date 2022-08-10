@ChairsPageTest
Feature: Test the Chairs page

  Background:
    Given Navigate to Chairs Page

    Scenario: Add chair to cart
      Given The products from Chairs Page are shown in table view. Chose option to show them in list
      When Add Chair to Cart
      Then Assert that the chair is added successfully and the quantity is 1
      And  Increase the amount of chairs in the cart by one more
      And Assert that the price of chairs is as expected $198.00
