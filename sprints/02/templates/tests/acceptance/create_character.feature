Feature: Érvényes karakter létrehozása

  Scenario: Sikeres karaktermentés
    Given a felhasználó a /create-character oldalon van
    When minden kötelező mezőt helyesen kitölt
    And rákattint a "Mentés" gombra
    Then a rendszer POST kérést küld a http://localhost:8080/api/characters címre
    And a válasz 200 OK
    And az új karakter megjelenik a listában
