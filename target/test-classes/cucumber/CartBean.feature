Feature: Check CartBean
  # Test setItemsBean
  Scenario: setItemsBean sets ItemsBean
    Given mock CartBean is initialized
    When setItemsBean() is called
    Then setItemsBean() is successfully called

  # Test getCart_id and setCart_id
  Scenario: getCart_id returns correct cart_id
    Given mock CartBean is initialized
    When getCart_id() is called
    Then a cart id is returned

  Scenario: setCart_id sets cart_id
    Given mock CartBean is initialized
    When setCart_id() is called
    Then setCart_id() is successfully called

  # Test getUser_id and setUser_id
  Scenario: getUser_id returns correct user_id
    Given mock CartBean is initialized
    When getUser_id() for cart bean is called
    Then a cart bean user id is returned

  Scenario: setUser_id sets user_id
    Given mock CartBean is initialized
    When setUser_id() for cart bean is called
    Then setUser_id() for cart bean is successfully called

  # Test getQuantity and setQuantity
  Scenario: getQuantity returns correct quantity
    Given mock CartBean is initialized
    When getQuantity() is called
    Then a quantity string is returned

  Scenario: setQuantity sets quantity
    Given mock CartBean is initialized
    When setQuantity() is called
    Then setQuantity() is successfully called

  # Test getPrice and setPrice
  Scenario: getPrice returns correct price
    Given mock CartBean is initialized
    When getPrice() for cart bean is called
    Then a price for cart bean is returned

  Scenario: setPrice sets price
    Given mock CartBean is initialized
    When setPrice() for cart bean is called
    Then setPrice() for cart bean is successfully called
