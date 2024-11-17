import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Profession } from '../../api/profession/model/profession';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ErrorMessageComponent } from '../error-message/error-message.component';

@Component({
  selector: 'app-profession-form',
  standalone: true,
  imports: [
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    ErrorMessageComponent,
  ],
  templateUrl: './profession-form.component.html',
  styleUrl: './profession-form.component.css',
})
export class ProfessionFormComponent {
  @Input() profession: Profession = {
    id: '',
    name: '',
    yearsOfExperience: 0,
  };
  @Output() submit = new EventEmitter<Profession>();
  @Input() message: string = '';

  onSubmit(): void {
    if (this.profession) {
      this.submit.emit(this.profession);
    }
  }
}
