Feature: Check AppConfig

  Scenario: test viewResolver
    Given I have an AppConfig
    When I call viewResolver
    Then I get back an InternalResourceViewResolver

  Scenario: test addResourceHandlers
    Given I have an AppConfig
    When I call addResourceHandlers
    Then addResourceHandlers runs successfully

  Scenario: test configureDefaultServletHandling
    Given I have an AppConfig
    When I call configureDefaultServletHandling
    Then configureDefaultServletHandling runs successfully