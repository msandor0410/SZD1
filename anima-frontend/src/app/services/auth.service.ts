import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private http = inject(HttpClient);
  private router = inject(Router);

  private API_URL = 'http://localhost:8080/api/auth';

  login(username: string, password: string) {
    return this.http
      .post<{ token: string; userId: number; username: string }>(
        `${this.API_URL}/login`,
        { username, password }
      )
      .pipe(
        tap((res) => {
          localStorage.setItem('auth_token', res.token);
          localStorage.setItem('user_id', res.userId.toString());
          localStorage.setItem('username', res.username);
        })
      );
  }

  register(username: string, email: string, password: string) {
    return this.http.post(`${this.API_URL}/register`, {
      username,
      email,
      password,
    });
  }

  logout() {
    localStorage.removeItem('auth_token');
    localStorage.removeItem('user_id');
    localStorage.removeItem('username');
    this.router.navigate(['/login']);
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('auth_token');
  }
}
