Feature: Check CartBeanMapper

  #
  # Check mapItemBean()
  #
  Scenario: mapItemBean returns cartbean
    Given expected cart is initialized for CartBeanMapper
    When mapItemBean is called
    Then mapItemBean returns a cartbean

  #
  # Check mapBeanToCart()
  #
  Scenario: mapBeanToCart returns cart
    Given expected cartbean is initialized for CartBeanMapper
    When mapBeanToCart is called
    Then mapBeanToCart returns a cart

  #
  # Check mapItemsBean()
  #
  Scenario: mapItemsBeanList returns some cartbeans
    Given expected list of cartbeans is initialized for CartBeanMapper
    When mapItemsBeanList is called
    Then mapItemsBeanList returns some cartbeans