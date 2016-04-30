Feature: Check ReturnService

# Test returnRequest
  Scenario: returnRequest returns status
    Given mock ReturnService is initialized
    When returnRequest() is called
    Then returnRequest returns status

# Test getRecRetOrders
  Scenario: getRecRetOrders returns some returns
    Given mock ReturnService is initialized
    And list of returns is set up in ReturnService
    When getRecRetOrders() is called
    Then getRecRetOrders returns some returns

# Test getRetOrders
  Scenario: getRetOrders returns some returns
    Given mock ReturnService is initialized
    And list of returns is set up in ReturnService
    When getRetOrders() is called
    Then getRetOrders returns some returns

