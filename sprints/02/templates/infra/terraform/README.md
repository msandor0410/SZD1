# Terraform – Sprint 2 (Plan-Only)

Ez a könyvtár egy minimális Terraform konfigurációt tartalmaz, amely teljesíti a Sprint 2 követelményeit.

## Tartalom
- `main.tf` – null_resource deklaráció
- `providers.tf` – null provider
- `variables.tf` – üres változófájl
- Nincs `apply`, csak `validate` + `plan`

## Futás
```
terraform init
terraform validate
terraform plan -out=plan.out
```

## Miért így?
- Gyors CI futás
- Nincs szükség valós infrastruktúrára
- A Sprint 2 követelményei szerint elegendő
