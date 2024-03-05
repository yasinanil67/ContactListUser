@rx_drug_e2e
Feature: Get User By Id
  @rx_drug_api
  Scenario: Get User By Id Api
    Given set the url for getting user
    And set the expected data for getting user
    When send the get request and get the response
    Then assert response body