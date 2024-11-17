import { Component, OnInit } from '@angular/core';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { ProfessionService } from '../../api/profession/service/profession.service';
import { Profession } from '../../api/profession/model/profession';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProfessionFormComponent } from '../../component/profession-form/profession-form.component';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';

@Component({
  selector: 'app-add-profession-view',
  standalone: true,
  imports: [ViewTitleComponent, ProfessionFormComponent, ErrorMessageComponent],
  templateUrl: './edit-profession-view.component.html',
  styleUrl: './edit-profession-view.component.css',
})
export class EditProfessionViewComponent implements OnInit {
  constructor(
    private professionService: ProfessionService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  profession: Profession | undefined;
  message: string = '';

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.professionService.getProfessionById(params['id']).subscribe({
        next: (profession: Profession) => {
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
    if (this.profession === undefined) {
      return;
    }
    this.professionService.updateProfession(this.profession).subscribe({
      next: (profession: Profession) => {
        this.router.navigate(['/professions', profession.id]);
      },
      error: (error) => {
        this.message = error.error.message;
      },
    });
  }
}
