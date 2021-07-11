@all
Feature: Validate passed login on the Login page

  @Login
  @LoginPassed
  Scenario: Validate passed login
    Given user open page '/login'
    When user sets login 'tomsmith'
    And user sets password 'SuperSecretPassword!'
    And user click on Sign in button
    Then message about successful authorization is displayed