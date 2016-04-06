Feature: Check AddressRepository

# Test updateAddress
  Scenario: updateAddress is called successfully
    Given mock AddressRepository is initialized
    When updateAddress() is called for AddressRepository
    Then updateAddress has been called successfully for AddressRepository

# Test getAddress
  Scenario: getAddress returns some addresses
    Given mock AddressRepository is initialized
    And expected list of addresses is initialized for AddressRepository
    When getAddress() is called for AddressRepository
    Then a list of addresses is returned for getAddress in AddressRepository
