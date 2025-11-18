terraform {
  required_providers {
    null = {
      source = "hashicorp/null"
      version = "~> 3.2"
    }
  }
}

provider "null" {}

resource "null_resource" "preview_check" {
  triggers = {
    run_id = timestamp()
  }
}
