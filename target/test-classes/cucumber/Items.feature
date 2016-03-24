Feature: Check Items

  Scenario: getUser_id returns user_id
    Given Items is set up
    When user_id 1 is set for items
    Then getUser_id returns user_id 1 for items

  Scenario: getItem_id returns item_id
    Given Items is set up
    When item_id 5 is set for items
    Then getItem_id returns item_id 5

  Scenario: getItem_name returns item_name
    Given Items is set up
    When item_name "Item Test" is set
    Then getItem_name returns item_name "Item Test"

  Scenario: getItem_description returns item_description
    Given Items is set up
    When item_description "Description Test" is set
    Then getItem_description returns item_description "Description Test"

  Scenario: getOnsale_count returns onsale_count
    Given Items is set up
    When onsale_count 2 is set
    Then getOnsale_count returns onsale_count 2

  Scenario: getSold_count returns sold_count
    Given Items is set up
    When sold_count 2 is set
    Then getSold_count returns sold_count 2

  Scenario: getCategory returns category
    Given Items is set up
    When category "Cat Test" is set
    Then getCategory returns category "Cat Test"

  Scenario: getImages returns image
    Given Items is set up
    When image "IMG Test" is set
    Then getImages returns image "IMG Test"

  Scenario: getPrice returns price
    Given Items is set up
    When price 99 is set for items
    Then getPrice returns price 99

  Scenario: getDate returns date
    Given Items is set up
    When date is set
    Then getDate returns that date