Feature: Check SalesBean
  # Test getSale_id and setSale_id
  Scenario: getSale_id returns correct id
    Given mock SalesBean is initialized
    When getSale_id() is called
    Then a sale id is returned

  Scenario: setSale_id sets sale_id
    Given mock SalesBean is initialized
    When setSale_id() is called
    Then setSale_id() is successfully called

  # Test getItem_id and setItem_id
  Scenario: getItem_id returns correct item_id
    Given mock SalesBean is initialized
    When getItem_id() is called
    Then an item_id is returned

  Scenario: setItem_id sets item_id
    Given mock SalesBean is initialized
    When setItem_id() is called
    Then setItem_id() is successfully called

  # Test getUser_id and setUser_id
  Scenario: getUser_id returns correct user_id
    Given mock SalesBean is initialized
    When a sales bean getUser_id() is called
    Then a sales bean user id is returned

  Scenario: setEmail sets email
    Given mock SalesBean is initialized
    When setUser_id() for sales bean is called
    Then setUser_id() for sales bean is successfully called

  # Test getPrice and setPrice
  Scenario: getPrice returns correct price
    Given mock SalesBean is initialized
    When getPrice() for sales bean is called
    Then a price string for sales bean is returned

  Scenario: setPrice sets price
    Given mock SalesBean is initialized
    When setPrice() for sale bean is called
    Then setPrice() for sale bean is successfully called

  # Test getQuantity and setQuantity
  Scenario: getQuantity returns correct quantity
    Given mock SalesBean is initialized
    When getQuantity() for sales bean is called
    Then a quantity string for sales bean is returned

  Scenario: setQuantity sets quantity
    Given mock SalesBean is initialized
    When setQuantity() for sales bean is called
    Then setQuantity() for sales bean is successfully called

  # Test getCard_number and setCard_number
  Scenario: getCard_number returns correct card number
    Given mock SalesBean is initialized
    When getCard_number() is called
    Then a card number string is returned

  Scenario: setCard_number sets card number
    Given mock SalesBean is initialized
    When setCard_number() is called
    Then setCard_number() is successfully called

  # Test getExp_date and setExp_date
  Scenario: getExp_date returns correct exp date
    Given mock SalesBean is initialized
    When getExp_date is called
    Then an exp date string is returned

  Scenario: setExp_date sets role
    Given mock SalesBean is initialized
    When setExp_date() is called
    Then setExp_date() is successfully called

  # Test getCard_cvv and setCard_cvv
  Scenario: getCard_cvv returns correct card cvv
    Given mock SalesBean is initialized
    When getCard_cvv() is called
    Then a card cvv is returned

  Scenario: setCard_dvv sets card cvv
    Given mock SalesBean is initialized
    When setCard_cvv() is called
    Then setCard_cvv() is successfully called
