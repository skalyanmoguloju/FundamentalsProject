Feature: Check ItemCart

  Scenario: nothing
    Given itemcart is set up
    When item is set
    Then getItem return item