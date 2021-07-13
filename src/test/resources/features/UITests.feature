@all
Feature: Validate failed login on the Login page

  @UI
  @Login
  @LoginPassed
  Scenario: Validate passed login
    Given user open 'Login Page'
    When user sets login 'tomsmith'
    And user sets password 'SuperSecretPassword!'
    And user click on Sign in button
    Then message about successful authorization is displayed


  @UI
  @Login
  @LoginFailed
  Scenario: Validate failed login
    Given user open 'Login Page'
    When user sets login 'failed'
    And user sets password 'failed'
    And user click on Sign in button
    Then message about an incorrect username or password is displayed