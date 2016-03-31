Feature: Check OrdersService

# Test getAllOrders
  Scenario: getAllOrders returns list of orders
    Given mock OrdersService is initialized
    When getAllOrders() is called for OrdersService
    Then getAllOrders returns list of orders