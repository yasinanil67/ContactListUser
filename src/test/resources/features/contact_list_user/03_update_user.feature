@user
Feature: Update User

  @updateUser
  Scenario: Update User Scenario
    Given set the url for updating user
    And set the expected data for updating user
    When send the patch request for updating user and get the response
    Then do assertion for updating user
