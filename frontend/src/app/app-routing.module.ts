import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PrimeiroComponent } from './primeiro/primeiro.component';

const routes: Routes = [
  {path: 'primeiro-component', component: PrimeiroComponent},//associa a url ('primeiro-component')com o component
  {path: 'alunos', loadChildren:() =>import('./aluno/aluno.module').then(m => m.AlunoModule)}, //assim que você importa o modulo, voce carrega o modulo
  {path: 'materias', loadChildren:() =>import('./materia/materia.module').then(m => m.MateriaModule)} //assim que você importa o modulo, voce carrega o modulo

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }