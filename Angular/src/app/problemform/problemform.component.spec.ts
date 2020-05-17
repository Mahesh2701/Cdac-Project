import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProblemformComponent } from './problemform.component';

describe('ProblemformComponent', () => {
  let component: ProblemformComponent;
  let fixture: ComponentFixture<ProblemformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProblemformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProblemformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
