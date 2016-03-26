Feature: Check ItemsDelegate

# Test getAllItems
  Scenario: getAllItems returns some itembeans
    Given mock ItemsDelegate is initialized
    And expected list of itembeans is initialized
    When getAllItems() is called for ItemsDelegate
    Then a list of itembeans is returned for getAllItems

  Scenario: getAllItems returns null
    Given mock ItemsDelegate is initialized
    And expected null list of itembeans is initialized
    When getAllItems() is called for ItemsDelegate
    Then a list of itembeans is null for getAllItems

  Scenario: getAllItems returns empty
    Given mock ItemsDelegate is initialized
    And expected empty list of itembeans is initialized
    When getAllItems() is called for ItemsDelegate
    Then a list of itembeans is empty for getAllItems

# Test addItem
  Scenario: addItem is called successfully
    Given mock ItemsDelegate is initialized
    When addItem() is called for ItemsDelegate
    Then addItem has been called successfully