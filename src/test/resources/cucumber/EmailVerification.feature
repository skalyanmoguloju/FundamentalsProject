Feature: Email Verification

  Scenario: 2 random keys are different
    Given I have an EmailVerification
    When I generate 2 key(s)
    Then they should be different

  Scenario: a return key is a random UUID
    Given I have an EmailVerification
    When I generate 1 key(s)
    Then it should have the same length as a random UUID