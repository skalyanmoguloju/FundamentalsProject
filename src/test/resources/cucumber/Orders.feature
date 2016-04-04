Feature: Check Orders

  Scenario: getOrder_id returns order_id
    Given Orders is set up
    When order_id 1 is set
    Then getOrder_id returns order_id 1

  Scenario: getItems returns items
    Given Orders is set up
    When items is set
    Then getItems returns that items

  Scenario: getStatus returns status
    Given Orders is set up
    When status "teststatus" is set for Orders
    Then getStatus returns "teststatus" for Orders

  Scenario: getMaterialIndent returns materialIndent
    Given Orders is set up
    When materialindent is set for Orders
    Then getMaterialIndent returns that materialindent for Orders

  Scenario: getQuantity returns quantity
    Given Orders is set up
    When quantity 3 is set for Orders
    Then getQuantity returns quantity 3 for Orders