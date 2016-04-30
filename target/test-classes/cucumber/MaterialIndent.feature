Feature: Check MaterialIndent

  Scenario: getUser_id returns user_id
    Given items is set up for MaterialIndent
    When items user_id 1 is set for MaterialIndent
    Then items getUser_id returns 1 for MaterialIndent

  Scenario: getIndent_id returns indent_id
    Given indent_id is set up for MaterialIndent
    When indent_id 2 is set for MaterialIndent
    Then getIndent_id returns 2 for MaterialIndent

  Scenario: getIndent_date returns date
    Given indent_date is set up
    When indent_date is set
    Then getIndent_date returns that date

  Scenario: getPrice returns price
    Given price is set up
    When price 3 is set for MaterialIndent
    Then getPrice returns 3 for MaterialIndent

  Scenario: getCard_number returns cart_number
    Given cart_number is set up
    When cart_number "cartnumber" is set
    Then getCard_number returns "cartnumber" for MaterialIndent

  Scenario: getCard_cvv returns cvv
    Given cvv is set up
    When cvv "123" is set
    Then getCard_cvv returns "123" for MaterialIndent

  Scenario: getCard_exp returns exp
    Given exp is set up
    When exp "11/12" is set
    Then getCard_exp returns "11/12"

  Scenario: getAddress returns address
    Given address is set up
    When an address is set
    Then getAddress returns address