Feature: Check MaterialIndentService

# Test addSale
  Scenario: addSale runs successfully
    Given mock MaterialIndentService is initialized
    When addSale() is called for MaterialIndentService
    Then addSale has been called successfully