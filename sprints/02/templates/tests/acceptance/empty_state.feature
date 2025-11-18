Feature: Karakter létrehozás üres állapotból

  Scenario: Üres állapot megjelenítése
    Given a felhasználónak nincs karaktere
    When megnyitja a karakterlista oldalt
    Then megjelenik a "Nincs még karakter" üzenet
    And látható a "Hozz létre egy új karaktert" gomb
