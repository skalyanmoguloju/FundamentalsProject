Feature: Check UserRepository

# Test finAllUsers
  Scenario: finAllUsers returns some users
    Given mock UserRepository is initialized
    And expected list of users is initialized
    When finAllUsers() is called
    Then a list of users is returned for finAllUsers

  Scenario: finAllUsers returns null
    Given mock UserRepository is initialized
    And expected null list of users is initialized
    When finAllUsers() is called
    Then a list of users is null for finAllUsers

  Scenario: finAllUsers returns empty list
    Given mock UserRepository is initialized
    And expected empty list of users is initialized
    When finAllUsers() is called
    Then a list of users is empty for finAllUsers

# Test getUserInfo
  Scenario: getUserInfo returns some users
    Given mock UserRepository is initialized
    And expected list of users is initialized
    When getUserInfo() is called
    Then a list of users is returned for getUserInfo

  Scenario: getUserInfo returns null
    Given mock UserRepository is initialized
    And expected null list of users is initialized
    When getUserInfo() is called
    Then a list of users is null for getUserInfo

  Scenario: getUserInfo returns empty list
    Given mock UserRepository is initialized
    And expected empty list of users is initialized
    When getUserInfo() is called
    Then a list of users is empty for getUserInfo

# Test validateEmail
  Scenario: validateEmail returns some ids
    Given mock UserRepository is initialized
    And expected list of ids is initialized for UserRepository
    When validateEmail() is called
    Then a list of ids is returned for validateEmail

  Scenario: validateEmail returns null
    Given mock UserRepository is initialized
    And expected null list of ids is initialized for UserRepository
    When validateEmail() is called
    Then a list of ids is null for validateEmail

  Scenario: validateEmail returns empty list
    Given mock UserRepository is initialized
    And expected empty list of ids is initialized for UserRepository
    When validateEmail() is called
    Then a list of ids is empty for validateEmail

# Test addUser
  Scenario: addUser returns some ids for user role
    Given mock UserRepository is initialized
    And expected list of ids is initialized for UserRepository
    When addUser() is called with user role
    Then a list of ids is returned for addUser

  Scenario: addUser returns some ids for NOT user role
    Given mock UserRepository is initialized
    And expected list of ids is initialized for UserRepository
    When addUser() is called with not user role
    Then a list of ids is returned with 1 id for addUser

  Scenario: addUser throws Exception
    Given mock UserRepository is initialized
    And expected empty list of ids is initialized for UserRepository
    When addUser() is called with Exception
    Then a list of ids is empty for addUser

# Test verifyUser
  Scenario: verifyUser is called successfully
    Given mock UserRepository is initialized
    When verifyUser() is called
    Then verifyUser is successfully called

# Test resetPswd
  Scenario: resetPswd is called successfully
    Given mock UserRepository is initialized
    When resetPswd() is called
    Then resetPswd is successfully called

# Test getPswdInfoWithEmail
  Scenario: getPswdInfoWithEmail returns some passwords
    Given mock UserRepository is initialized
    And expected list of passwords is initialized
    When getPswdInfoWithEmail() is called
    Then a list of passwords is returned for getPswdInfoWithEmail

  Scenario: getPswdInfoWithEmail returns null
    Given mock UserRepository is initialized
    And expected null list of passwords is initialized
    When getPswdInfoWithEmail() is called
    Then a list of passwords is null for getPswdInfoWithEmail

  Scenario: getPswdInfoWithEmail returns empty list
    Given mock UserRepository is initialized
    And expected empty list of passwords is initialized
    When getPswdInfoWithEmail() is called
    Then a list of passwords is empty for getPswdInfoWithEmail

# Test addNewAdmin
  Scenario: addNewAdmin returns some ids
    Given mock UserRepository is initialized
    And expected list of ids is initialized for UserRepository
    When addNewAdmin() is called for UserRepository
    Then a list of ids is returned for addNewAdmin

  Scenario: addNewAdmin throws Exception
    Given mock UserRepository is initialized
    And expected empty list of ids is initialized for UserRepository
    When addNewAdmin() is called with Exception for UserRepository
    Then a list of ids is empty for UserRepository

# Test addNewManager
  Scenario: addNewManager returns some ids
    Given mock UserRepository is initialized
    And expected list of ids is initialized for UserRepository
    When addNewManager() is called for UserRepository
    Then a list of ids is returned for addNewManager in UserRepository

  Scenario: addNewManager throws Exception
    Given mock UserRepository is initialized
    And expected empty list of ids is initialized for UserRepository
    When addNewManager() is called with Exception for UserRepository
    Then a list of ids is empty for addNewManager in UserRepository

# Test getAllManagers
  Scenario: getAllManagers returns some users
    Given mock UserRepository is initialized
    And expected list of users is initialized
    When getAllManagers() is called
    Then a list of users is returned for getAllManagers

# Test getAllNewManagers
  Scenario: getAllNewManagers returns some users
    Given mock UserRepository is initialized
    And expected list of users is initialized
    When getAllNewManagers() is called
    Then a list of users is returned for getAllNewManagers

# Test promoteManager
  Scenario: promoteManager is called successfully
    Given mock UserRepository is initialized
    When promoteManager() is called
    Then promoteManager is successfully called

# Test approveManager
  Scenario: approveManager is called successfully
    Given mock UserRepository is initialized
    When approveManager() is called
    Then approveManager is successfully called

# Test declineManager
  Scenario: declineManager is called successfully
    Given mock UserRepository is initialized
    When declineManager() is called
    Then declineManager is successfully called

# Test updateOtherInfo
  Scenario: updateOtherInfo is called successfully
    Given mock UserRepository is initialized
    When updateOtherInfo() is called
    Then updateOtherInfo is successfully called