Feature: Check OrdersBeanMapper

  #
  # Check mapOrdersBean()
  #
  Scenario: mapOrdersBean returns ordersBean
    Given OrdersBeanMapper is initialized
    When mapOrdersBean is called for OrdersBeanMapper
    Then mapOrdersBean returns a materialIndentBean

  #
  # Check mapBeanToOrders()
  #
  Scenario: mapBeanToOrders returns orders
    Given OrdersBeanMapper is initialized
    When mapBeanToOrders is called for OrdersBeanMapper
    Then mapBeanToOrders returns an orders

  #
  # Check mapOrdersBean(List)
  #
  Scenario: mapOrdersBean(List) returns list of ordersBeans
    Given OrdersBeanMapper is initialized
    When mapOrdersBeanList is called for OrdersBeanMapper
    Then mapOrdersBean returns a list of ordersBeans