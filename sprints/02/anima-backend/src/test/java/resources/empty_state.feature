Feature: Display empty character list

  Scenario: User sees empty list when no characters exist
    Given the user has no characters
    When the user opens the character list page
    Then the system shows the message "No characters yet"
    And the button "Create New Character" is visible
