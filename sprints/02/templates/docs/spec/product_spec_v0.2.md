# Product Spec v0.2

## Cél
A Sprint 2 célja egy teljes, függőleges MVP-szelet leszállítása az Anima Character Manager rendszerhez:  
**„Új karakter létrehozása bejelentkezett felhasználóként.”**

Ez a szelet bizonyítja, hogy a felhasználó képes a rendszeren belül egy érvényes karaktert létrehozni, azt a backend eltárolja, és a folyamat végén a karakter meg is jelenik a listában.  
Az MVP a következő értéket adja: a rendszer működőképes alapfunkcióval rendelkezik, amelyre a további fejlesztés építhető.

---

## Scope (In/Out)

### **In Scope (Sprint 2)**
- `/create-character` képernyő működő Angular űrlappal  
- Kötelező mezők validációja és felhasználói visszajelzés  
- POST kérés küldése a backend felé (`POST /api/characters`)  
- `userId` header kezelése  
- Backend oldali karakterlétrehozás és MySQL perzisztencia (Docker)  
- Smoke teszt: `GET /api/characters` → 200 OK  
- Terraform minimal „plan-only” futtatás  
- User Storyk + AC-k + két automatizált Gherkin teszt

### **Out of Scope**
- Karakter módosítás  
- Karakter törlés  
- Bejelentkezési folyamat  
- Jogosultsági rendszer  
- Admin funkciók  
- Frontend UI finomhangolása  
- Production deploy  
- Teljesítménytesztek

---

## User Story térkép
- **US-01:** Üres karakterlista megjelenítése felhasználónak  
- **US-02:** „Új karakter létrehozása” oldal megnyitása  
- **US-03:** Érvényes karakter űrlap beküldése → új karakter létrejön  
- **US-04:** Érvénytelen űrlap beküldése → hibaüzenet  
- **US-05:** Sikeres mentés után a karakter megjelenik a listában

---

## NFR-ek (mérhetők)
- **NFR-1:** TTFB < 1.5s dev-preview környezetben (Angular + Spring Boot)  
- **NFR-2:** Smoke teszt sikerarány a CI-ben ≥ 95%  
- **NFR-3:** A backend minden válasza JSON formátumú  
- **NFR-4:** Teszt lefedettség ≥ 60% (line coverage)  
- **NFR-5:** `terraform validate` és `terraform plan` hiba nélkül lefut

---

## Fő AC-k (Given–When–Then)

### **AC-01 — Üres állapot**
Given a felhasználónak nincs még karaktere
When betölt a karakterlista
Then megjelenik: „Nincs még karakter”
And látható a CTA: „Hozz létre egy új karaktert”


### **AC-02 — Karakter létrehozó oldal megnyitása**


Given az üres lista látható
When a felhasználó rákattint a „Új karakter” gombra
Then az alkalmazás a /create-character oldalra navigál
And megjelenik a karakter űrlap


### **AC-03 — Érvényes karakter létrehozása**


Given a felhasználó a /create-character oldalon van
When minden kötelező mezőt helyesen kitölt
And rákattint a „Mentés” gombra
Then a frontend POST kérést küld a http://localhost:8080/api/characters
 címre
Headerrel: userId
És érvényes JSON adattal
And a backend 200 OK választ ad
And az alkalmazás visszanavigál a karakterlistára
And az új karakter megjelenik a listában


### **AC-04 — Érvénytelen bevitel**


Given a felhasználó üresen hagyja a „name” mezőt
When rákattint a „Mentés” gombra
Then a rendszer piros hibaüzenetet jelenít meg: „A név megadása kötelező”
And nem küldődik POST kérés a backend felé


---

## Komponens áttekintés

### **Frontend**
- Angular 17
- Route: `/create-character`
- HttpClient POST `/api/characters`
- `ng serve` preview környezet

### **Backend**
- Spring Boot 3
- Controller: `CharacterController`
- Endpoint: `POST /api/characters`
- Header: `userId: <id>`
- DB: MySQL Docker container

---

## Kockázatok & Mitigációk

| Kockázat | Mitigáció |
|---------|-----------|
| A backend `userId` headert igényel → ha hiányzik: 403 | Frontenden kötelezően megadjuk |
| A CharacterRequest túl nagy → automatizált AC nehezen stabil | MVP csak minimális mezőt használ |
| Nincs `/health` végpont | Smoke teszt a `GET /api/characters`-re épül |

---

## Definition of Done (DoD)

- Minden meghatározott AC teljesül  
- Min. 2 automatizált AC teszt (Gherkin)  
- Legalább 5 sikeres teszt  
- ≥ 60% tesztlefedettség  
- Terraform: validate + plan OK  
- Smoke teszt OK  
- PR létrehozva képernyőképekkel, riportokkal  
- CI minden lépése zöld 