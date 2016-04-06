Feature: Check CartRepository

# Test updateCart
  Scenario: updateCart is called successfully
    Given mock CartRepository is initialized
    When updateCart() is called
    Then updateCart has been called successfully called

  Scenario: updateCart throws exception
    Given mock CartRepository is initialized
    When updateCart() is called
    Then updateCart throws exception

# Test getCart
  Scenario: getCart returns some carts
    Given mock CartRepository is initialized
    And expected list of carts is initialized
    When getCart() is called
    Then a list of carts is returned for getCart

  Scenario: getCart returns null
    Given mock CartRepository is initialized
    And expected null list of carts is initialized
    When getCart() is called
    Then a list of carts is null for getCart

  Scenario: getCart returns empty
    Given mock CartRepository is initialized
    And expected empty list of carts is initialized
    When getCart() is called
    Then a list of carts is empty for getCart

# Test ClearCart
  Scenario: ClearCart is called successfully
    Given mock CartRepository is initialized
    When ClearCart() is called
    Then ClearCart has been called successfully called

# Test AddToCart
  Scenario: ClearCart is called successfully
    Given mock CartRepository is initialized
    When AddToCart() is called for CartRepository
    Then AddToCart has been called successfully called for CartRepository
