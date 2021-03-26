class ContaCorrente{
    constructor(numCC){
        this.numCC= numCC
        this.saldoCC = 0
    }
    setSaldoCC(saldoCC){this.saldoCC = saldoCC;}


    

    getNumCC(){return this.numCC;}
    getSaldoCC(){return this.saldoCC;}

    depositar(valor){
    return this.saldoCC+= valor;
    }
    
    sacar(valor){
        return this.saldoCC-=valor;
    }

}