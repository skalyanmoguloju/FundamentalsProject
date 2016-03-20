Feature: Check SignUp Page

  Scenario: Correct SignUp Page
    Given I have a browser opened
    When I navigate to signup page
    Then I should be in the signup page
    And browser is closed

  #
  # Check First Name
  #
  Scenario: Empty First Name
    Given I have a browser opened
    When I navigate to signup page
    And I click submit
    Then I should receive an empty first name message
    And browser is closed

  Scenario: Non-Empty First Name
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I click submit
    Then I should not receive an empty first name message
    And browser is closed

  #
  # Check Last Name
  #
  Scenario: Empty Last Name
    Given I have a browser opened
    When I navigate to signup page
    And I enter "NonEmpty" in first name field
    And I click submit
    Then I should receive an empty last name message
    And browser is closed

  Scenario: Non-Empty Last Name
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I click submit
    Then I should not receive an empty last name message
    And browser is closed

  #
  # Check Email
  #
  Scenario: Empty Email
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I click submit
    Then I should receive an empty email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 1)
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "wrong" in email field
    And I click submit
    Then I should not receive an empty email message and should receive a wrong email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 2)
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "wrong." in email field
    And I click submit
    Then I should not receive an empty email message and should receive a wrong email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 3)
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "wrong.@" in email field
    And I click submit
    Then I should not receive an empty email message and should receive a wrong email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 4)
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "wrong@." in email field
    And I click submit
    Then I should not receive an empty email message and should receive a wrong email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 5)
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "wrong@.co" in email field
    And I click submit
    Then I should not receive an empty email message and should receive a wrong email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 6)
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "wrong.co@" in email field
    And I click submit
    Then I should not receive an empty email message and should receive a wrong email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 7)
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "wrong.@c." in email field
    And I click submit
    Then I should not receive an empty email message and should receive a wrong email message
    And browser is closed

  Scenario: Non-Empty Email (Correct Format)
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I click submit
    Then I should not receive a wrong email message or empty email message
    And browser is closed

  #
  # Check Password
  #
  Scenario: Empty Password
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I click submit
    Then I should receive an empty password message
    And browser is closed

  Scenario: Non-Empty Password Less than 6 characters (numeric characters)
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed

  Scenario: Non-Empty Password Less than 6 characters (alphabetic characters)
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "abc" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed

  Scenario: Non-Empty Password Less than 6 characters (alphanumeric characters) - 1st case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123aa" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed

  Scenario: Non-Empty Password Less than 6 characters (alphanumeric characters) - 2nd case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123ab" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed

  Scenario: Non-Empty Password Less than 6 characters (alphanumeric characters) - 3rd case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123a" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed

  Scenario: Non-Empty Password Less than 6 characters (alphanumeric characters) - 4th case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "1a1b2" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed

  Scenario: Non-Empty Password Less than 6 characters (alphanumeric characters) - 5th case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "aa2" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed

  Scenario: Non-Empty Password Less than 6 characters (alphanumeric characters) - 6th case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "aa23" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed

  Scenario: Non-Empty Password Less than 6 characters (alphanumeric characters) - 6th case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "b2b3" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed

  Scenario: Non-Empty Password Less than 6 characters (alphanumeric characters) - 7th case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "b2b3a" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed

  Scenario: Non-Empty Password at least 6 characters (numeric characters) - 1st case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should receive an alphanumeric message
    And browser is closed

  Scenario: Non-Empty Password at least 6 characters (numeric characters) - 2nd case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "1233445561" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should receive an alphanumeric message
    And browser is closed

  Scenario: Non-Empty Password at least 6 characters (alphabetic characters) - 3rd case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "abcdef" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should receive an alphanumeric message
    And browser is closed

  Scenario: Non-Empty Password at least 6 characters (alphabetic characters) - 4th case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "abbccrra" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should receive an alphanumeric message
    And browser is closed

  Scenario: Non-Empty Password at least 6 characters and alphanumeric characters - 1st case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456a" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message
    And browser is closed

  Scenario: Non-Empty Password at least 6 characters and alphanumeric characters - 2nd case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message
    And browser is closed

  Scenario: Non-Empty Password at least 6 characters and alphanumeric characters - 3rd case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "12ab44ab" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message
    And browser is closed

  Scenario: Non-Empty Password at least 6 characters and alphanumeric characters - 4th case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "12ab3c44" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message
    And browser is closed

  Scenario: Non-Empty Password at least 6 characters and alphanumeric characters - 5th case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "12ab3c5" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message
    And browser is closed

  Scenario: Non-Empty Password at least 6 characters and alphanumeric characters - 6th case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "abcd123" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message
    And browser is closed

  Scenario: Non-Empty Password at least 6 characters and alphanumeric characters - 7th case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "ab124f" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message
    And browser is closed

  Scenario: Non-Empty Password at least 6 characters and alphanumeric characters - 8th case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "a55f22c3" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message
    And browser is closed

    #
    # Check Confirm Password
    #
  Scenario: Empty Confirm Password
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "a55f22c3" in password field
    And I click submit
    Then I should receive an empty confirm password message
    And browser is closed

  Scenario: Non-Empty Confirm Password which doesn't match with Password - 1st case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123" in confirm password field
    And I click submit
    Then I should not receive an empty confirm password message
    And I should receive a non-matching password message
    And browser is closed

  Scenario: Non-Empty Confirm Password which doesn't match with Password - 2nd case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "abc" in confirm password field
    And I click submit
    Then I should not receive an empty confirm password message
    And I should receive a non-matching password message
    And browser is closed

  Scenario: Non-Empty Confirm Password which doesn't match with Password - 3rd case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123ab" in confirm password field
    And I click submit
    Then I should not receive an empty confirm password message
    And I should receive a non-matching password message
    And browser is closed

  Scenario: Non-Empty Confirm Password which doesn't match with Password - 4th case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "ab1233" in confirm password field
    And I click submit
    Then I should not receive an empty confirm password message
    And I should receive a non-matching password message
    And browser is closed

  Scenario: Non-Empty Confirm Password which doesn't match with Password - 5th case
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "ab12cc3" in confirm password field
    And I click submit
    Then I should not receive an empty confirm password message
    And I should receive a non-matching password message
    And browser is closed

  Scenario: Non-Empty Confirm Password matching with Password
    Given I have a browser opened
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123456ab" in confirm password field
    And I click submit
    Then I should not receive an empty confirm password message
    And I should not receive a non-matching password message
    And browser is closed

#########################################################################################
# Feature: Check Login Page

  Scenario: Correct Login Page
    Given I have a browser opened
    When I navigate to login page
    Then I should be in the login page
    And browser is closed
  #
  # Check email
  #
  Scenario: Empty Email
    Given I have a browser opened
    When I navigate to login page
    And I click submit
    Then I should receive an please-enter email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 1)
    Given I have a browser opened
    When I navigate to login page
    And I enter "wrong" in email field
    And I click submit
    Then I should receive an please-enter email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 2)
    Given I have a browser opened
    When I navigate to login page
    And I enter "wrong." in email field
    And I click submit
    Then I should receive an please-enter email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 3)
    Given I have a browser opened
    When I navigate to login page
    And I enter "wrong.@" in email field
    And I click submit
    Then I should receive an please-enter email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 4)
    Given I have a browser opened
    When I navigate to login page
    And I enter "wrong@." in email field
    And I click submit
    Then I should receive an please-enter email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 5)
    Given I have a browser opened
    When I navigate to login page
    And I enter "wrong@.co" in email field
    And I click submit
    Then I should receive an please-enter email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 6)
    Given I have a browser opened
    When I navigate to login page
    And I enter "wrong.co@" in email field
    And I click submit
    Then I should receive an please-enter email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 7)
    Given I have a browser opened
    When I navigate to login page
    And I enter "wrong.@c." in email field
    And I click submit
    Then I should receive an please-enter email message
    And browser is closed

  Scenario: Non-Empty Email (Correct Format)
    Given I have a browser opened
    When I navigate to login page
    And I enter "correct@e.com" in email field
    And I click submit
    Then I should not receive an please-enter email message and should receive a please-enter password
    And browser is closed

    #
    # Check password
    #
  Scenario: Non-Empty Password (Wrong account)
    Given I have a browser opened
    When I navigate to login page
    And I enter "wrongaccount@e.com" in email field
    And I enter "password1234" in password field in login
    And I click submit
    Then I should not receive an please-enter email message and should not receive a please-enter password
    And I should receive a wrong account
    And browser is closed

  Scenario: Non-Empty Password (Correct account)
    Given I have a browser opened
    When I navigate to login page
    And I enter "test@gmail.com" in email field
    And I enter "test123456" in password field in login
    And I click submit
    Then I should be navigated to home page
    And browser is closed

########################################################################################
# Feature: Check Forgot password Page

  Scenario: Correct Forgot password Page
    Given I have a browser opened
    When I navigate to forgot password page
    Then I should be in the forgot password page
    And browser is closed

  #
  # Check email
  #
  Scenario: Empty Email
    Given I have a browser opened
    When I navigate to forgot password page
    Then I should be in the forgot password page
    And I click submit
    Then I should receive an please-enter email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 1)
    Given I have a browser opened
    When I navigate to forgot password page
    And I enter "wrong" in email field
    And I click submit
    Then I should receive an please-enter email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 2)
    Given I have a browser opened
    When I navigate to forgot password page
    And I enter "wrong." in email field
    And I click submit
    Then I should receive an please-enter email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 3)
    Given I have a browser opened
    When I navigate to forgot password page
    And I enter "wrong.@" in email field
    And I click submit
    Then I should receive an please-enter email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 4)
    Given I have a browser opened
    When I navigate to forgot password page
    And I enter "wrong@." in email field
    And I click submit
    Then I should receive an please-enter email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 5)
    Given I have a browser opened
    When I navigate to forgot password page
    And I enter "wrong@.co" in email field
    And I click submit
    Then I should receive an please-enter email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 6)
    Given I have a browser opened
    When I navigate to forgot password page
    And I enter "wrong.co@" in email field
    And I click submit
    Then I should receive an please-enter email message
    And browser is closed

  Scenario: Non-Empty Email (Wrong Format 7)
    Given I have a browser opened
    When I navigate to forgot password page
    And I enter "wrong.@c." in email field
    And I click submit
    Then I should receive an please-enter email message
    And browser is closed

  Scenario: Non-Empty Email (Correct Format - Invalid account's email)
    Given I have a browser opened
    When I navigate to forgot password page
    And I enter "correct@e.com" in email field
    And I click submit
    Then I should not receive an please-enter email message and should receive a invalid email message
    And browser is closed

  Scenario: Non-Empty Email (Correct Format - Invalid account's email)
    Given I have a browser opened
    When I navigate to forgot password page
    And I enter "test@gmail.com" in email field
    And I click submit
    Then I should not receive an please-enter email message and should not receive a invalid email message
    And I should receive confirm alert
    When I click ok
    Then I should be in the login page
    And browser is closed