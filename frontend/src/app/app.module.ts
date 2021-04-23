import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AlunoModule } from './aluno/aluno.module';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PrimeiroComponent } from './primeiro/primeiro.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SharedModule } from './shared/shared.module';
import { MateriaModule } from './materia/materia.module';



@NgModule({
  declarations: [
    AppComponent,
    PrimeiroComponent
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AlunoModule,
    NgbModule,   
    SharedModule,
    MateriaModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
