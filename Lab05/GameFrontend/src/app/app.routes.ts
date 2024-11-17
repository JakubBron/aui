import { Routes } from '@angular/router';
import { ProfessionListViewComponent } from './view/profession-list-view/profession-list-view.component';
import { AddProfessionViewComponent } from './view/add-profession-view/add-profession-view.component';
import { EditProfessionViewComponent } from './view/edit-profession-view/edit-profession-view.component';
import { ProfessionDetailsViewComponent } from './view/profession-details-view/profession-details-view.component';
import { CharacterDetailsViewComponent } from './view/character-details-view/character-details-view.component';
import { AddCharacterViewComponent } from './view/add-character-view/add-character-view.component';
import { EditCharacterViewComponent } from './view/edit-character-view/edit-character-view.component';


export const routes: Routes = [
  {
      component: ProfessionListViewComponent,
      path: 'professions',
    },
    {
      component: AddProfessionViewComponent,
      path: 'professions/new',
    },
    {
      component: ProfessionDetailsViewComponent,
      path: 'professions/:id',
    },
    {
      component: EditProfessionViewComponent,
      path: 'professions/:id/edit',
    },
    {
      component: AddCharacterViewComponent,
      path: 'professions/:professionId/characters/new',
    },
    {
      component: CharacterDetailsViewComponent,
      path: 'professions/:professionId/characters/:characterId',
    },
    {
      component: EditCharacterViewComponent,
      path: 'professions/:professionId/characters/:characterId/edit',
    },
    {
      component: ProfessionListViewComponent,
      path: '**',
    },
];
