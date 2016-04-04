Feature: Check SalesDelegate

  Scenario: addSale runs successfully
    Given SalesDelegate is set up
    When addSale is called
    Then addSale runs successfully
