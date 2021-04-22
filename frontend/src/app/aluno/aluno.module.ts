import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';

import { AlunoDetalheComponent } from './aluno-detalhe/aluno-detalhe.component';
import { SharedModule } from '../shared/shared.module';
import { AlunoRoutingModule } from './aluno-routing.module';



@NgModule({
  declarations: [
    HomeComponent,
    AlunoDetalheComponent
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
