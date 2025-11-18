# User Story-k (Sprint 2)

## US-01 – Üres karakterlista megjelenítése
**Mint** felhasználó  
**azt szeretném**, hogy lássam ha még nincs egyetlen karakterem sem  
**azért**, hogy tudjam, mit kell tennem első lépésként.

### AC-k:
- AC1: Üres lista esetén „Nincs még karakter” jelenik meg.
- AC2: Látható a CTA: „Hozz létre egy új karaktert”.

---

## US-02 – Karakter létrehozó oldal megnyitása
**Mint** felhasználó  
**azt szeretném**, hogy megnyithassam az új karakter létrehozó oldalát  
**azért**, hogy elkezdhessem a karakter kitöltését.

### AC-k:
- AC1: A CTA-ra kattintva /create-character oldalra navigál.
- AC2: A karakter űrlap megjelenik.

---

## US-03 – Érvényes karakter létrehozása
**Mint** felhasználó  
**azt szeretném**, hogy egy új karaktert hozhassak létre  
**azért**, hogy elkezdhessem az Anima játékbeli szereplőm felépítését.

### AC-k:
- AC1: Kötelező mezők kitöltése után POST /api/characters hívás történik.
- AC2: A backend 200 OK válasszal reagál.
- AC3: A karakter megjelenik a listában.

---

## US-04 – Hibakezelés érvénytelen bevitel esetén
**Mint** felhasználó  
**azt szeretném**, hogy a rendszer figyelmeztessen a hiányzó adatokra  
**azért**, hogy helyesen tudjam kitölteni az űrlapot.

### AC-k:
- AC1: Üres „name” mező esetén piros hibaüzenet jelenik meg.
- AC2: Nincs backend POST kérés.

---

## US-05 – Létrehozott karakter visszajelzése
**Mint** felhasználó  
**azt szeretném**, hogy sikeres mentés után visszakerüljek a listára  
**azért**, hogy lássam a létrehozott karakteremet.

### AC-k:
- AC1: Sikeres mentés után lista oldalra navigál.
- AC2: Az új karakter azonnal látható.
