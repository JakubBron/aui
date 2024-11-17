import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCharacterViewComponent } from './add-character-view.component';

describe('AddCharacterViewComponent', () => {
  let component: AddCharacterViewComponent;
  let fixture: ComponentFixture<AddCharacterViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddCharacterViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(AddCharacterViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
