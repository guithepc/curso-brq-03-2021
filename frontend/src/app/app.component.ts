import { Component, ElementRef } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {//aqui fica o TYPESCRIPT
  public title : string = 'frontend';

  public nome : string;

  public isDesabilitado : boolean = true;

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
}
