import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessionDetailsViewComponent } from './profession-details-view.component';

describe('ProfessionDetailsViewComponent', () => {
  let component: ProfessionDetailsViewComponent;
  let fixture: ComponentFixture<ProfessionDetailsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProfessionDetailsViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(ProfessionDetailsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
