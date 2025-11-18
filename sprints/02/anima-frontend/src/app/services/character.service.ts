import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CharacterService {

  private API = 'http://localhost:8080/api/characters';

  constructor(private http: HttpClient) {}

  private headers() {
    const token = localStorage.getItem('auth_token') ?? '';
    const userId = localStorage.getItem('user_id') ?? '0';

    const headers: any = {};
    if (token) {
      headers['Authorization'] = `Bearer ${token}`;
    }
    if (userId) {
      headers['userId'] = userId;
    }

    return { headers };
  }

  getMyCharacters(): Observable<any[]> {
    return this.http.get<any[]>(this.API, this.headers());
  }

  createCharacter(data: any): Observable<any> {
    return this.http.post(this.API, data, this.headers());
  }

  getCharacter(id: number): Observable<any> {
    return this.http.get(`${this.API}/${id}`, this.headers());
  }

  updateCharacter(id: number, data: any): Observable<any> {
    return this.http.put(`${this.API}/${id}`, data, this.headers());
  }

  deleteCharacter(id: number): Observable<any> {
    return this.http.delete(`${this.API}/${id}`, this.headers());
  }
}
