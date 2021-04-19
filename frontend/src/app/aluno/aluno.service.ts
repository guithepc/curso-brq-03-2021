import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  constructor(private httpService: HttpClient) { }

  public getAll(){
    return this.httpService.get("http://localhost:8081/alunos");
  }

  public getOne(id_aluno){
    return this.httpService.get("http://localhost:8081/alunos/" +  id_aluno);
  }

  public save (newAluno){
    return this.httpService.post("http://localhost:8081/alunos", newAluno);
  }
}
