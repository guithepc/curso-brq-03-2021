import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MateriaDetalheComponent } from './materia-detalhe.component';

describe('MateriaDetalheComponent', () => {
  let component: MateriaDetalheComponent;
  let fixture: ComponentFixture<MateriaDetalheComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MateriaDetalheComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MateriaDetalheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
