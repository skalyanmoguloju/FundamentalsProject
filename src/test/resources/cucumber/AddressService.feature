Feature: Check AddressService

# Test updateAddress
  Scenario: updateAddress is called successfully
    Given mock AddressService is initialized
    When updateAddress() is called
    Then updateAddress has been called successfully called

# Test getAddress
  Scenario: getCart returns some addresses
    Given mock AddressService is initialized
    And expected list of addresses is initialized
    When getAddress() is called
    Then a list of addresses is returned for getAddress

# Test addAddress
  Scenario: addAddress returns some ids
    Given mock AddressService is initialized
    And expected list of ids is initialized for addAddress
    When addAddress() is called
    Then a list of ids is returned for addAddress
