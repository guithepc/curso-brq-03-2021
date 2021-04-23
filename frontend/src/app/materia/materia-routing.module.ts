import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MateriaFormComponent } from './materia-form/materia-form.component';
import { MateriaListComponent } from './materia-list/materia-list.component';

const routes: Routes = [
  {path: 'materias', component: MateriaListComponent},
  {path: 'materia-form', component : MateriaFormComponent},
  {path: 'materia-form/:id', component: MateriaFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MateriaRoutingModule { }
