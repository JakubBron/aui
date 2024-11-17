import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ErrorMessageComponent } from '../error-message/error-message.component';
import { Character } from '../../api/character/model/character';

@Component({
  selector: 'app-character-form',
  standalone: true,
  imports: [
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    ErrorMessageComponent,
  ],
  templateUrl: './character-form.component.html',
  styleUrl: './character-form.component.css',
})
export class CharacterFormComponent {
  @Input() character: Character = {
    id: '',
    name: '',
    age: 0,
    level: 0,
  };
  @Output() submit = new EventEmitter<Character>();
  @Input() message: string = '';

  onSubmit(): void {
    if (this.character) {
      this.submit.emit(this.character);
    }
  }
}
