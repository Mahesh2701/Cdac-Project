import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VillagePostsComponent } from './village-posts.component';

describe('VillagePostsComponent', () => {
  let component: VillagePostsComponent;
  let fixture: ComponentFixture<VillagePostsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VillagePostsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VillagePostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
