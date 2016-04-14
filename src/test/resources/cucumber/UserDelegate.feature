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

# Test getUserInfo
  Scenario: getUserInfo returns some users
    Given mock UserDelegate is initialized
    And expected users are initialized for getUserList
    When getUserInfo() is called for UserDelegate
    Then a list of users is returned for getUserInfo in UserDelegate

# Test validateEmail
  Scenario: validateEmail returns some ids
    Given mock UserDelegate is initialized
    And expected list of ids are initialized for validateEmail
    When validateEmail() is called for UserDelegate
    Then a list of ids is returned for validateEmail in UserDelegate

# Test addUser
  Scenario: addUser is called successfully
    Given mock UserDelegate is initialized
    When addUser() is called for UsersDelegate
    Then addUser has been called successfully

# Test verifyUser
  Scenario: verifyUser is called successfully
    Given mock UserDelegate is initialized
    When verifyUser() is called for UsersDelegate
    Then verifyUser has been called successfully

# Test resetPassword
  Scenario: resetPassword is called successfully
    Given mock UserDelegate is initialized
    When resetPassword() is called for UsersDelegate
    Then resetPassword has been called successfully

# Test getUserPasswordWithEmail
  Scenario: getUserPasswordWithEmail returns pswd
    Given mock UserDelegate is initialized
    And expected list of pswd is initialized for getUserPasswordWithEmail
    When getUserPasswordWithEmail() is called for UserDelegate
    Then a pswd is returned for getUserPasswordWithEmail in UserDelegate

  Scenario: getUserPasswordWithEmail returns pswd
    Given mock UserDelegate is initialized
    And expected empty list of pswd is initialized for getUserPasswordWithEmail
    When getUserPasswordWithEmail() is called for UserDelegate
    Then an empty pswd is returned for getUserPasswordWithEmail in UserDelegate

# Test addNewAdmin
  Scenario: addNewAdmin returns id
    Given mock UserDelegate is initialized
    And expected list of ids is initialized for addNewAdmin
    When addNewAdmin() is called for UserDelegate
    Then a list of ids is returned for addNewAdmin in UserDelegate

# Test getUserPasswordWithEmail
  Scenario: addNewManager returns id
    Given mock UserDelegate is initialized
    And expected list of ids is initialized for addNewManager
    When addNewManager() is called for UserDelegate
    Then a list of ids is returned for addNewManager in UserDelegate