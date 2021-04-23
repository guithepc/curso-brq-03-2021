import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MateriaRoutingModule } from './materia-routing.module';
import { MateriaListComponent } from './materia-list/materia-list.component';
import { MateriaFormComponent } from './materia-form/materia-form.component';
import { SharedModule } from '../shared/shared.module';
import { MateriaDetalheComponent } from './materia-detalhe/materia-detalhe.component';
import { NgxPaginationModule } from 'ngx-pagination';


@NgModule({
  declarations: [
    MateriaListComponent,
    MateriaFormComponent,
    MateriaDetalheComponent
  ],
  imports: [
    CommonModule,
    MateriaRoutingModule,
    SharedModule,
    NgxPaginationModule //dps isso vai pro import e export no shared
  ]
})
export class MateriaModule { }
