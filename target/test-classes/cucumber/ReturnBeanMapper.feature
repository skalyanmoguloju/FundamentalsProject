Feature: Check ReturnBeanMapper

  #
  # Check mapReturnBean()
  #
  Scenario: mapReturnBean returns returnbean
    Given ReturnBeanMapper is initialized
    When mapReturnBean is called for ReturnBeanMapper
    Then mapReturnBean returns a returnbean

  #
  # Check mapBeanToReturn()
  #
  Scenario: mapBeanToReturn returns returns
    Given ReturnBeanMapper is initialized
    When mapBeanToReturn is called for ReturnBeanMapper
    Then mapBeanToReturn returns a returns

  #
  # Check mapReturnBean(List)
  #
  Scenario: mapReturnBean(List) returns list of returnbeans
    Given ReturnBeanMapper is initialized
    When mapReturnBeanList is called for ReturnBeanMapper
    Then mapReturnBean returns a list of returnbeans