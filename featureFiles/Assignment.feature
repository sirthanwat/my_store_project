#Author :Aarti
#Date : 7/26/2020
#Description : Accionlabs Assignments
@Assignment
Feature: Shopping product using My Store appliaction

  @Scenario1Assignment
  Scenario: Searching product
    Given Open the browser and launch the application
    When User is on Home page
    When User will search for the product
    And User validate the search result
    And Close the browser

  @Scenario2Assignment
  Scenario: searching and selecting product
    Given Open the browser and launch the application
    When User is on Home page
    When User will search for the product
    And User validate the search result
    Then User will add a product to cart
    And User validate the addition of the product is successful to the cart
    And Close the browser

  @Scenario3Assignment
  Scenario: Searching, selecting and validating product
    Given Open the browser and launch the application
    When User is on Home page
    When User will search for the product
    And User validate the search result
    Then User will add a product to cart
    And User validate the addition of the product is successful to the cart
    And User will scroll down to a product to a mouse over and click on More
    Then User validate the resulting page has correct information
    And User is validating increment and decrement of quantity, size
    Then User is adding product to Cart
    And Close the browser

  @Scenario4Assignment
  Scenario: Login user
    Given Open the browser and launch the application
    When User is on login page
    When User enter email id
    And User enter invalid password
    Then User should be not be logged in the application
    And Close the browser