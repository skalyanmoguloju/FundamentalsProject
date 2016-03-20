Feature: Check Cart

  Scenario: getCart_id returns cart_id
    Given Cart is set up
    When cart_id 1 is set
    Then getCart_id returns cart_id 1

  Scenario: getUser_id returns user_id
    Given Cart is set up
    When userid 1 is set
    Then getUser_id returns user_id 1

  Scenario: getQuantity returns quantity
    Given Cart is set up
    When Quantity 5 is set
    Then getQuantity returns quantity 5

  Scenario: getPrice returns price
    Given Cart is set up
    When Price 5 is set
    Then getPrice returns Price 5

  Scenario: getItems returns item
    Given Cart is set up
    When an item is set
    Then getItems returns that item