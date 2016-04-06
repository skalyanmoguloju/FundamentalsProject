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

# Test getAllItemsContainingSearchTerm
  Scenario: getAllItemsContainingSearchTerm returns some items
    Given mock ItemsService is initialized
    And expected list of items is initialized
    When getAllItemsContainingSearchTerm() is called
    Then a list of items is returned for getAllItemsContainingSearchTerm in getAllItems

# Test addItem
  Scenario: addItem is called successfully
    Given mock ItemsService is initialized
    When addItem() is called
    Then addItem has been called successfully called

# Test updateSoldCount
  Scenario: updateSoldCount returns list of sold_counts
    Given mock ItemsService is initialized
    And expected list of sold_counts is initialized
    When updateSoldCount() is called
    Then a list of sold_counts is returned for getAllItems
