Feature: Check UserService

# Test getAllUsers
  Scenario: getAllUsers returns some users
    Given mock UserService is initialized
    And expected list of users is initialized
    When getAllUsers() is called
    Then a list of users is returned for getAllUsers

  Scenario: getAllUsers returns null
    Given mock UserService is initialized
    And expected null list of users is initialized
    When getAllUsers() is called
    Then a list of users is null for getAllUsers

  Scenario: getAllUsers returns empty list
    Given mock UserService is initialized
    And expected empty list of users is initialized
    When getAllUsers() is called
    Then a list of users is empty for getAllUsers

# Test getUserInfo
  Scenario: getUserInfo returns some users
    Given mock UserService is initialized
    And expected list of users is initialized
    When getUserInfo() is called
    Then a list of users is returned for getUserInfo

  Scenario: getUserInfo returns null
    Given mock UserService is initialized
    And expected null list of users is initialized
    When getUserInfo() is called
    Then a list of users is null for getUserInfo

  Scenario: getUserInfo returns empty list
    Given mock UserService is initialized
    And expected empty list of users is initialized
    When getUserInfo() is called
    Then a list of users is empty for getUserInfo

# Test validateEmail
  Scenario: validateEmail returns some ids
    Given mock UserService is initialized
    And expected list of ids is initialized
    When validateEmail() is called
    Then a list of ids is returned for validateEmail

  Scenario: validateEmail returns null
    Given mock UserService is initialized
    And expected null list of ids is initialized
    When validateEmail() is called
    Then a list of ids is null for validateEmail

  Scenario: validateEmail returns empty list
    Given mock UserService is initialized
    And expected empty list of ids is initialized
    When validateEmail() is called
    Then a list of ids is empty for validateEmail

# Test addUser
  Scenario: addUser returns some ids
    Given mock UserService is initialized
    And expected list of ids is initialized
    When addUser() is called
    Then a list of ids is returned for addUser

  Scenario: addUser returns null
    Given mock UserService is initialized
    And expected null list of ids is initialized
    When addUser() is called
    Then a list of ids is null for addUser

  Scenario: addUser returns empty list
    Given mock UserService is initialized
    And expected empty list of ids is initialized
    When addUser() is called
    Then a list of ids is empty for addUser

# Test verifyUser
  Scenario: verifyUser is called successfully
    Given mock UserService is initialized
    When verifyUser() is called
    Then verifyUser is successfully called

# Test resetPswd
  Scenario: resetPswd is called successfully
    Given mock UserService is initialized
    When resetPswd() is called
    Then resetPswd is successfully called

# Test getUserInfoWithEmail
  Scenario: getUserInfoWithEmail returns some passwords
    Given mock UserService is initialized
    And expected list of passwords is initialized
    When getUserInfoWithEmail() is called
    Then a list of passwords is returned for getUserInfoWithEmail

  Scenario: getUserInfoWithEmail returns null
    Given mock UserService is initialized
    And expected null list of passwords is initialized
    When getUserInfoWithEmail() is called
    Then a list of passwords is null for getUserInfoWithEmail

  Scenario: addUser returns empty list
    Given mock UserService is initialized
    And expected empty list of passwords is initialized
    When getUserInfoWithEmail() is called
    Then a list of passwords is empty for getUserInfoWithEmail

# Test addNewAdmin
  Scenario: addNewAdmin returns some ids
    Given mock UserService is initialized
    And expected list of ids is initialized
    When addNewAdmin() is called
    Then a list of ids is returned for addNewAdmin

  Scenario: addNewAdmin returns null
    Given mock UserService is initialized
    And expected null list of ids is initialized
    When addNewAdmin() is called
    Then a list of ids is null for addNewAdmin

  Scenario: addNewAdmin returns empty list
    Given mock UserService is initialized
    And expected empty list of ids is initialized
    When addNewAdmin() is called
    Then a list of ids is empty for addNewAdmin

# Test addNewManager
  Scenario: addNewManager returns some ids
    Given mock UserService is initialized
    And expected list of ids is initialized
    When addNewManager() is called
    Then a list of ids is returned for addNewManager

  Scenario: addNewManager returns null
    Given mock UserService is initialized
    And expected null list of ids is initialized
    When addNewManager() is called
    Then a list of ids is null for addNewManager

  Scenario: addNewManager returns empty list
    Given mock UserService is initialized
    And expected empty list of ids is initialized
    When addNewManager() is called
    Then a list of ids is empty for addNewManager