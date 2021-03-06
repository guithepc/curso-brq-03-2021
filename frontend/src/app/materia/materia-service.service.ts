import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MateriaServiceService {

  
  uri : string = `${environment.API_URI}/materias`;
  
  
  constructor(private httpService: HttpClient) { }
  
  public getAll(){
    return this.httpService.get("http://localhost:8081/materias");
  }

  public getOne(id_materia){
    return this.httpService.get("http://localhost:8081/materias/" +  id_materia);
  }

  public save (newMateria){
    return this.httpService.post("http://localhost:8081/materias", newMateria);
  }

  public delete (idMateria){
    return this.httpService.delete("http://localhost:8081/materias/" +  idMateria)
  }

  public update(id_materia, newMateria){
    return this.httpService.patch(`http://localhost:8081/materias/${id_materia}`, newMateria);
  }

  public getPagination(pagina, registrosPorPagina = 2){
    return this.httpService.get(`${this.uri}/paginacao?pagina=${pagina}&registros=${registrosPorPagina}`);
  }
}
