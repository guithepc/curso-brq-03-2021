import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MateriaServiceService } from '../materia-service.service';

@Component({
  selector: 'app-materia-form',
  templateUrl: './materia-form.component.html',
  styleUrls: ['./materia-form.component.scss']
})
export class MateriaFormComponent implements OnInit {

  public isEdicao = false;
  public meuForm2 : FormGroup;
  public materiaa: any;
  public id_materia =0;
  

  constructor(private  materiaService : MateriaServiceService, private formBuilder : FormBuilder, private activatedRoute: ActivatedRoute, private router: Router) { 
    this.meuForm2=this.formBuilder.group(
      {
        nome :      [null, [Validators.required]],
        professor:  [null, [Validators.required]]
      }
    );

    this.activatedRoute.params.subscribe(
      (data)=>{
        console.log(data);
        if (data.id){
          this.isEdicao=true;
          this.id_materia = data.id;

          this.materiaService.getOne(data.id).subscribe(
            (materia) =>{
              this.meuForm2.patchValue(materia);
            }
          )
        }
      }
    );
  }

  ngOnInit(): void {
  }

  public isValid(fieldName) : boolean{
    return (!this.meuForm2.get(fieldName).valid && this.meuForm2.get(fieldName).touched)
  }

  public onSubmit(){
    console.log(this.meuForm2)
  
        if(this.isEdicao){
          this.materiaService.update(this.id_materia, this.meuForm2.value)
          .subscribe(
            (data)=>{
              console.log(data)
              this.router.navigate(['/materias']);
            }
          );
        }else{
          this.materiaService.save(this.meuForm2.value)
            .subscribe(
            (data) => {
             console.log(data);
             this.router.navigate(['/materias']);
           
           }
         );
        }     
  }


 

}


