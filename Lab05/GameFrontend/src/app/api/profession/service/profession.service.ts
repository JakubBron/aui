import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Professions } from '../model/professions';
import { Profession } from '../model/profession';

@Injectable({
  providedIn: 'root',
})
export class ProfessionService {
  constructor(private httpClient: HttpClient) {}

  getAllProfessions(): Observable<Professions> {
    return this.httpClient.get<Professions>('/api/professions');
  }

  getProfessionById(id: string): Observable<Profession> {
    return this.httpClient.get<Profession>(`/api/professions/${id}`);
  }

  createProfession(profession: Profession): Observable<Profession> {
    return this.httpClient.put<Profession>('/api/professions', profession);
  }

  updateProfession(profession: Profession): Observable<Profession> {
    return this.httpClient.patch<Profession>(
      `/api/professions/${profession.id}`,
       profession,
    );
  }

  deleteProfession(id: string): Observable<void> {
    return this.httpClient.delete<void>(`/api/professions/${id}`);
  }
}
