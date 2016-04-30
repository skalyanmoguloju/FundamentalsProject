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

# Test getAllCatgs
  Scenario: getAllCatgs returns some items
    Given mock ItemsDelegate is initialized
    And expected list of items is initialized for getAllCatgs
    When getAllCatgs() is called for ItemsDelegate
    Then a list of items is returned for getAllCatgs

# Test addItem
  Scenario: addItem is called successfully
    Given mock ItemsDelegate is initialized
    When addItem() is called for ItemsDelegate
    Then addItem has been called successfully

# Test getAllItemsContainingSearchTerm
  Scenario: getAllItemsContainingSearchTerm returns some itembeans
    Given mock ItemsDelegate is initialized
    And expected list of itembeans is initialized
    When getAllItemsContainingSearchTerm() is called for ItemsDelegate
    Then a list of itembeans is returned for getAllItemsContainingSearchTerm

# Test getAllCatItemsContainingSearchTerm
  Scenario: getAllCatItemsContainingSearchTerm returns some itembeans
    Given mock ItemsDelegate is initialized
    And expected list of itembeans is initialized
    When getAllCatItemsContainingSearchTerm() is called for ItemsDelegate
    Then a list of itembeans is returned for getAllCatItemsContainingSearchTerm

# Test updateSoldCount
  Scenario: updateSoldCount returns soldcount
    Given mock ItemsDelegate is initialized
    And expected soldcount is initialized
    When updateSoldCount() is called for ItemsDelegate
    Then soldcount is returned for updateSoldCount