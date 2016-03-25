Feature: Check CartBeanMapper

  #
  # Check mapItemBean()
  #
  Scenario: mapItemBean returns cartbean
    Given mock CartBeanMapper is initialized
    And expected cartBean is initialized
    When mapItemBean is called
    Then mapItemBean returns a cartbean

  #
  # Check mapBeanToCart()
  #
  Scenario: mapBeanToCart returns cart
    Given mock CartBeanMapper is initialized
    When expected cart is initialized
    Then mapBeanToCart returns a cart

  Scenario: mapBeanToCart returns empty
    Given mock CartBeanMapper is initialized
    When expected empty cart is initialized
    Then mapBeanToCart returns empty

  #
  # Check mapItemsBean()
  #
  Scenario: mapItemsBean returns some cartbeans
    Given mock CartBeanMapper is initialized
    When expected list of cartbeans is initialized for mapItemsBean
    Then mapItemsBean returns some cartbeans