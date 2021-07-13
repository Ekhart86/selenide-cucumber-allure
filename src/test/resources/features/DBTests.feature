@all
Feature: Check that the database requests is working correctly

  @DB
  Scenario: Checking Customers table in the database
    When insert a new Customers to the database:
      | Age | FirstName | LastName |
      | 35  | Bob       | Dylan    |
      | 40  | Tom       | Cruise   |
    Then check that customers exist in the database:
      | Age | FirstName | LastName |
      | 35  | Bob       | Dylan    |
      | 40  | Tom       | Cruise   |
    When remove customers from the database:
      | Age | FirstName | LastName |
      | 35  | Bob       | Dylan    |
      | 40  | Tom       | Cruise   |
    Then check that customers absent in the database:
      | Age | FirstName | LastName |
      | 35  | Bob       | Dylan    |
      | 40  | Tom       | Cruise   |