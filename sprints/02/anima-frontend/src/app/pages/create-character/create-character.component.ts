import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CharacterService } from '../../services/character.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-character',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './create-character.component.html',
  styleUrls: ['./create-character.component.scss']
})
export class CreateCharacterComponent {

  model: any = {
    name: '',
    className: '',
    race: '',
    gender: '',
    level: 1,
    // kötelező statok
    strScore: 0,
    agiScore: 0,
    dexScore: 0,
    conScore: 0,
    intScore: 0,
    perScore: 0,
    powScore: 0,
    wpScore: 0,
  };

  constructor(private service: CharacterService, private router: Router) {}

  save() {
    this.service.createCharacter(this.model).subscribe({
      next: () => this.router.navigate(['/dashboard']),
      error: (err) => console.log(err)
    });
  }

  cancel() {
    this.router.navigate(['/dashboard']);
  }
}
