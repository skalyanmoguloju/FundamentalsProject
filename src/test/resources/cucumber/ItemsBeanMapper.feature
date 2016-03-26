Feature: Check ItemsBeanMapper

  #
  # Check mapItemBean()
  #
  Scenario: mapItemBean returns ItemBean
    Given an Items is initialized
    When mapItemBean is called for ItemsBeanMapper
    Then mapItemBean returns a ItemBean

  #
  # Check mapBeanToItems()
  #
  Scenario: mapBeanToItems returns Items
    Given an ItemsBean is initialized
    When mapBeanToItems is called for ItemsBeanMapper
    Then mapBeanToItems returns an Items

  #
  # Check mapItemBean(List)
  #
  Scenario: mapItemBean(List) returns list of ItemBeans
    Given a list of Items is initialized
    When mapItemBean(List) is called for ItemsBeanMapper
    Then mapItemBean(List) returns a list of ItemBeans