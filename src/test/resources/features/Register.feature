Feature: As a user I want to register on portal so that I can access the portal

  Scenario Outline: User is successfully able to register
    Given I am on registration page
    When I make a registration
      | title   | firstName   | lastName   | address   | password   | city   | postCode   | state   | phone   |
      | <title> | <firstName> | <lastName> | <address> | <password> | <city> | <postCode> | <state> | <phone> |
    Then Registration should be successful
    Examples:
      | title | firstName | lastName | address          | password   | city  | postCode | state  | phone      |
      | Mrs    | Rahul     | Sharma   | Abc, Port Valley | Apple@789! | Delhi | 11002   | Alaska | 9922335566 |


