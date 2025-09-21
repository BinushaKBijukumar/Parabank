Feature: User Registration

  Scenario: Successful user registration
    Given User is on the registration page
    When User enters registration details
      | firstName | Binusha     |
      | lastName  | Bijukumar   |
      | address   | 123 Main St |
      | city      | Chennai     |
      | state     | TN          |
      | zipCode   | 11111       |
      | phone     | 9876543210  |
      | ssn       | 123-45-6789 |
      | username  | Binusha900  |
      | password  | 303030      |
    And Clicks on register
    Then User should see registration message "Welcome Binusha900"
