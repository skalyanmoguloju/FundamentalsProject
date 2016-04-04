Feature: Check MaterialIndentDelegate

  Scenario: addSale runs successfully
    Given MaterialIndentDelegate is set up
    When addSale is called for MaterialIndentDelegate
    Then addSale runs successfully for MaterialIndentDelegate
