import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CopypastaCreatorComponent } from './copypasta-creator.component';

describe('CopypastaCreatorComponent', () => {
  let component: CopypastaCreatorComponent;
  let fixture: ComponentFixture<CopypastaCreatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CopypastaCreatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CopypastaCreatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
