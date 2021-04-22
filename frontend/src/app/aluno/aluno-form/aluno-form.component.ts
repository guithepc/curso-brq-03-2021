import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AlunoService } from '../aluno.service';

@Component({
  selector: 'app-aluno-form',
  templateUrl: './aluno-form.component.html',
  styleUrls: ['./aluno-form.component.scss']
})
export class AlunoFormComponent implements OnInit {

  public isEdicao = false;
  public meuForm : FormGroup;
  public alunoo: any;
  public id_aluno =0;
  

  constructor(private  alunoService : AlunoService, private formBuilder : FormBuilder, private activatedRoute: ActivatedRoute, private router: Router) { 
    this.meuForm=this.formBuilder.group(
      {
        nomeAluno :  [null, [Validators.required]],
        turmaAluno:  [null, [Validators.required]]
      }
    );

    this.activatedRoute.params.subscribe(
      (data)=>{
        console.log(data);
        if (data.id){
          this.isEdicao=true;
          this.id_aluno = data.id;

          this.alunoService.getOne(data.id).subscribe(
            (aluno) =>{
              this.meuForm.patchValue(aluno);
            }
          )
        }
      }
    );
  }

  ngOnInit(): void {
  }

  public isValid(fieldName) : boolean{
    return (!this.meuForm.get(fieldName).valid && this.meuForm.get(fieldName).touched)
  }

  public onSubmit(){
    console.log(this.meuForm)
  
        if(this.isEdicao){
          this.alunoService.update(this.id_aluno, this.meuForm.value)
          .subscribe(
            (data)=>{
              console.log(data)
              this.router.navigate(['/alunos']);
            }
          );
        }else{
          this.alunoService.save(this.meuForm.value)
            .subscribe(
            (data) => {
             console.log(data);
             this.router.navigate(['/alunos']);
           
           }
         );
        }     
  }


 

}

