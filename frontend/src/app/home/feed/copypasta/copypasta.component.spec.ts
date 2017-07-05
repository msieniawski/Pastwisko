import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CopypastaComponent } from './copypasta.component';

describe('CopypastaComponent', () => {
  let component: CopypastaComponent;
  let fixture: ComponentFixture<CopypastaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CopypastaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CopypastaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
