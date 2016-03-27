Feature: Check UserDelegate

# Test getUsersList
  Scenario: getUserList returns some users
    Given mock UserDelegate is initialized
    And expected users are initialized for getUserList
    When getUsersList() is called
    Then a list of users is returned for getUserList

  Scenario: getUsersList returns null
    Given mock UserDelegate is initialized
    And expected null users are initialized for getUsersList
    When getUsersList() is called
    Then a list of users is returned as null for getUsersList

  Scenario: getUsersList returns empty
    Given mock UserDelegate is initialized
    And expected empty users are initialized for getUsersList
    When getUsersList() is called
    Then a list of users is empty for getUsersList

# Test addUser
  Scenario: addUser is called successfully
    Given mock UserDelegate is initialized
    When addUser() is called for UsersDelegate
    Then addUser has been called successfully

