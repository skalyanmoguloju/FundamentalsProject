Feature: Check ItemCart

  Scenario: ItemCart returns some items
    Given mock ItemCart is initialized
    When itemcart is called
    Then a list of items is returned
