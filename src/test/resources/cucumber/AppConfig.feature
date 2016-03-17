Feature: Check AppConfig

  Scenario: test viewResolver
    Given I have an AppConfig
    When I call viewResolver
    Then I get back an InternalResourceViewResolver