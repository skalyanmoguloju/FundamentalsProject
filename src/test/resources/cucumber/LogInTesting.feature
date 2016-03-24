Feature: Check Login Page

  Scenario: Correct Login Page
    Given I have a browser opened for LogInTesting
    When I navigate to login page for LogInTesting
    Then I should be in the login page for LogInTesting
    And browser is closed for LogInTesting
  #
  # Check email
  #
  Scenario: Empty Email
    Given I have a browser opened for LogInTesting
    When I navigate to login page for LogInTesting
    And I click submit for LogInTesting
    Then I should receive an please-enter email message
    And browser is closed for LogInTesting

  Scenario: Non-Empty Email (Wrong Format 1)
    Given I have a browser opened for LogInTesting
    When I navigate to login page for LogInTesting
    And I enter "wrong" in email field for LogInTesting
    And I click submit for LogInTesting
    Then I should receive an please-enter email message
    And browser is closed for LogInTesting

  Scenario: Non-Empty Email (Wrong Format 2)
    Given I have a browser opened for LogInTesting
    When I navigate to login page for LogInTesting
    And I enter "wrong." in email field for LogInTesting
    And I click submit for LogInTesting
    Then I should receive an please-enter email message
    And browser is closed for LogInTesting

  Scenario: Non-Empty Email (Wrong Format 3)
    Given I have a browser opened for LogInTesting
    When I navigate to login page for LogInTesting
    And I enter "wrong.@" in email field for LogInTesting
    And I click submit for LogInTesting
    Then I should receive an please-enter email message
    And browser is closed for LogInTesting

  Scenario: Non-Empty Email (Wrong Format 4)
    Given I have a browser opened for LogInTesting
    When I navigate to login page for LogInTesting
    And I enter "wrong@." in email field for LogInTesting
    And I click submit for LogInTesting
    Then I should receive an please-enter email message
    And browser is closed for LogInTesting

  Scenario: Non-Empty Email (Wrong Format 5)
    Given I have a browser opened for LogInTesting
    When I navigate to login page for LogInTesting
    And I enter "wrong@.co" in email field for LogInTesting
    And I click submit for LogInTesting
    Then I should receive an please-enter email message
    And browser is closed for LogInTesting

  Scenario: Non-Empty Email (Wrong Format 6)
    Given I have a browser opened for LogInTesting
    When I navigate to login page for LogInTesting
    And I enter "wrong.co@" in email field for LogInTesting
    And I click submit for LogInTesting
    Then I should receive an please-enter email message
    And browser is closed for LogInTesting

  Scenario: Non-Empty Email (Wrong Format 7)
    Given I have a browser opened for LogInTesting
    When I navigate to login page for LogInTesting
    And I enter "wrong.@c." in email field for LogInTesting
    And I click submit for LogInTesting
    Then I should receive an please-enter email message
    And browser is closed for LogInTesting

  Scenario: Non-Empty Email (Correct Format)
    Given I have a browser opened for LogInTesting
    When I navigate to login page for LogInTesting
    And I enter "correct@e.com" in email field for LogInTesting
    And I click submit for LogInTesting
    Then I should not receive an please-enter email message and should receive a please-enter password
    And browser is closed for LogInTesting

    #
    # Check password
    #
  Scenario: Non-Empty Password (Wrong account)
    Given I have a browser opened for LogInTesting
    When I navigate to login page for LogInTesting
    And I enter "wrongaccount@e.com" in email field for LogInTesting
    And I enter "password1234" in password field in login
    And I click submit for LogInTesting
    Then I should not receive an please-enter email message and should not receive a please-enter password
    And I should receive a wrong account
    And browser is closed for LogInTesting

  Scenario: Non-Empty Password (Correct and Inactivated account)
    Given I have registered for an account with email "testlogin1@gmail.com", password "test123456", and role "User"
    Given I have a browser opened for LogInTesting
    When I navigate to login page for LogInTesting
    And I enter "testlogin1@gmail.com" in email field for LogInTesting
    And I enter "test123456" in password field in login
    And I click submit for LogInTesting
    And I should receive an inactive account message
    And browser is closed for LogInTesting

  Scenario: Non-Empty Password (Correct and Activated account)
    Given I have registered and activated for an account with email "testlogin2@gmail.com", password "test123456", and role "User"
    And I have a browser opened for LogInTesting
    When I navigate to login page for LogInTesting
    And I enter "testlogin2@gmail.com" in email field for LogInTesting
    And I enter "test123456" in password field in login
    And I click submit for LogInTesting
    Then I should be navigated to home page
    And browser is closed for LogInTesting
