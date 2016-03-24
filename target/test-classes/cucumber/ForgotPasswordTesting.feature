Feature: Check Forgot password Page

  Scenario: Correct Forgot password Page
    Given I have a browser opened for ForgotPasswordTesting
    When I navigate to forgot password page
    Then I should be in the forgot password page
    And browser is closed for ForgotPasswordTesting

  #
  # Check email
  #
  Scenario: Empty Email
    Given I have a browser opened for ForgotPasswordTesting
    When I navigate to forgot password page
    And I click submit for forgotPasswordTesting
    Then I should receive an please-enter email message for ForgotPasswordTesting
    And browser is closed for ForgotPasswordTesting

  Scenario: Non-Empty Email (Wrong Format 1)
    Given I have a browser opened for ForgotPasswordTesting
    When I navigate to forgot password page
    And I enter "wrong" in email field for ForgotPasswordTesting
    And I click submit for forgotPasswordTesting
    Then I should receive an please-enter email message for ForgotPasswordTesting
    And browser is closed for ForgotPasswordTesting

  Scenario: Non-Empty Email (Wrong Format 2)
    Given I have a browser opened for ForgotPasswordTesting
    When I navigate to forgot password page
    And I enter "wrong." in email field for ForgotPasswordTesting
    And I click submit for forgotPasswordTesting
    Then I should receive an please-enter email message for ForgotPasswordTesting
    And browser is closed for ForgotPasswordTesting

  Scenario: Non-Empty Email (Wrong Format 3)
    Given I have a browser opened for ForgotPasswordTesting
    When I navigate to forgot password page
    And I enter "wrong.@" in email field for ForgotPasswordTesting
    And I click submit for forgotPasswordTesting
    Then I should receive an please-enter email message for ForgotPasswordTesting
    And browser is closed for ForgotPasswordTesting

  Scenario: Non-Empty Email (Wrong Format 4)
    Given I have a browser opened for ForgotPasswordTesting
    When I navigate to forgot password page
    And I enter "wrong@." in email field for ForgotPasswordTesting
    And I click submit for forgotPasswordTesting
    Then I should receive an please-enter email message for ForgotPasswordTesting
    And browser is closed for ForgotPasswordTesting

  Scenario: Non-Empty Email (Wrong Format 5)
    Given I have a browser opened for ForgotPasswordTesting
    When I navigate to forgot password page
    And I enter "wrong@.co" in email field for ForgotPasswordTesting
    And I click submit for forgotPasswordTesting
    Then I should receive an please-enter email message for ForgotPasswordTesting
    And browser is closed for ForgotPasswordTesting

  Scenario: Non-Empty Email (Wrong Format 6)
    Given I have a browser opened for ForgotPasswordTesting
    When I navigate to forgot password page
    And I enter "wrong.co@" in email field for ForgotPasswordTesting
    And I click submit for forgotPasswordTesting
    Then I should receive an please-enter email message for ForgotPasswordTesting
    And browser is closed for ForgotPasswordTesting

  Scenario: Non-Empty Email (Wrong Format 7)
    Given I have a browser opened for ForgotPasswordTesting
    When I navigate to forgot password page
    And I enter "wrong.@c." in email field for ForgotPasswordTesting
    And I click submit for forgotPasswordTesting
    Then I should receive an please-enter email message for ForgotPasswordTesting
    And browser is closed for ForgotPasswordTesting

  Scenario: Non-Empty Email (Correct Format - Invalid account's email)
    Given I have a browser opened for ForgotPasswordTesting
    When I navigate to forgot password page
    And I enter "correct@e.com" in email field for ForgotPasswordTesting
    And I click submit for forgotPasswordTesting
    Then I should not receive an please-enter email message for ForgotPasswordTesting
    And I should receive a invalid email message
    And browser is closed for ForgotPasswordTesting

  Scenario: Non-Empty Email (Correct Format - Invalid account's email)
    Given I have a browser opened for ForgotPasswordTesting
    When I navigate to forgot password page
    And I enter "testlogin1@gmail.com" in email field for ForgotPasswordTesting
    And I click submit for forgotPasswordTesting
    Then I should not receive an please-enter email message for ForgotPasswordTesting
    And I should not receive a invalid email message
    And I should receive confirm alert
    When I click ok
    Then I should be in the login page for ForgotPasswordTesting
    And browser is closed for ForgotPasswordTesting