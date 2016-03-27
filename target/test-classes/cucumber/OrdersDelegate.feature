Feature: Check OrdersDelegate

# Test getAllOrderss
  Scenario: getAllOrderss returns some roles
    Given mock OrdersDelegate is initialized
    And expected orders are initialized for getAllOrderss
    When getAllOrderss() is called
    Then a list of orders is returned for getAllOrderss

  Scenario: getAllOrderss returns null
    Given mock OrdersDelegate is initialized
    And expected null orders are initialized for getAllOrderss
    When getAllOrderss() is called
    Then a list of orders is returned as null for getAllOrderss

  Scenario: getAllOrderss returns empty
    Given mock OrdersDelegate is initialized
    And expected empty orders are initialized for getAllOrderss
    When getAllOrderss() is called
    Then a list of orders is empty for getAllOrderss
