Feature: LoginFeature
  This feature is responsible for testing all the scenarios for Login of application

  Scenario: Check Login with correct username and password
    And I ensure application opened
    Then  I click the signUp link
    When I enter the signUp data
    When I enter Username and Password
      | Username | Password |
      | darius112    | darius12345 |
    Then I click login button
    Then I should see the username with hello