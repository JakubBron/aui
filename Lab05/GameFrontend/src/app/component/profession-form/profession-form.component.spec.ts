import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessionFormComponent } from './profession-form.component';

describe('ProfessionFormComponent', () => {
  let component: ProfessionFormComponent;
  let fixture: ComponentFixture<ProfessionFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProfessionFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProfessionFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
