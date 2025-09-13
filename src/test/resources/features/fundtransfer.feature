Feature: Fund Transfer

  Scenario: Successful fund transfer
    When User navigates to the fund transfer page
    And User enters amount "5" and selects from account "16785" to account "17007"
    And Clicks on submit transfer
    Then User should see "Transfer Complete!" message
