import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FieldErrorComponent } from './field-error/field-error.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './navbar/navbar.component';
import { AppRoutingModule } from '../app-routing.module';
import { FieldDebugComponent } from './field-debug/field-debug.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    FieldErrorComponent,
    NavbarComponent,
    FieldDebugComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule
  ],
  exports: [
    FieldErrorComponent,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    NavbarComponent,
    FieldDebugComponent
  ]
})
export class SharedModule { }
