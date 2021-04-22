import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './aluno/home/home.component';
import { PrimeiroComponent } from './primeiro/primeiro.component';

const routes: Routes = [
  // {path: 'alunos', component: HomeComponent}
  {path: 'primeiro-component', component: PrimeiroComponent}//associa a url ('primeiro-component')com o component
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }