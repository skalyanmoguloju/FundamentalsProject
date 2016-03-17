Feature: Check EmailVerification

  Scenario: 2 random keys are different
    Given I have an EmailVerification
    When I generate 2 key(s)
    Then they should be different

  Scenario: 2 random keys are different
    Given I have an EmailVerification
    When I generate 4 key(s)
    Then they should be different

  Scenario: a return key is a random UUID
    Given I have an EmailVerification
    When I generate 1 key(s)
    Then each key should have the same length as a random UUID

  Scenario: each return key is a random UUID
    Given I have an EmailVerification
    When I generate 3 key(s)
    Then each key should have the same length as a random UUID

  Scenario: a return key after executing sendEmailVerificationLink is a random UUID
    Given I have an EmailVerification
    When I call sendEmailVerificationLink
    Then it should return a key having the same length as a random UUID