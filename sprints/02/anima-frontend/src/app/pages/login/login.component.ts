import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  username = '';
  password = '';
  errorMessage = '';

  private auth = inject(AuthService);
  private router = inject(Router);

  onLogin() {
    this.auth.login(this.username, this.password).subscribe({
      next: () => {
        this.router.navigate(['/dashboard']);
      },
      error: () => (this.errorMessage = 'Hibás bejelentkezés!'),
    });
  }
}
