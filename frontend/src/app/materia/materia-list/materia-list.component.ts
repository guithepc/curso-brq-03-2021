import { Component, OnInit } from '@angular/core';
import { MateriaServiceService } from '../materia-service.service';

@Component({
  selector: 'app-materia-list',
  templateUrl: './materia-list.component.html',
  styleUrls: ['./materia-list.component.scss']
})
export class MateriaListComponent implements OnInit {

    public materias : any = []; 

    
    public pageSize : number = 5;
    public p : number = 1 ;
    public paginaRest : number = this.p - 1;
    public total : number = 0 ;
  
    
    public materiaDetalhe: any;
    public materiaDelete : any;
  
    constructor( private materiaService : MateriaServiceService )   
    {   
        
        
      this.getPagination();
    }
  
    ngOnInit(): void {
      
    }
        
    public pageChanged(evento){
      console.log(evento);
      this.p = evento;
      this.paginaRest =  this.p - 1;
      this.getPagination ();
    }

    // onMateriaClick(id_materia){
    //   //1-)buscar informação do aluno pelo GET ONE
    //   this.materiaService.getOne( id_materia )
    //     .subscribe(
    //       (data) => {
    //         this.materiaDetalhe = data;
    //       }
    //     )
    // }

    onDeleteClick(idMateria){
      this.materiaService.delete(idMateria)
      .subscribe(
        (data) => {
          this.getPagination();
 
        }
      )
    }

    private getPagination(){
      this.materiaService.getPagination(this.paginaRest, this.pageSize)
            .subscribe(
              (data : any) => {
                console.log(data);
                this.materias = data.content;  
                this.total = data.totalElements;  
              }
          );
  }

}
