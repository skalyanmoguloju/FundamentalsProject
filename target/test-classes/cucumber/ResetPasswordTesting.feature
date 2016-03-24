Feature: Check Reset Password Page

  Scenario: Correct Reset Password Page
    Given I have a browser opened for ResetPasswordTesting
    When I navigate to reset password page for id 1
    Then I should be in the reset password page
    And browser is closed for ResetPasswordTesting

  Scenario: Empty Password
    Given I have a browser opened for ResetPasswordTesting
    When I navigate to reset password page for id 1
    And I click submit for ResetPasswordTesting
    Then I should receive empty password message
    And browser is closed for ResetPasswordTesting
