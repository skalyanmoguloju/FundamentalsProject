Feature: Check OrdersRepository

# Test getAllOrders
  Scenario: getAllOrders returns list of orders
    Given mock OrdersRepository is initialized
    When getAllOrders() is called
    Then getAllOrders returns a list of orders