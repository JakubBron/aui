import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Characters } from '../model/characters';
import { Observable } from 'rxjs';
import { Character } from '../model/character';

@Injectable({
  providedIn: 'root',
})
export class CharacterService {
  constructor(private httpClient: HttpClient) {}

  getAllCharacters(): Observable<Characters> {
    return this.httpClient.get<Characters>('/api/characters');
  }

  getCharacterById(id: string): Observable<Character> {
    return this.httpClient.get<Character>(`/api/characters/${id}`);
  }

  getCharactersByProfessionId(professionId: string): Observable<Characters> {
    return this.httpClient.get<Characters>(
      `/api/professions/${professionId}/characters`,
    );
  }

  createCharacter(character: Character, professionId: string): Observable<Character> {
    return this.httpClient.post<Character>(
      `/api/professions/${professionId}/characters`,
      character,
    );
  }

  updateCharacter(character: Character): Observable<Character> {
    return this.httpClient.patch<Character>(
      `/api/characters/${character.id}`,
      character,
    );
  }

  deleteCharacter(id: string): Observable<void> {
    return this.httpClient.delete<void>(`/api/characters/${id}`);
  }
}
