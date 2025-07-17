@getPetIdTest

Feature: Retrieve pet information by ID

  Scenario Outline: Successful retrieval of pet information by valid ID
    Given I set the pet id to <id>
    When I send a GET request to the Petstore API
    Then the response should be <statusCode>,<petName>
    Examples:
      | id | petName | statusCode |
      | 1  | "dog"   | 200        |
