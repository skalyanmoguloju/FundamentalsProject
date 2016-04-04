Feature: Check MaterialIndentMapper

  #
  # Check mapItemBean()
  #
  Scenario: mapItemBean returns materialIndentBean
    Given MaterialIndentMapper is initialized
    When mapItemBean is called for MaterialIndentMapper
    Then mapItemBean returns a materialIndentBean

  #
  # Check mapBeanToMaterialIndent()
  #
  Scenario: mapBeanToMaterialIndent returns MaterialIndent
    Given MaterialIndentMapper is initialized
    When mapBeanToMaterialIndent is called for MaterialIndentMapper
    Then mapBeanToMaterialIndent returns a MaterialIndent

  #
  # Check mapItemBean(List)
  #
  Scenario: mapItemBean(List) returns list of materialIndentBean
    Given MaterialIndentMapper is initialized
    When mapItemBeanList is called for MaterialIndentMapper
    Then mapItemBeanList returns a list of materialIndentBeans