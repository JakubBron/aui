import { Component, OnInit } from '@angular/core';
import { ProfessionService } from '../../api/profession/service/profession.service';
import { Profession } from '../../api/profession/model/profession';
import { ActivatedRoute } from '@angular/router';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { RouterLink } from '@angular/router';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { Characters } from '../../api/character/model/characters';
import { CharacterService } from '../../api/character/service/character.service';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';

@Component({
  selector: 'app-profession-details-view',
  standalone: true,
  imports: [
    ViewTitleComponent,
    MatCardModule,
    MatButtonModule,
    RouterLink,
    MatListModule,
    MatIconModule,
    ErrorMessageComponent,
  ],
  templateUrl: './profession-details-view.component.html',
  styleUrl: './profession-details-view.component.css',
})
export class ProfessionDetailsViewComponent implements OnInit {
  constructor(
    private professionService: ProfessionService,
    private characterService: CharacterService,
    private route: ActivatedRoute
  ) {}

  message: string = '';
  profession: Profession | undefined;
  characters: Characters | undefined;

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.professionService.getProfessionById(params['id']).subscribe({
        next: (profession: Profession) => {
          this.profession = profession;
          this.fetchCharacters();
        },
        error: (error) => {
          this.message = error.error.message;
        },
      });
    });
  }

  fetchCharacters(): void {
    if (this.profession) {
      this.characterService.getCharactersByProfessionId(this.profession.id).subscribe({
        next: (characters: Characters) => {
          this.characters = characters;
        },
        error: (error) => {
          this.message = error.error.message;
        },
      });
    }
  }

  deleteCharacter(id: string): void {
    this.characterService.deleteCharacter(id).subscribe(() => {
      this.fetchCharacters();
    });
  }
}
