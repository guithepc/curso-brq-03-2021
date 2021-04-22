import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';

import { AlunoDetalheComponent } from './aluno-detalhe/aluno-detalhe.component';
import { SharedModule } from '../shared/shared.module';
import { AlunoRoutingModule } from './aluno-routing.module';
import { AlunoFormComponent } from './aluno-form/aluno-form.component';
import { AlunoListComponent } from './aluno-list/aluno-list.component';



@NgModule({
  declarations: [
    HomeComponent,
    AlunoDetalheComponent,
    AlunoFormComponent,
    AlunoListComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    AlunoRoutingModule
  ],
  exports: [
    HomeComponent
  ]
})
export class AlunoModule { }
