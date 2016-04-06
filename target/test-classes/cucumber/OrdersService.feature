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