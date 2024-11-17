import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditProfessionViewComponent } from './edit-profession-view.component';

describe('EditProfessionViewComponent', () => {
  let component: EditProfessionViewComponent;
  let fixture: ComponentFixture<EditProfessionViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditProfessionViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(EditProfessionViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
