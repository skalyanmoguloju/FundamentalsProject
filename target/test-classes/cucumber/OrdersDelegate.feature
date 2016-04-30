Feature: Check OrdersDelegate

  Scenario: getAllOrderss returns some ordersbean
    Given OrdersDelegate is set up
    When getAllOrderss is called
    Then getAllOrderss returns ordersBeans

  Scenario: getOrders returns some ordersbean
    Given OrdersDelegate is set up
    When getOrders is called
    Then getOrders returns ordersBeans

  Scenario: getReceivedORders returns some ordersbean
    Given OrdersDelegate is set up
    When getReceivedORders is called
    Then getReceivedORders returns ordersBeans

  Scenario: udpateOrders is called successfully
    Given OrdersDelegate is set up
    When udpateOrders is called
    Then udpateOrders is called successfully

  Scenario: getTotalSold returns totalsold
    Given OrdersDelegate is set up
    When getTotalSold is called
    Then getTotalSold returns totalsold
