@all
Feature: Check that the API requests is working correctly

  @API
  Scenario: Checking API requests
  When get all posts via API call
  Then posts list has size 100

  @API
  Scenario: Checking API requests with query param
    When get all posts with userId 3 via API call
    Then all posts have userId 3