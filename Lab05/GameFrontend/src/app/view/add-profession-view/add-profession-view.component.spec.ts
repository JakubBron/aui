import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddProfessionViewComponent } from './add-profession-view.component';

describe('AddProfessionViewComponent', () => {
  let component: AddProfessionViewComponent;
  let fixture: ComponentFixture<AddProfessionViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddProfessionViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(AddProfessionViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
