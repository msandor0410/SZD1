# S2 – MVP szelet + Spec v0.2 + ADR + IaC plan

## Rövid összefoglaló
A Sprint 2 keretében elkészült az MVP vertikális szelete:
- Új karakter létrehozása
- Angular UI → Spring Boot backend → MySQL perzisztencia
- Hibakezelés és validáció
- AC-k lefedése automatizált tesztekkel

## Fő artefaktumok
- Spec v0.2
- User Storyk + AC-k
- 2 Gherkin acceptance teszt
- 2 ADR (platform + IaC)
- Terraform plan-only konfiguráció
- Smoke teszt (GET /api/characters)
- Tesztek + coverage riport
- Traceability mátrix
- Wireframe dokumentáció
- AI log

## Jelentések
- `reports/junit.xml`
- `reports/coverage.xml`
- Terraform: `terraform plan -out=plan.out`

## Képernyőképek / GIF
(Ide illeszd be majd a screenshotokat a UI-ról)

## Known Issues
- Validáció további finomítása szükséges
- Egységteszt lefedettség bővíthető

## Next Steps
- Karakter szerkesztés
- Karakter törlés
- Autentikáció integrálása
