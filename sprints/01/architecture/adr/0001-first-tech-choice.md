# 0001 – Kezdeti tech stack: Angular + Spring Boot + MySQL

- **Dátum:** 2025-10-13  
- **Státusz:** Elfogadva  

## Kontextus
Az **Anima Character Builder** szakdolgozati projekt célja egy gyorsan kipróbálható, stabil webes prototípus létrehozása, amely támogatja a karakteralkotás folyamatát az *Anima: Beyond Fantasy* rendszerhez. A rendszer összetett, relációs jellegű szabályfüggőségeket kezel (előfeltételek, értékek, kapcsolódó entitások), így **SQL-alapú adatmodell** szükséges.  
A korábbi egyetemi tapasztalatok alapján (Spring + SQL, Webes keretrendszerek tárgy) a **Spring Boot + MySQL** megoldás biztos hátteret nyújt a fejlesztéshez.

## Döntés
- **Frontend:** Angular 18 + Angular Material / CDK  
  - Állapotkezelés: RxJS (+ Signals Store opcionálisan)  
  - Auth token kezelés: HttpInterceptor (Bearer JWT)
- **Backend:** Spring Boot 3 (Java 21)  
  - Spring Web (REST), Spring Security (JWT, stateless), Spring Data JPA (Hibernate), Bean Validation (Jakarta)  
  - Objektum-térkép: MapStruct  
  - Migrációk: **Flyway**
- **Adatbázis:** **MySQL 8** (lehetőség későbbi váltásra PostgreSQL-re)  
  - JSON mezők a rugalmas részekhez (pl. előfeltételek, DP-history)
- **Export/PDF:** OpenPDF / Flying Saucer (HTML→PDF) szerveroldalon  
- **CI/CD:** Maven + GitHub Actions (build, tesztek, Flyway migrációk)  
- **Megfigyelés:** Spring Boot Actuator, Sentry/ELK (későbbi fejlesztés)  
- **Fejlesztői környezet:** Docker Compose (MySQL + Adminer + API)

## Megfontolt alternatívák
- **Angular + Firebase (Firestore):** gyorsan fejleszthető, de a nem relációs adatmodell miatt az összetett szabályfüggőségek kezelése nehézkes.  
- **Laravel 11 + PostgreSQL:** PHP-alapú alternatíva, ismerős ökoszisztéma, de jelen projektben a Java környezet a preferált.  
- **NestJS + PostgreSQL:** egységes TypeScript ökoszisztéma, modern fejlesztői élmény, de új stack tanulását igényelné.  
- **Next.js + PostgreSQL:** SSR/ISR előnyei miatt hosszabb távon érdekes lehet, de az MVP célokhoz túlságosan összetett.

## Következmények

### Előnyök
- Erős **relációs modell**, amely természetesen leképezi a karakteralkotási folyamat kapcsolatait és előfeltételeit (JOIN, CTE).  
- Jó **tesztelhetőség** és rétegezett szerkezet (Controller–Service–Repository), ami átlátható kódot eredményez.  
- **Flyway** migrációk segítségével kontrollált adatbázis-fejlődés, könnyű visszagörgetés és reprodukálhatóság.

### Hátrányok
- Több komponens futtatása (API + DB) a Firebase-hez képest bonyolultabb.  
- **Realtime funkciók** (pl. KM-nézet) külön kommunikációs csatornát igényelnek (WebSocket/STOMP vagy SSE).  
- A **PostgreSQL** a jövőben hatékonyabb lehet JSON-alapú és rekurzív lekérdezésekhez, így esetleg szükség lehet adatbázisváltásra.

## Nem-célok (az MVP-ben nincsenek)
- Natív mobilalkalmazás (iOS/Android)  
- Teljes ABF szabálykönyv integrálása (jogi és terjedelmi okok miatt)  
- Party-szintű, valós idejű együttműködés vagy KM-nézet (későbbi fejlesztési fázis)

## Implementációs jegyzetek
- **Alap entitások:**  
  `users`, `characters`, `attributes (1:1)`,  
  `skills` + `character_skills (N:M)`,  
  `techniques (type: KI|PSI|MAGIC, prerequisites JSON)`,  
  `character_techniques (N:M)`,  
  `history_logs (dp_spent JSON)`,  
  `validations (status: OK|WARN|ERROR)`  
- **Tipikus végpontok:**  
  `POST /auth/register|login` (JWT)  
  `GET/POST /characters`, `GET/PUT/DELETE /characters/{id}`  
  `POST /characters/{id}/calculate` (DerivedStats + ValidationResults)  
  `GET /characters/{id}/history`  
  `POST /characters/{id}/export/pdf`  
- **Biztonság:** stateless JWT; felhasználónként elkülönített erőforrás-hozzáférés  
- **Fejlesztés:** Docker Compose (MySQL + Adminer + API), teszteléshez Testcontainers MySQL

## Migrációs megfontolás
Ha a szabálymotor komplexebbé válik (rekurzív lekérdezések, JSONB indexelés, fejlettebb riportok), a projekt később könnyen átállítható **PostgreSQL-re**, mivel a JPA/Hibernate réteg adatbázisfüggetlen marad.
