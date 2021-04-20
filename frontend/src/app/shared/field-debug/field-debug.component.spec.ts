import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FieldDebugComponent } from './field-debug.component';

describe('FieldDebugComponent', () => {
  let component: FieldDebugComponent;
  let fixture: ComponentFixture<FieldDebugComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FieldDebugComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FieldDebugComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
