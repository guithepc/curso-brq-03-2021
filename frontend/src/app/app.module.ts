import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AlunoModule } from './aluno/aluno.module';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PrimeiroComponent } from './primeiro/primeiro.component';

@NgModule({
  declarations: [
    AppComponent,
    PrimeiroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    AlunoModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
