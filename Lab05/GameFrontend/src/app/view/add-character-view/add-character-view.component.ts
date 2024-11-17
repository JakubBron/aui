import { Component, OnInit } from '@angular/core';
import { ProfessionService } from '../../api/profession/service/profession.service';
import { CharacterService } from '../../api/character/service/character.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';
import { Character } from '../../api/character/model/character';
import { Profession } from '../../api/profession/model/profession';
import { CharacterFormComponent } from '../../component/character-form/character-form.component';

@Component({
  selector: 'app-add-character-view',
  standalone: true,
  imports: [
    ViewTitleComponent,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    ErrorMessageComponent,
    CharacterFormComponent,
  ],
  templateUrl: './add-character-view.component.html',
  styleUrl: './add-character-view.component.css',
})
export class AddCharacterViewComponent implements OnInit {
  constructor(
    private professionService: ProfessionService,
    private characterService: CharacterService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  message: string = '';
  profession: Profession | undefined;

  ngOnInit() {
    this.route.params.subscribe((params) => {
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

  onSubmit(character: Character): void {
    this.message = '';
    if (!this.profession) {
      return;
    }
    this.characterService.createCharacter(character, this.profession.id).subscribe({
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
