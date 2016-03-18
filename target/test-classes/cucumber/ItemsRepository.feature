Feature: Check ItemsRepository

# Test getAllItems
  Scenario: getAllItems returns some items
    Given mock ItemsRepository is initialized
    And expected list of items is initialized
    When getAllItems() is called
    Then a list of items is returned for getAllItems

  Scenario: getAllItems returns null
    Given mock ItemsRepository is initialized
    And expected null list of items is initialized
    When getAllItems() is called
    Then a list of items is null for getAllItems

  Scenario: getAllItems returns empty
    Given mock ItemsRepository is initialized
    And expected empty list of items is initialized
    When getAllItems() is called
    Then a list of items is empty for getAllItems

# Test addItem
  Scenario: addItem returns some ids
    Given mock ItemsRepository is initialized
    And expected list of ids is initialized
    When addItem() is called
    Then a list of ids is returned for addItem

  Scenario: addItem returns null
    Given mock ItemsRepository is initialized
    And expected null list of ids is initialized
    When addItem() is called
    Then a list of ids is null for addItem

  Scenario: addItem returns empty
    Given mock ItemsRepository is initialized
    And expected empty list of ids is initialized
    When addItem() throws exception
    Then a list of ids is empty for addItem