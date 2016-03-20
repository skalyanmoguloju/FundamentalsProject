Feature: Check Sales

  Scenario: getSale_id returns sale_id
    Given sales is set up
    When sale_id 1 is set
    Then getSale_id returns 1

  Scenario: getItem_id returns item_id
    Given sales is set up
    When item_id 2 is set
    Then getItem_id returns 2

  Scenario: getUser_id returns user_id
    Given sales is set up
    When user_id 1 is set
    Then getUser_id returns 1

  Scenario: getPrice returns price
    Given sales is set up
    When price 99 is set
    Then getPrice returns 99

  Scenario: getQuantity returns quantity
    Given sales is set up
    When quantity 3 is set
    Then getQuantity returns 3

  Scenario: getCard_number returns card_number
    Given sales is set up
    When card_number "0000-1111-2222-3333" is set
    Then getCard_number returns "0000-1111-2222-3333"

  Scenario: getExp_date returns exp_date
    Given sales is set up
    When exp_date "2016-05-05" is set
    Then getExp_date returns "2016-05-05"

  Scenario: getCard_cvv returns CVV
    Given sales is set up
    When CVV "544" is set
    Then getCard_cvv returns "544"

