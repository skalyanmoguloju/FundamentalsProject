Feature: Check SignUp Page

  Scenario: Correct SignUp Page
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    Then I should be in the signup page
    And browser is closed for SignUpTesting

  #
  # Check First Name
  #
  Scenario: Empty First Name
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I click submit
    Then I should receive an empty first name message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty First Name
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I click submit
    Then I should not receive an empty first name message
    And browser is closed for SignUpTesting

  #
  # Check Last Name
  #
  Scenario: Empty Last Name
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "NonEmpty" in first name field
    And I click submit
    Then I should receive an empty last name message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Last Name
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I click submit
    Then I should not receive an empty last name message
    And browser is closed for SignUpTesting

  #
  # Check Email
  #
  Scenario: Empty Email
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I click submit
    Then I should receive an empty email message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Email (Wrong Format 1)
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "wrong" in email field
    And I click submit
    Then I should not receive an empty email message and should receive a wrong email message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Email (Wrong Format 2)
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "wrong." in email field
    And I click submit
    Then I should not receive an empty email message and should receive a wrong email message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Email (Wrong Format 3)
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "wrong.@" in email field
    And I click submit
    Then I should not receive an empty email message and should receive a wrong email message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Email (Wrong Format 4)
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "wrong@." in email field
    And I click submit
    Then I should not receive an empty email message and should receive a wrong email message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Email (Wrong Format 5)
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "wrong@.co" in email field
    And I click submit
    Then I should not receive an empty email message and should receive a wrong email message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Email (Wrong Format 6)
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "wrong.co@" in email field
    And I click submit
    Then I should not receive an empty email message and should receive a wrong email message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Email (Wrong Format 7)
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "wrong.@c." in email field
    And I click submit
    Then I should not receive an empty email message and should receive a wrong email message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Email (Correct Format)
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I click submit
    Then I should not receive a wrong email message or empty email message
    And browser is closed for SignUpTesting

  #
  # Check Password
  #
  Scenario: Empty Password
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I click submit
    Then I should receive an empty password message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password Less than 6 characters (numeric characters)
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password Less than 6 characters (alphabetic characters)
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "abc" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password Less than 6 characters (alphanumeric characters) - 1st case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123aa" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password Less than 6 characters (alphanumeric characters) - 2nd case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123ab" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password Less than 6 characters (alphanumeric characters) - 3rd case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123a" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password Less than 6 characters (alphanumeric characters) - 4th case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "1a1b2" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password Less than 6 characters (alphanumeric characters) - 5th case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "aa2" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password Less than 6 characters (alphanumeric characters) - 6th case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "aa23" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password Less than 6 characters (alphanumeric characters) - 6th case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "b2b3" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password Less than 6 characters (alphanumeric characters) - 7th case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "b2b3a" in password field
    And I click submit
    Then I should not receive an empty password message and should receive a 6-character message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password at least 6 characters (numeric characters) - 1st case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should receive an alphanumeric message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password at least 6 characters (numeric characters) - 2nd case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "1233445561" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should receive an alphanumeric message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password at least 6 characters (alphabetic characters) - 3rd case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "abcdef" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should receive an alphanumeric message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password at least 6 characters (alphabetic characters) - 4th case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "abbccrra" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should receive an alphanumeric message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password at least 6 characters and alphanumeric characters - 1st case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456a" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password at least 6 characters and alphanumeric characters - 2nd case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password at least 6 characters and alphanumeric characters - 3rd case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "12ab44ab" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password at least 6 characters and alphanumeric characters - 4th case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "12ab3c44" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password at least 6 characters and alphanumeric characters - 5th case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "12ab3c5" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password at least 6 characters and alphanumeric characters - 6th case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "abcd123" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password at least 6 characters and alphanumeric characters - 7th case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "ab124f" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Password at least 6 characters and alphanumeric characters - 8th case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "a55f22c3" in password field
    And I click submit
    Then I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message
    And browser is closed for SignUpTesting

    #
    # Check Confirm Password
    #
  Scenario: Empty Confirm Password
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "a55f22c3" in password field
    And I click submit
    Then I should receive an empty confirm password message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Confirm Password which doesn't match with Password - 1st case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123" in confirm password field
    And I click submit
    Then I should not receive an empty confirm password message
    And I should receive a non-matching password message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Confirm Password which doesn't match with Password - 2nd case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "abc" in confirm password field
    And I click submit
    Then I should not receive an empty confirm password message
    And I should receive a non-matching password message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Confirm Password which doesn't match with Password - 3rd case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123ab" in confirm password field
    And I click submit
    Then I should not receive an empty confirm password message
    And I should receive a non-matching password message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Confirm Password which doesn't match with Password - 4th case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "ab1233" in confirm password field
    And I click submit
    Then I should not receive an empty confirm password message
    And I should receive a non-matching password message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Confirm Password which doesn't match with Password - 5th case
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "ab12cc3" in confirm password field
    And I click submit
    Then I should not receive an empty confirm password message
    And I should receive a non-matching password message
    And browser is closed for SignUpTesting

  Scenario: Non-Empty Confirm Password matching with Password
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123456ab" in confirm password field
    And I click submit
    Then I should not receive an empty confirm password message
    And I should not receive a non-matching password message
    And browser is closed for SignUpTesting

    #
    # Check Roles
    #
  Scenario: Empty Role
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123456ab" in confirm password field
    And I click submit
    Then I should receive a select-role message
    And browser is closed for SignUpTesting

  Scenario: Non-empty Role - User
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123456ab" in confirm password field
    And I choose User role
    And I click submit
    Then I should not receive an id message for User
    And browser is closed for SignUpTesting

  Scenario: Non-empty Role - Admin without id
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123456ab" in confirm password field
    And I choose Admin role
    And I click submit
    Then I should receive an id message for Admin
    And browser is closed for SignUpTesting

  Scenario: Non-empty Role - Manager without id
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123456ab" in confirm password field
    And I choose Manager role
    And I click submit
    Then I should receive an id message for Manager
    And browser is closed for SignUpTesting

  Scenario: Non-empty Role - Admin with id
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123456ab" in confirm password field
    And I choose Admin role
    And I enter "1" in Assign ID
    And I click submit
    Then I should not receive an id message for Admin
    And browser is closed for SignUpTesting

  Scenario: Non-empty Role - Manager with id
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123456ab" in confirm password field
    And I choose Manager role
    And I enter "1" in Assign ID
    And I click submit
    Then I should not receive an id message for Manager
    And browser is closed for SignUpTesting

    #
    # Check Gender
    #
  Scenario: Empty Gender
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123456ab" in confirm password field
    And I choose Manager role
    And I enter "1" in Assign ID
    And I click submit
    Then I should receive an empty gender message
    And browser is closed for SignUpTesting

  Scenario: Empty Gender
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123456ab" in confirm password field
    And I choose Manager role
    And I enter "1" in Assign ID
    And I click submit
    Then I should receive an empty gender message
    And browser is closed for SignUpTesting

  Scenario: Non-empty Gender - Male
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123456ab" in confirm password field
    And I choose Manager role
    And I enter "1" in Assign ID
    And I choose Male gender
    And I click submit
    Then I should not receive an empty gender message
    And browser is closed for SignUpTesting

  Scenario: Non-empty Gender - Female
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123456ab" in confirm password field
    And I choose Manager role
    And I enter "1" in Assign ID
    And I choose Female gender
    And I click submit
    Then I should not receive an empty gender message
    And browser is closed for SignUpTesting

  #
  #   Check DOB
  #
  Scenario: Empty DOB
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123456ab" in confirm password field
    And I choose Manager role
    And I enter "1" in Assign ID
    And I choose Male gender
    And I click submit
    Then I should receive an empty dob message
    And browser is closed for SignUpTesting

  Scenario: Nonmpty DOB - Wrong format 1
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123456ab" in confirm password field
    And I choose Manager role
    And I enter "2" in Assign ID
    And I choose Male gender
    And I enter "wrong" in the dob field
    And I click submit
    Then I should receive an empty dob message
    And browser is closed for SignUpTesting

  Scenario: Nonmpty DOB - Wrong format 2
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123456ab" in confirm password field
    And I choose Manager role
    And I enter "2" in Assign ID
    And I choose Male gender
    And I enter "05/" in the dob field
    And I click submit
    Then I should receive an error signup message
    And browser is closed for SignUpTesting

  Scenario: Nonmpty DOB - Wrong format 3
    Given I have a browser opened for SignUpTesting
    When I navigate to signup page
    And I enter "Group" in first name field
    And I enter "4" in last name field
    And I enter "correct@e.com" in email field
    And I enter "123456ab" in password field
    And I enter "123456ab" in confirm password field
    And I choose Manager role
    And I enter "2" in Assign ID
    And I choose Male gender
    And I enter "03/12" in the dob field
    And I click submit
    Then I should receive an error signup message
    And browser is closed for SignUpTesting

#  Scenario: Nonmpty DOB - Wrong format 4
#    Given I have a browser opened for SignUpTesting
#    When I navigate to signup page
#    And I enter "Group" in first name field
#    And I enter "4" in last name field
#    And I enter "correct@e.com" in email field
#    And I enter "123456ab" in password field
#    And I enter "123456ab" in confirm password field
#    And I choose Manager role
#    And I enter "2" in Assign ID
#    And I choose Male gender
#    And I enter "03/12/" in the dob field
#    And I click submit
#    Then I should receive an error signup message
#    And browser is closed for SignUpTesting
#
#  Scenario: Nonmpty DOB - Correct format
#    Given I have a browser opened for SignUpTesting
#    When I navigate to signup page
#    And I enter "Test" in first name field
#    And I enter "LNtest" in last name field
#    And I enter "testsu@gmail.com" in email field
#    And I enter "test123456" in password field
#    And I enter "test123456" in confirm password field
#    And I choose Manager role
#    And I enter "2" in Assign ID
#    And I choose Male gender
#    And I enter "02/02/2000" in the dob field
#    And I click submit
#    Then I should not receive an error signup message
#    And browser is closed for SignUpTesting