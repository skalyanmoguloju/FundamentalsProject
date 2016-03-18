Feature: Check RolesRepository

# Test getAllRoles
  Scenario: getAllRoles returns some roles
    Given mock RolesRepository is initialized
    And expected roles are initialized
    When getAllRoles() is called
    Then a list of roles is returned

  Scenario: getAllRoles returns some roles
    Given mock RolesRepository is initialized
    And expected null roles are initialized
    When getAllRoles() is called
    Then a list of roles is returned as null

  Scenario: getAllRoles returns some roles
    Given mock RolesRepository is initialized
    And expected empty roles are initialized
    When getAllRoles() is called
    Then a list of roles is empty

# Test getAllRights
  Scenario: getAllRights returns some rights
    Given mock RolesRepository is initialized
    And expected rights are initialized
    When getAllRights() is called
    Then a list of rights is returned

  Scenario: getAllRights returns some rights
    Given mock RolesRepository is initialized
    And expected null rights are initialized
    When getAllRights() is called
    Then a list of rights is returned as null

  Scenario: getAllRights returns some rights
    Given mock RolesRepository is initialized
    And expected empty rights are initialized
    When getAllRights() is called
    Then a list of rights is empty