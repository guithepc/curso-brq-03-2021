import { Component, OnInit } from '@angular/core';
import { MateriaServiceService } from '../materia-service.service';

@Component({
  selector: 'app-materia-list',
  templateUrl: './materia-list.component.html',
  styleUrls: ['./materia-list.component.scss']
})
export class MateriaListComponent implements OnInit {

    public materias : any = []; 

    
    public materiaDetalhe: any;
    public materiaDelete : any;
  
    constructor( private materiaService : MateriaServiceService )   
    {   
        
        
      this.getAll();
    }
  
    ngOnInit(): void {
      
    }
        
    getAll(){
      this.materiaService.getAll()
      .subscribe(
        (data) => {
          console.log(data);
          this.materias = data;    
        }
      );
    }

    onMateriaClick(id_materia){
      //1-)buscar informação do aluno pelo GET ONE
      this.materiaService.getOne( id_materia )
        .subscribe(
          (data) => {
            this.materiaDetalhe = data;
          }
        )
    }

    onDeleteClick(idMateria){
      this.materiaService.delete(idMateria)
      .subscribe(
        (data) => {
          this.getAll()
 
        }
      )
    }

}
