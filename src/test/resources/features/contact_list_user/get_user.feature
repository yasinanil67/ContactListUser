@user
Feature: Get user

  @readUser
  Scenario: Get user scenario
    Given set the url for reading user
    And set the expected data for reading user
    When send the post request for reading user and get the response
    Then do assertion for reading user