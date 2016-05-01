Feature: Check Returns

  Scenario: getResolution returns res
    Given Returns is set up
    When res "Res" is set
    Then getResolution returns "Res"

  Scenario: getReturn_date returns date
    Given Returns is set up
    When date is set
    Then getReturn_date returns that date

  Scenario: getReturn_count returns count
    Given Returns is set up
    When count 3 is set
    Then getReturn_count returns 3

  Scenario: getReturn_id returns id
    Given Returns is set up
    When rid 1 is set
    Then getReturn_id returns 1

  Scenario: getDescription returns description
    Given Returns is set up
    When "des" is set
    Then getDescription returns "des"

  Scenario: getOrders returns orders
    Given Returns is set up
    When orders is set
    Then getOrders returns that orders

