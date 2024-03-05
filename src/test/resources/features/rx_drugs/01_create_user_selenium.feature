@rx_drug_e2e
Feature: Create User

  @rx_drug_selenium
  Scenario: Create User via Selenium
    Given user goes to "https://qa-gm3.quaspareparts.com/a3m/#/users"
    When user enters email and password and click on sign in
    And user clicks on Users Link
    And user clicks on Register New User Link
    And user selects role
    And user enters email for user
    And user clicks on Register button
    Then user verifies success message
    And user closes browser



