Feature: Check ReturnDelegate

  Scenario: returnRequest returns some returns
    Given ReturnDelegate is set up
    When returnRequest is called
    Then returnRequest returns some returns

  Scenario: getRecRetOrders returns some returnbeans
    Given ReturnDelegate is set up
    When getRecRetOrders is called
    Then getRecRetOrders returns some returnbeans

  Scenario: getRetOrders returns some returnbeans
    Given ReturnDelegate is set up
    When getRetOrders is called
    Then getRetOrders returns some returnbeans