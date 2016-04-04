Feature: Check MaterialIndentRepository

# Test AddSale
  Scenario: AddSale runs successfully
    Given mock MaterialIndentRepository is initialized
    When AddSale() is called
    Then it has been called successfully

  Scenario: AddSale runs successfully
    Given mock MaterialIndentRepository is initialized
    When AddSale() throws exception
    Then it has been called successfully