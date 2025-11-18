import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CharacterService } from '../../services/character.service';

@Component({
  selector: 'app-edit-character',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './edit-character.component.html',
  styleUrls: ['./edit-character.component.scss']
})
export class EditCharacterComponent implements OnInit {

  model: any = {};

  constructor(
    private route: ActivatedRoute,
    private service: CharacterService,
    private router: Router
  ) {}

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.service.getCharacter(id).subscribe(c => this.model = c);
  }

  save() {
    this.service.updateCharacter(this.model.characterId, this.model)
      .subscribe(() => this.router.navigate(['/character', this.model.characterId]));
  }

  cancel() {
    this.router.navigate(['/dashboard']);
  }
}
