Feature: Check ItemsBean
  # Test getDate and setDate
  Scenario: getDate returns correct date
    Given mock ItemsBean is initialized
    When getDate() is called
    Then an item date is returned

  Scenario: setDate sets date
    Given mock ItemsBean is initialized
    When setDate() is called
    Then setDate() is successfully called

  # Test getItem_Id and setItem_Id
  Scenario: getItem_Id returns correct id
    Given mock ItemsBean is initialized
    When getItem_Id() is called
    Then an item id is returned

  Scenario: setItem_Id sets item id
    Given mock ItemsBean is initialized
    When setItem_Id() is called
    Then setItem_Id() is successfully called

  # Test getItem_name and setItem_name
  Scenario: getItem_name returns correct name
    Given mock ItemsBean is initialized
    When getItem_name() is called
    Then an item name string is returned

  Scenario: setItem_name sets item name
    Given mock ItemsBean is initialized
    When setItem_name() is called
    Then setItem_namel() is successfully called

  # Test getItem_description and setItem_description
  Scenario: getItem_description returns correct description
    Given mock ItemsBean is initialized
    When getItem_description() is called
    Then a description string is returned

  Scenario: setItem_description sets description
    Given mock ItemsBean is initialized
    When setItem_description() is called
    Then setItem_description() is successfully called

  # Test getOnsale_count and setOnsale_count
  Scenario: getOnsale_count returns correct count
    Given mock ItemsBean is initialized
    When getOnsale_count() is called
    Then an on sale count is returned

  Scenario: setOnsale_count sets on sale count
    Given mock ItemsBean is initialized
    When setOnsale_count() is called
    Then setOnsale_count() is successfully called

  # Test getSold_count and setSold_count
  Scenario: getSold_count returns correct count
    Given mock ItemsBean is initialized
    When getSold_count() is called
    Then a sold count is returned

  Scenario: setSold_count sets sold count
    Given mock ItemsBean is initialized
    When setSold_count() is called
    Then setSold_count() is successfully called

  # Test getCategory and setCategory
  Scenario: getCategory returns correct category
    Given mock ItemsBean is initialized
    When getCategory is called
    Then a category string is returned

  Scenario: setCategory sets category
    Given mock ItemsBean is initialized
    When setCategory() is called
    Then setCategory() is successfully called

  # Test getImages and setImages
  Scenario: getImages returns correct images
    Given mock ItemsBean is initialized
    When getImages() is called
    Then an images list is returned

  Scenario: setImages sets images
    Given mock ItemsBean is initialized
    When setImages() is called
    Then setImages() is successfully called

  # Test getPrice and setPrice
  Scenario: getPrice returns correct price
    Given mock ItemsBean is initialized
    When getPrice() is called
    Then a price is returned

  Scenario: setPrice sets price
    Given mock ItemsBean is initialized
    When setPrice() is called
    Then setPrice() is successfully called

   # Test getUser_id and setUser_id
  Scenario: getUser_id returns correct user id
    Given mock ItemsBean is initialized
    When getUser_id() is called
    Then a user id is returned

  Scenario: setUser_id sets user id
    Given mock ItemsBean is initialized
    When setUser_id() is called
    Then setUser_id() is successfully called