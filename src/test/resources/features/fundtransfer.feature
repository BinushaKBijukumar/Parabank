@LoginRequired
Feature: Fund Transfer
  Scenario: Successful fund transfer
    When User navigates to the fund transfer page
    And User enters amount "50" and selects accounts automatically
    And Clicks on submit transfer
    Then User should see "Transfer Complete!" message
