Feature: Check AddressDelegate

# Test updateAddress
  Scenario: updateAddress is called successfully
    Given mock AddressDelegate is initialized
    When updateAddress() is called for AddressDelegate
    Then updateAddress has been called successfully for AddressDelegate

# Test getAddress
  Scenario: getAddress returns some addressBeans
    Given mock AddressDelegate is initialized
    And expected list of addressBeans is initialized
    When getAddress() is called for AddressDelegate
    Then a list of addressBeans is returned for getAddress
