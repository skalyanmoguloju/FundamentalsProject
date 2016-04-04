Feature: Check UserBeanMapper

  #
  # Check mapUserBean()
  #
  Scenario: mapUserBean returns userBean
    Given UserBeanMapper is initialized
    When mapUserBean is called for UserBeanMapper
    Then mapUserBean returns a userBean

  #
  # Check mapBeanToUser()
  #
  Scenario: mapBeanToUser returns user
    Given UserBeanMapper is initialized
    When mapBeanToUser is called for UserBeanMapper
    Then mapBeanToUser returns an user

  #
  # Check mapUserBean(List)
  #
  Scenario: mapUserBean(List) returns list of userBeans
    Given UserBeanMapper is initialized
    When mapUserBeanList is called for UserBeanMapper
    Then mapUserBeanList returns a list of userBeans