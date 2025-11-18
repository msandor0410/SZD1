import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { CharacterService } from '../../services/character.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  private auth = inject(AuthService);

  username: string = '';
  characters: any[] = [];

  constructor(private cs: CharacterService, private router: Router) {}

  ngOnInit() {
    this.username = localStorage.getItem('username') ?? '';

    this.cs.getMyCharacters().subscribe({
      next: (chars) => this.characters = chars,
      error: (err) => console.error('Get characters error:', err)
    });
  }

  logout() {
    this.auth.logout();
  }

  goCreate() {
    this.router.navigate(['/create-character']);
  }

  view(id: number) {
    this.router.navigate(['/character', id]);
  }

  delete(id: number) {
    this.cs.deleteCharacter(id).subscribe(() => {
      this.characters = this.characters.filter(c => c.characterId !== id);
    });
  }
}
