import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCharacterViewComponent } from './edit-character-view.component';

describe('EditCharacterViewComponent', () => {
  let component: EditCharacterViewComponent;
  let fixture: ComponentFixture<EditCharacterViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditCharacterViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(EditCharacterViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
