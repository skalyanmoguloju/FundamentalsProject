Feature: Check OrdersDelegate

  Scenario: getAllOrderss returns some ordersbean
    Given OrdersDelegate is set up
    When getAllOrderss is called
    Then getAllOrderss returns ordersBeans
