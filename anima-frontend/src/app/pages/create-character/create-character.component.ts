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

  races = [
    'Human',
    'Sylvain',
    'Jayan',
    "D'Anjayni",
    'Ebudan',
    'Daimah',
    "Duk'zarist"
  ];

  model: any = {
    name: '',
    className: '',
    race: '',
    gender: '',
    level: 1,
    appearance: 0,
    size: 0,
    heightCm: 0,
    weightKg: 0,
    background: '',
    developmentPoints: 0,

    // primary
    strScore: 0,
    agiScore: 0,
    dexScore: 0,
    conScore: 0,
    intScore: 0,
    perScore: 0,
    powScore: 0,
    wpScore: 0,

    // derived
    lifePoints: 0,
    lifePointMultiple: 1,
    initiative: 0,
    fatigue: 0,
    attackBase: 0,
    defenseBase: 0,
    movement: 0,

    // athletics
    athletics: 0,
    acrobatics: 0,
    athleticism: 0,
    climb: 0,
    jump: 0,
    ride: 0,
    swim: 0,

    // vigor
    vigor: 0,
    composure: 0,
    featsOfStrength: 0,
    withstandPain: 0,

    // perception
    perception: 0,
    notice: 0,
    searchSkill: 0,
    track: 0,

    // intellectual
    intellectual: 0,
    animals: 0,
    appraisal: 0,
    memorize: 0,
    herbalLore: 0,
    historySkill: 0,
    magicAppraisal: 0,
    medicine: 0,
    navigation: 0,
    occult: 0,
    sciences: 0,

    // social
    social: 0,
    intimidate: 0,
    leadership: 0,
    persuasion: 0,
    style: 0,

    // subterfuge
    subterfuge: 0,
    disguise: 0,
    hideSkill: 0,
    lockPicking: 0,
    poisons: 0,
    theft: 0,
    stealth: 0,
    trapLore: 0,

    // creative
    creative: 0,
    art: 0,
    dance: 0,
    forging: 0,
    music: 0,
    sleightOfHand: 0,
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
