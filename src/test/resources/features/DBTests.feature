@all
Feature: Check correct working with the database

  @DB
  Scenario: Check DB CRUD Operation
    When insert a new Customers to the database:
      | Age | FirstName | LastName |
      | 35  | Bob       | Dylan    |
      | 40  | Tom       | Cruise   |
    Then check that customers exist in the database:
      | Age | FirstName | LastName |
      | 35  | Bob       | Dylan    |
      | 40  | Tom       | Cruise   |