
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { AlunoService } from '../aluno.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  //RxJS
  /**
   * arrow function ---- =>
   * function (data){
          console.log(data);
          this.alunos = data;    
    }
   */
  public alunos : any = [];

  @Input()
  public tituloFilho : any;

  @Output()
  public emitirEvento : EventEmitter<string> = new EventEmitter<string>();

  public alunoDetalhe : any;

  constructor( private alunoService : AlunoService )    
  {   
      
      this.alunoService.getAll()
      .subscribe(
        (data) => {
          console.log(data);
          this.alunos = data;    
        }
      );
  }

  ngOnInit(): void {
    console.log(this.tituloFilho);
  }

  onEmitirEventoClick(){
    this.emitirEvento.emit('BRQ');
  }

  onAlunoCLick(id_aluno){
    //1-)buscar informação do aluno pelo GET ONE
    this.alunoService.getOne( id_aluno )
      .subscribe(
        (data) => {
          console.log(data)
          this.alunoDetalhe = data;
        }
      )

    //2-)armazenar resultado em uma variável

    //3-) passar a variável do passo 2 via INPUT PROPERTIES para aluno-detalhe

    //4) criar HTML do aluno-detalhe com as variávei que recebem os valores do pai
  }

}