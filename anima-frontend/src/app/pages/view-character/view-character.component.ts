import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CharacterService } from '../../services/character.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-view-character',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './view-character.component.html',
  styleUrls: ['./view-character.component.scss']
})
export class ViewCharacterComponent implements OnInit {

  character: any;

  constructor(
    private route: ActivatedRoute,
    private service: CharacterService,
    private router: Router
  ) {}

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.service.getCharacter(id).subscribe(c => this.character = c);
  }

  edit(id: number) {
    this.router.navigate(['/character', id, 'edit']);
  }

  back() {
    this.router.navigate(['/dashboard']);
  }
}
