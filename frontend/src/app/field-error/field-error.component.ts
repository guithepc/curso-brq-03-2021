import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-field-error',
  templateUrl: './field-error.component.html',
  styleUrls: ['./field-error.component.scss']
})
export class FieldErrorComponent implements OnInit {

  @Input()
  public isShow: boolean = false;


  @Input()
  public message : string;

  constructor() { }

  ngOnInit(): void {
  }




}
