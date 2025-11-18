# ADR 0001 – Platform döntés (Local Preview)

## Kontextus
A projekt jelenlegi állapotában az Angular frontend és a Spring Boot backend is fejlesztői gépen fut.  
A MySQL adatbázis Docker-konténerben érhető el.  
A cél egy stabil, könnyen reprodukálható preview környezet biztosítása fejlesztéshez és CI smoke tesztekhez.

## Döntés
A Sprint 2 során **lokális preview környezetet** használunk:
- Angular: `http://localhost:4200`
- Backend (Spring Boot): `http://localhost:8080`
- MySQL Docker konténer: `mysql:latest`

## Indoklás
- Gyorsabb iteráció
- Könnyebb hibakeresés
- Nincs szükség külső hostingra vagy deploy-ra
- A CI így is képes smoke tesztet futtatni

## Alternatívák
- Firebase Hosting → túl korai, nincs kész build pipeline
- Vercel → csak frontend, backendre nem alkalmas
- VM-es deploy → magas üzemeltetési többlet
- Docker Compose teljes stackkel → a sprint fókuszától eltér

## Következmények
- A preview környezet nem publikus
- A smoke teszt a lokális backend elérhetőségét ellenőrzi
- Későbbi sprintekben szükség lesz egy valódi deploy környezetre
