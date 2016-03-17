Feature: Check SalesService

# Test getAllUsers
  Scenario: addSale is called successfully
    Given mock SalesService is initialized
    When addSale() is called
    Then addSale has been called successfully called

