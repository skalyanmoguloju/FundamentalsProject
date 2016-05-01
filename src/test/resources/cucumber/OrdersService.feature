Feature: Check OrdersService

# Test getAllOrders
  Scenario: getAllOrders returns list of orders
    Given mock OrdersService is initialized
    When getAllOrders() is called for OrdersService
    Then getAllOrders returns list of orders

# Test getTotalSold
  Scenario: getTotalSold returns list of sold_counts
    Given mock OrdersService is initialized
    When getTotalSold() is called for OrdersService
    Then getTotalSold returns list of sold_counts

# Test getReceivedOrders
  Scenario: getReceivedOrders returns list of orders
    Given mock OrdersService is initialized
    When getReceivedOrders() is called for OrdersService
    Then getReceivedOrders returns list of orders

# Test getOrder
  Scenario: getOrder returns list of orders
    Given mock OrdersService is initialized
    When getOrder() is called for OrdersService
    Then getOrder returns list of orders

# Test udpateOrders
  Scenario: udpateOrders is called succesfully
    Given mock OrdersService is initialized
    When udpateOrders() is called for OrdersService
    Then udpateOrders is called successfully for OrdersService