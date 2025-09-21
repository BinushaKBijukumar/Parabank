Feature: User Registration

  Scenario: Successful user registration
    Given User is on the registration page
    When User enters registration details
      | firstName | John        |
      | lastName  | Doe         |
      | address   | 123 Main St |
      | city      | New York    |
      | state     | NY          |
      | zipCode   | 10001       |
      | phone     | 9876543210  |
      | ssn       | 123-45-6789 |
      | username  | john1    |
      | password  | test123     |
    And Clicks on register
    Then User should see registration message "Welcome john1"
