Feature: Check SalesRepository

# Test addSale
  Scenario: addSale is called successfully
    Given mock SalesRepository is initialized
    When addSale() is called
    Then addSale has been called successfully called

  Scenario: addSale throws exception
    Given mock SalesRepository is initialized
    When addSale() is called incorrectly
    Then addSale throws exception