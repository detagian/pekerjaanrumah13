@webui
Feature: Login

  @valid-login
  @positive
  Scenario: Login using valid email and password
    Given user is on login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    When user click login button
    Then user is on homepage

  @invalid-login
  @negative
  Scenario: Login using invalid email and password
    Given user is on login page
    And user input username "standard_user"
    And user input password "wrong_password"
    When user click login button
    Then user see error massage "Epic sadface: Username and password do not match any user in this service"

  @sort-list-item-by-character
  @positive
  Scenario: Sort item by character descendingly
    Given user is on login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click login button
    And user is on homepage
    When user click sort item by character descending
    Then item is sorted descendingly by character

@PromoUnder50Dollar
@positive
  # BoundariesCase: assume all items price must be between $0-$50
  Scenario: All product price must be under 50 Dollar
  Given user is on login page
  And user input username "standard_user"
  And user input password "secret_sauce"
  And user click login button
  When user is on homepage
  Then user see all items price is under $50 dollar