@user
Feature: Create User

  @createUser
  Scenario: Create user scenario
    Given set the url for user creation
    And set the expected data for user creation
    When send the post request for user creation and get the response
    Then do assertion for user creation