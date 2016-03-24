Feature: Check RolesDelegate

# Test getRolesList
  Scenario: getRolesList returns some roles
    Given mock RolesDelegate is initialized
    And expected roles are initialized for getRolesList
    When getRolesList() is called
    Then a list of roles is returned for getRolesList

  Scenario: getRolesList returns null
    Given mock RolesDelegate is initialized
    And expected null roles are initialized for getRolesList
    When getRolesList() is called
    Then a list of roles is returned as null for getRolesList

  Scenario: getRolesList returns empty
    Given mock RolesDelegate is initialized
    And expected empty roles are initialized for getRolesList
    When getRolesList() is called
    Then a list of roles is empty for getRolesList

# Test getRights
  Scenario: getRights returns some rights
    Given mock RolesDelegate is initialized
    And expected list of rights is initialized for getRights
    When getRights() is called for RolesRepository
    Then a list of rights is returned for getRights

  Scenario: getRights returns null
    Given mock RolesDelegate is initialized
    And expected null list of rights is initialized for getRights
    When getRights() is called for RolesRepository
    Then a list of rights is returned as null for getRights

  Scenario: getRights returns empty
    Given mock RolesDelegate is initialized
    And expected empty list of rights is initialized for getRights
    When getRights() is called for RolesRepository
    Then a list of rights is empty for getRights