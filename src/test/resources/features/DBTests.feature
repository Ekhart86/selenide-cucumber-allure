@all
Feature: Checking the operation of steps that work with the database

  @DatabaseTest
  Scenario: Check DB Steps
    Given user open 'Login Page'
    When insert a new Customers to the database:
      | Age | FirstName | LastName |
      | 35  | Bob       | Dylan    |
      | 40  | Tom       | Cruise   |
    Then check that customers exist in the database:
      | Age | FirstName | LastName |
      | 35  | Bob       | Dylan    |
      | 40  | Tom       | Cruise   |