Feature: Check RolesBean
  # Test getRole and setRole
  Scenario: getRole returns correct role
    Given mock RolesBean is initialized
    When getRole() is called
    Then a role is returned

  Scenario: setRole sets role
    Given mock RolesBean is initialized
    When setRole() for RolesBean is called
    Then setRole() for RolesBean is successfully called

  # Test getRights and setRights
  Scenario: getRights returns correct rights
    Given mock RolesBean is initialized
    When getRights() is called
    Then rights are returned

  Scenario: setRights sets rights
    Given mock RolesBean is initialized
    When setRights() is called
    Then setRights() is successfully called
