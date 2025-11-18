Feature: Create a new character

  Scenario: Successful character creation
    Given the user is on the "/create-character" page
    When the user fills all required fields with valid values
    And the user clicks the "Save" button
    Then the system sends a POST request to "http://localhost:8080/api/characters"
    And the server responds with status 200
    And the newly created character appears in the character list
