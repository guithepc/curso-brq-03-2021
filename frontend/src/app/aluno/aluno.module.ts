import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { AlunoDetalheComponent } from './aluno-detalhe/aluno-detalhe.component';



@NgModule({
  declarations: [
    HomeComponent,
    AlunoDetalheComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule
  ],
  exports: [
    HomeComponent
  ]
})
export class AlunoModule { }
