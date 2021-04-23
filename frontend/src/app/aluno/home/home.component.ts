
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MateriaServiceService } from 'src/app/materia/materia-service.service';

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

  @Input()
  public alunoDetalhe : any;

  @Input()
  public materiaDetalhe : any;

  constructor( private alunoService : AlunoService, private materiaService :MateriaServiceService )    
  {   
      
      this.alunoService.getAll()
      .subscribe(
        (data) => {
          console.log(data);
          this.alunos = data;    
        }
      );

      this.materiaService
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
  }

  onMateriaCLick(id_materia){
    //1-)buscar informação do aluno pelo GET ONE
    this.alunoService.getOne( id_materia )
      .subscribe(
        (data) => {
          console.log(data)
          this.materiaDetalhe = data;
        }
      )
  }

}