import { Component, OnInit } from '@angular/core';
import { CharacterService } from '../../api/character/service/character.service';
import { Profession } from '../../api/profession/model/profession';
import { Character } from '../../api/character/model/character';
import { ProfessionService } from '../../api/profession/service/profession.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';
import { CharacterFormComponent } from '../../component/character-form/character-form.component';

@Component({
  selector: 'app-edit-character-view',
  standalone: true,
  imports: [ViewTitleComponent, ErrorMessageComponent, CharacterFormComponent],
  templateUrl: './edit-character-view.component.html',
  styleUrl: './edit-character-view.component.css',
})
export class EditCharacterViewComponent implements OnInit {
  constructor(
    private characterService: CharacterService,
    private professionService: ProfessionService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  character: Character | undefined;
  profession: Profession | undefined;
  message: string = '';

  ngOnInit(): void {
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

  onSubmit(): void {
    this.message = '';
    if (this.character) {
      this.characterService.updateCharacter(this.character).subscribe({
        next: (character) => {
          this.router.navigate([
            '/professions',
            this.profession?.id,
            'characters',
            character.id,
          ]);
        },
        error: (error) => {
          this.message = error.error.message;
        },
      });
    }
  }
}
