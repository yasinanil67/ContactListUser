@user
Feature: Delete User

  @deleteUser
  Scenario: Delete User Scenario
    Given set the url for deleting user
    When send the delete request for deleting user and get the response
    Then do assertion for deleting user

