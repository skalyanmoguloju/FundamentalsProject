Feature: Check Address

  Scenario: getAddress_Id returns address_id
    Given Address is set up
    When address_Id 1 is set
    Then getAddress_Id returns address_id 1

  Scenario: getUser_id returns user_id
    Given Address is set up
    When user_id 1 is set for Address
    Then getUser_id returns user_id 1 for Address

  Scenario: getLine1 returns line1
    Given Address is set up
    When line_1 "line 1" is set
    Then getLine_1 returns line_1 "line 1"

  Scenario: getLine2 returns line2
    Given Address is set up
    When line_2 "line 2" is set
    Then getLine_2 returns line_2 "line 2"

  Scenario: getCity returns city
    Given Address is set up
    When city "city 1" is set
    Then getCity returns city "city 1"

  Scenario: getState returns state
    Given Address is set up
    When state "state 1" is set
    Then getState returns state "state 1"

  Scenario: getZip returns zip
    Given Address is set up
    When zip 52240 is set
    Then getZip returns zip 52240

  Scenario: getPhone returns phone
    Given Address is set up
    When phone 111111111111 is set
    Then getPhone returns zip 111111111111
