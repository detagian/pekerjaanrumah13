@api-test
Feature: Api Test

  Scenario: get valid total users per page
    Given I set service api
    When I set Header method GET using Endpoint "/users?page=2"
    Then I received a valid HTTP response code 200
    And I received a valid total 12 user
    And I received a valid "getListUsersScheme.json"

  Scenario: valid user credentials
    Given I set service api
    When I set Email value "eve.holt@reqres.in"
    And I set Password value "cityslicka"
    And I set Header method POST using Endpoint "/login"
    Then I received a login response
    And I received a valid HTTP response code 200
    And I received a valid "LoginSuccessfullyScheme.json"

  Scenario: invalid user credentials
    Given I set service api
    When I set Email value "wrongusers@reqres.in"
    And I set Password value "cityslicka"
    And I set Header method POST using Endpoint "/login"
    Then I received a login response
    And I received a valid HTTP response code 400
    And I received a valid "LoginInvalidUsersScheme.json"
