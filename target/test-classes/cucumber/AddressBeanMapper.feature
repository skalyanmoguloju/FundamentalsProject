Feature: Check AddressBeanMapper

  #
  # Check mapItemBean()
  #
  Scenario: mapItemBean returns addressbean
    Given expected address is initialized for AddressBeanMapper
    When mapItemBean is called for AddressBeanMapper
    Then mapItemBean returns a addressBean

  #
  # Check mapBeanToAddress()
  #
  Scenario: mapBeanToAddress returns address
    Given expected addressbean is initialized for AddressBeanMapper
    When mapBeanToAddress is called
    Then mapBeanToAddress returns an address

  #
  # Check mapItemsBean()
  #
  Scenario: mapItemsBeanList returns some addressBeans
    Given expected list of addresses is initialized for AddressBeanMapper
    When mapItemsBeanList is called for AddressBeanMapper
    Then mapItemsBeanList returns some addressBeans