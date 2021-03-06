import { Component, Input, OnInit } from '@angular/core';
import { AlunoService } from '../aluno.service';

@Component({
  selector: 'app-aluno-list',
  templateUrl: './aluno-list.component.html',
  styleUrls: ['./aluno-list.component.scss']
})
export class AlunoListComponent implements OnInit {

 //RxJS
  /**
   * arrow function ---- =>
   * function (data){
          console.log(data);
          this.alunos = data;    
    }
   */
    
    public alunos : any = []; 

    
    public alunoDetalhe : any;

    public alunoDelete : any;
  
    constructor( private alunoService : AlunoService )   
    {   
        
        
      this.getAll();
    }
  
    ngOnInit(): void {
      
    }
        
    getAll(){
      this.alunoService.getAll()
      .subscribe(
        (data) => {
          console.log(data);
          this.alunos = data;    
        }
      );
    }

    onAlunoClick(id_aluno){
      //1-)buscar informação do aluno pelo GET ONE
      this.alunoService.getOne( id_aluno )
        .subscribe(
          (data) => {
            this.alunoDetalhe = data;
          }
        )
    }

    onDeleteClick(idAluno){
      this.alunoService.delete(idAluno)
      .subscribe(
        (data) => {
          this.getAll()
 
        }
      )
    }
  
}
