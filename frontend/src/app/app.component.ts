import { Component, ElementRef } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AlunoService } from './aluno/aluno.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent {//aqui fica o TYPESCRIPT
  public title : string = 'frontend';

  public nome : string;

  public  alunoo:any;

  public isDesabilitado : boolean = true;

  public meuForm : FormGroup;

  // public turmaAluno : string;
  // public nomeAluno : string;

  constructor(private  alunoService : AlunoService, private formBuilder : FormBuilder){
    this.meuForm=this.formBuilder.group(
      {
        nomeAluno :  [null, [Validators.required]],
        turmaAluno:  [null, [Validators.required]]
      }
    );
  }

 
  public somar() : number{
    return (1+1);
  }

  public onMeuBotaoClick(){
    let i = 0;
    alert('Mensagem...' + this.title)
  }

  public getTitle(){
    return this.title;
  }

  public capturarDados(valor){
    console.log(valor);
    this.nome = valor;
    // alert('aaaaa')
  }

  public receiveEmitirEvento(e){
    console.log(e);
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

  public isValid(fieldName) : boolean{
    return (!this.meuForm.get(fieldName).valid && this.meuForm.get(fieldName).touched)
  }
}
