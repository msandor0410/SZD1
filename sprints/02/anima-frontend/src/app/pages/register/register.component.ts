import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent {
  username = '';
  email = '';
  password = '';
  successMessage = '';
  errorMessage = '';

  private auth = inject(AuthService);
  private router = inject(Router);

  onRegister() {
    this.auth.register(this.username, this.email, this.password)
      .subscribe({
        next: () => {
          this.successMessage = 'Sikeres regisztráció! Most már bejelentkezhetsz.';
          setTimeout(() => this.router.navigate(['/login']), 1500);
        },
        error: err => {
          if (err.status === 409) {
            this.errorMessage = 'A felhasználónév vagy email már létezik!';
          } else {
            this.errorMessage = 'Hiba történt a regisztráció során.';
          }
        }
      });
  }
}
