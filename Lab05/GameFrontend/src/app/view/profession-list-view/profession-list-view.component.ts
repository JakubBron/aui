import { Component, OnInit } from '@angular/core';
import { ProfessionService } from '../../api/profession/service/profession.service';
import { Professions } from '../../api/profession/model/professions';
import { MatListModule } from '@angular/material/list';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';

@Component({
  selector: 'app-profession-list-view',
  standalone: true,
  imports: [
    MatListModule,
    MatDividerModule,
    MatButtonModule,
    RouterLink,
    MatIconModule,
    ViewTitleComponent,
  ],
  templateUrl: './profession-list-view.component.html',
  styleUrl: './profession-list-view.component.css',
})
export class ProfessionListViewComponent implements OnInit {
  constructor(private professionService: ProfessionService) {}

  professions: Professions | undefined;

  ngOnInit(): void {
    this.fetchProfessions();
  }

  fetchProfessions(): void {
    this.professionService.getAllProfessions().subscribe((professions) => {
      this.professions = professions;
    });
  }

  deleteProfession(id: string): void {
    this.professionService.deleteProfession(id).subscribe(() => {
      this.fetchProfessions();
    });
  }
}
