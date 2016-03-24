Feature: Check Items

  Scenario: getUser_id returns user_id
<<<<<<< HEAD
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
=======
    Given items is set up
    When items user_id 1 is set
    Then items getUser_id returns 1

  Scenario: getItem_id returns item_id
    Given items is set up
    When items item_id 2 is set
    Then items getItem_id returns 2

  Scenario: getItem_name returns item_name
    Given items is set up
    When items item_name "ItemName" is set
    Then items get_item_name returns "ItemName"

  Scenario: getItem_description returns item_description
    Given items is set up
    When item_description "Item description" is set
    Then getItem_description returns "Item description"

  Scenario: getOnsale_count returns onsale_count
    Given items is set up
    When onsale_count 3 is set
    Then getOnsale_count returns 3

  Scenario: getSold_count returns sold_count
    Given items is set up
    When sold_count 5 is set
    Then sold_count returns 5

  Scenario: getCategory returns category
    Given items is set up
    When category "Category" is set
    Then getCategory returns "Category"

  Scenario: getImages returns images
    Given items is set up
    When images  "Images" is set
    Then getImages returns "Images"

  Scenario: getPrice returns price
    Given items is set up
    When items price  4 is set
    Then items getPrice returns 4

  Scenario: getDate returns date
    Given items is set up
    When date  now is set
    Then getDate returns current date
>>>>>>> 43e99e79b6071b0abebbfc97365cadd16af04e49
