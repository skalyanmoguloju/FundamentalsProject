Feature: Check RolesBeanMapper

  #
  # Check mapRolesBean()
  #
  Scenario: mapRolesBean returns rolesBean
    Given RolesBeanMapper is initialized
    When mapRolesBean is called for RolesBeanMapper
    Then mapRolesBean returns a rolesBean

  #
  # Check mapBeanToRoles()
  #
  Scenario: mapBeanToRoles returns roles
    Given RolesBeanMapper is initialized
    When mapBeanToRoles is called for RolesBeanMapper
    Then mapBeanToRoles returns a roles

  #
  # Check mapRolesBean(List)
  #
  Scenario: mapRolesBean(List) returns list of rolesBean
    Given RolesBeanMapper is initialized
    When mapRolesBeanList is called for RolesBeanMapper
    Then mapBeanToRolesList returns a list of rolesBean