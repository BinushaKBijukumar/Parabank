Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters username "Binusha122" and password "303030"
    And Clicks on login button
    Then User should be navigated to the dashboard
