import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CharacterDetailsViewComponent } from './character-details-view.component';

describe('CharacterDetailsViewComponent', () => {
  let component: CharacterDetailsViewComponent;
  let fixture: ComponentFixture<CharacterDetailsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CharacterDetailsViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(CharacterDetailsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
