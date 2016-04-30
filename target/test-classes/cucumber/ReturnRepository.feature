Feature: Check ReturnRepository

  Scenario: updateSaleCount is called successfully
    Given ReturnRepository is set up
    When updateSaleCount is called
    Then updateSaleCount is called sucessfully

  Scenario: AddNewOrder is called successfully
    Given ReturnRepository is set up
    When AddNewOrder is called
    Then AddNewOrder is called sucessfully

  Scenario: returnRequest is called successfully
    Given ReturnRepository is set up
    When returnRequest is called
    Then returnRequest is called sucessfully

  Scenario: AddReturn is called successfully
    Given ReturnRepository is set up
    When AddReturn is called
    Then AddReturn is called sucessfully

  Scenario: getAllOrders returns some returns
    Given ReturnRepository is set up
    And list of returns is set up
    When getAllOrders is called for ReturnRepository
    Then list of returns is returned for getAllOrders

  Scenario: getRetOrders returns some returns
    Given ReturnRepository is set up
    And list of returns is set up
    When getRetOrders is called for ReturnRepository
    Then list of returns is returned for getRetOrders

  Scenario: getRecRetOrders returns some returns
    Given ReturnRepository is set up
    And list of returns is set up
    When getRecRetOrders is called for ReturnRepository
    Then list of returns is returned for getRecRetOrders