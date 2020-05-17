import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HimageComponent } from './himage.component';

describe('HimageComponent', () => {
  let component: HimageComponent;
  let fixture: ComponentFixture<HimageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HimageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HimageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
