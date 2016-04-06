Feature: Check CartService

# Test updateCart
  Scenario: updateCart is called successfully
    Given mock CartService is initialized
    When updateCart() is called
    Then updateCart has been called successfully called

# Test getCart
  Scenario: getCart returns some carts
    Given mock CartService is initialized
    And expected list of carts is initialized
    When getCart() is called
    Then a list of carts is returned for getCart

  Scenario: getCart returns null
    Given mock CartService is initialized
    And expected null list of carts is initialized
    When getCart() is called
    Then a list of carts is null for getCart

  Scenario: getCart returns empty
    Given mock CartService is initialized
    And expected empty list of carts is initialized
    When getCart() is called
    Then a list of carts is empty for getCart

# Test AddToCart
  Scenario: AddToCart is called successfully
    Given mock CartService is initialized
    When AddToCart() is called
    Then AddToCart has been called successfully called
