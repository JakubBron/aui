import { Component, OnInit } from '@angular/core';
import { CharacterService } from '../../api/character/service/character.service';
import { Character } from '../../api/character/model/character';
import { ActivatedRoute } from '@angular/router';
import { Profession } from '../../api/profession/model/profession';
import { ProfessionService } from '../../api/profession/service/profession.service';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { MatCardModule } from '@angular/material/card';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';

@Component({
  selector: 'app-character-details-view',
  standalone: true,
  imports: [
    ViewTitleComponent,
    MatCardModule,
    RouterLink,
    MatButtonModule,
    ErrorMessageComponent,
  ],
  templateUrl: './character-details-view.component.html',
  styleUrl: './character-details-view.component.css',
})
export class CharacterDetailsViewComponent implements OnInit {
  constructor(
    private characterService: CharacterService,
    private professionService: ProfessionService,
    private route: ActivatedRoute
  ) {}

  message: string = '';
  profession: Profession | undefined;
  character: Character | undefined;

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.characterService.getCharacterById(params['characterId']).subscribe({
        next: (character) => {
          this.character = character;
        },
        error: (error) => {
          this.message = error.error.message;
        },
      });
      this.professionService.getProfessionById(params['professionId']).subscribe({
        next: (profession) => {
          this.profession = profession;
        },
        error: (error) => {
          this.message = error.error.message;
        },
      });
    });
  }
}
