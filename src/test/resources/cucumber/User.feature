Feature: Check User

  Scenario: getId returns id
    Given user is set up
    When id 1 is set
    Then getId returns 1

  Scenario: getName returns name
    Given user is set up
    When name "testname" is set
    Then getName returns "testname"

  Scenario: getLname returns last name
    Given user is set up
    When last name "testlname" is set
    Then getLname returns "testlname"

  Scenario: getEmail returns email
    Given user is set up
    When email "test@gmail.com" is set
    Then getEmail returns "test@gmail.com"

  Scenario: getPwsd returns password
    Given user is set up
    When password "testpassword" is set
    Then getPwsd returns "testpassword"

  Scenario: getDob returns date of birth
    Given user is set up
    When date "2000-01-01" is set
    Then getDob returns "2000-01-01"

  Scenario: getRole returns role
    Given user is set up
    When role "User" is set
    Then getRole returns "User"

  Scenario: getStatus returns status
    Given user is set up
    When status "Activate" is set
    Then getStatus returns "Activate"

  Scenario: getGender returns gender
    Given user is set up
    When gender "M" is set
    Then getGender returns "M"

