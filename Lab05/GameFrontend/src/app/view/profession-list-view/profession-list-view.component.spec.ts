import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessionListViewComponent } from './profession-list-view.component';

describe('ProfessionListViewComponent', () => {
  let component: ProfessionListViewComponent;
  let fixture: ComponentFixture<ProfessionListViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProfessionListViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(ProfessionListViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
