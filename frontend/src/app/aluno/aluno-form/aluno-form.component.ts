import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlunoService } from '../aluno.service';

@Component({
  selector: 'app-aluno-form',
  templateUrl: './aluno-form.component.html',
  styleUrls: ['./aluno-form.component.scss']
})
export class AlunoFormComponent implements OnInit {

  public meuForm : FormGroup;
  public alunoo: any;

  constructor(private  alunoService : AlunoService, private formBuilder : FormBuilder) { 
    this.meuForm=this.formBuilder.group(
      {
        nomeAluno :  [null, [Validators.required]],
        turmaAluno:  [null, [Validators.required]]
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
     let newAluno = {
        nomeAluno : this.meuForm.value.nomeAluno,
        turmaAluno : this.meuForm.value.turmaAluno
      };
     console.log(newAluno);
       this.alunoService.save(newAluno).subscribe(
         (data) => {
          console.log(data);
          this.alunoo=data;
        
        }
      );
  }

}
