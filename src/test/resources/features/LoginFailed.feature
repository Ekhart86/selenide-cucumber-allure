@all
Feature: Validate failed login on the Login page

  @Login
  @LoginFailed
  Scenario: Validate failed login
    Given user open page '/login'
    When user sets login 'failed'
    And user sets password 'failed'
    And user click on Sign in button
    Then message about an incorrect username or password is displayed