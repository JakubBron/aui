import { Component } from '@angular/core';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { ProfessionService } from '../../api/profession/service/profession.service';
import { Profession } from '../../api/profession/model/profession';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';
import { Router } from '@angular/router';
import { ProfessionFormComponent } from '../../component/profession-form/profession-form.component';

@Component({
  selector: 'app-add-profession-view',
  standalone: true,
  imports: [ViewTitleComponent, ErrorMessageComponent, ProfessionFormComponent],
  templateUrl: './add-profession-view.component.html',
  styleUrl: './add-profession-view.component.css',
})
export class AddProfessionViewComponent {
  constructor(
    private professionService: ProfessionService,
    private router: Router
  ) {}

  message: string = '';

  onSubmit(profession: Profession): void {
    this.message = '';
    this.professionService.createProfession(profession).subscribe({
      next: (profession: Profession) => {
        this.router.navigate(['/professions', profession.id]);
      },
      error: (error) => {
        this.message = error.error.message;
      },
    });
  }
}
