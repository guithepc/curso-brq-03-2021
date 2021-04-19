import { Component, Input, OnInit, Output } from '@angular/core';
import { AlunoService } from '../aluno.service';

@Component({
  selector: 'app-aluno-detalhe',
  templateUrl: './aluno-detalhe.component.html',
  styleUrls: ['./aluno-detalhe.component.scss']
})
export class AlunoDetalheComponent implements OnInit {

  @Input()
  public aluno : any;

  

  public alunos: any =[];

  constructor(){
     
  }



  ngOnInit(): void {
  }

}
