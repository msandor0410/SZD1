# ADR 0002 – IaC stratégia (Terraform Plan-Only)

## Kontextus
A kurzus Sprint 2 követelményei alapján Terraform használata szükséges,
de csak a `validate` és `plan` lépések futtatása kötelező, az `apply` nem.

## Döntés
A Terraform konfiguráció **minimális plan-only** jellegű lesz:
- Provider definíció (pl. `null`, `local`)
- Egy darab `null_resource`
- `terraform validate` és `terraform plan` sikeresen lefut

## Indoklás
- A projekt jelenleg nem igényel valós infrastruktúrát
- A plan-only megoldás megfelel a tananyag követelményeinek
- A CI-ben gyors és determinisztikus futás biztosítható

## Alternatívák
- GCP / AWS / Azure valós erőforrások → túl nagy többletterhelés
- Docker Compose orchestráció Terraformmal → túl komplex
- Kubernetes objektumok → nem releváns a projekt méretéhez

## Következmények
- A Terraform nem hoz létre valós erőforrást
- Megteremti a jövőbeli IaC bővítés alapját
- A CI „Infrastructure as Code” ellenőrzése teljesül
