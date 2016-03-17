Feature: Check ItemsService

# Test getAllItems
  Scenario: getAllItems returns some items
    Given mock ItemsService is initialized
    And expected list of items is initialized
    When getAllItems() is called
    Then a list of items is returned for getAllItems

  Scenario: getAllItems returns null
    Given mock ItemsService is initialized
    And expected null list of items is initialized
    When getAllItems() is called
    Then a list of items is null for getAllItems

  Scenario: getAllItems returns empty
    Given mock ItemsService is initialized
    And expected empty list of items is initialized
    When getAllItems() is called
    Then a list of items is empty for getAllItems

# Test addItem
  Scenario: addItem is called successfully
    Given mock ItemsService is initialized
    When addItem() is called
    Then addItem has been called successfully called

