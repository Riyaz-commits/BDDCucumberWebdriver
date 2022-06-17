Feature: As a user I want to sign out on portal so that I can log off

  Scenario: Working Sign In And Sign Out
    Given I am signed into my Account
    When I sign out
    Then Sign out should be successful