Feature: Check UserBean
  # Test getId and setId
  Scenario: getId returns correct id
    Given mock UserBean is initialized
    When getId() is called
    Then an id is returned

  Scenario: setId sets Id
    Given mock UserBean is initialized
    When setId() is called
    Then setId() is successfully called

  # Test getDob and setDob
  Scenario: getDob returns correct dob
    Given mock UserBean is initialized
    When getDob() is called
    Then a date is returned

  Scenario: setDob sets dob
    Given mock UserBean is initialized
    When setDob() is called
    Then setDob() is successfully called

  # Test getEmail and setEmail
  Scenario: getEmail returns correct email
    Given mock UserBean is initialized
    When getEmail() is called
    Then an email string is returned

  Scenario: setEmail sets email
    Given mock UserBean is initialized
    When setEmail() is called
    Then setEmail() is successfully called

  # Test getLname and setLname
  Scenario: getLname returns correct lname
    Given mock UserBean is initialized
    When getLname() is called
    Then a lname string is returned

  Scenario: setLname sets lname
    Given mock UserBean is initialized
    When setLname() is called
    Then setLname() is successfully called

  # Test getPwsd and setPwsd
  Scenario: getPwsd returns correct pwsd
    Given mock UserBean is initialized
    When getPwsd() is called
    Then a password string is returned

  Scenario: setPwsd sets pwsd
    Given mock UserBean is initialized
    When setPwsd() is called
    Then setPwsd() is successfully called

  # Test getName and setName
  Scenario: getName returns correct name
    Given mock UserBean is initialized
    When getName() is called
    Then a name string is returned

  Scenario: setName sets name
    Given mock UserBean is initialized
    When setName() is called
    Then setName() is successfully called

  # Test getRole and setRole
  Scenario: getRole returns correct role
    Given mock UserBean is initialized
    When getRole is called
    Then a role string is returned

  Scenario: setRole sets role
    Given mock UserBean is initialized
    When setRole() is called
    Then setRole() is successfully called

  # Test getStatus and setStatus
  Scenario: getStatus returns correct status
    Given mock UserBean is initialized
    When getStatus() is called
    Then a status string is returned

  Scenario: setStatus sets status
    Given mock UserBean is initialized
    When setStatus() is called
    Then setStatus() is successfully called

  # Test getGender and setGender
  Scenario: getGender returns correct gender
    Given mock UserBean is initialized
    When getGender() is called
    Then a gender string is returned

  Scenario: setGender sets gender
    Given mock UserBean is initialized
    When setGender() is called
    Then setGender() is successfully called
