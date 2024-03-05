Feature: LoginFeature

  Scenario: Check Login
    And The application opens up
    When I enter the username and password
      | Username  | Password    |
      | darius112 | darius12345 |
    Then I click the login button
    Then Home page opens up
