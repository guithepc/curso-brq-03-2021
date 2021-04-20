import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FieldErrorComponent } from './field-error/field-error.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [
    FieldErrorComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  exports: [
    FieldErrorComponent,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ]
})
export class SharedModule { }
