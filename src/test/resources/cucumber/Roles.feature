Feature: Check Roles

  Scenario: getRole returns role
    Given Roles is set up
    When roles "Admin" is set
    Then getRole returns role "Admin"

  Scenario: getRights returns right
    Given Roles is set up
    When right "No Right" is set
    Then gerRights returns right "No Right"
