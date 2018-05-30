Feature: validate register user

  Scenario: navigation to singin page
    Given i am on home page
    When  i click on sing in
    Then  i should navigate to login page

  Scenario Outline: weather page fuctionality

    Given i am on home page
    When  i click on weatherlink
    Then  I should navigate to weather page
    And   I search for city "<City>"
    Then  I should get weather report
    Examples:
    |City|
    |Ahmedabad|



  Scenario: news page fuctionality

    Given i am on home page
    When  i click on newslink
    Then  I should navigate to news page

  Scenario: sport page fuctionality

    Given i am on home page
    When  i click on sportslink
    Then  I should navigate to sport page

  Scenario Outline: register as a new user
    Given I am on singin page
    When  I click on register
    Then  I should navigate to register page
    And   I confirm my age
    And   I enter my age as "<day>" and "<month>"and "<year>"
    And   I enter my email as "<email>" and password as "<password>" and postcode"<postcode>"

    Examples:
      | day | month | year | email                      | password  | postcode |
      | 09  | 09    | 1985 | vishal_manu@yahoo.co.in    | somnath09 | ha9 9eu  |
      | 08  | 09    | 1987 | nisha_ghinaiya@yahoo.co.in | somnath09 | ha0 2hd  |
      | 10  | 11    | 1982 | priyal_patel@yahoo.co.in   | somnath09 | ha0 3db   |
      | 09  | 10    | 1985 | ankit_jagani@yahoo.co.in   | somnath09 | ha0 3db   |