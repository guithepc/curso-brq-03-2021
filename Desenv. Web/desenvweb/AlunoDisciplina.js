class AlunoDisciplina{
	// constructor
	constructor(idAluno,idDisciplina){
		this.idAluno = idAuno;
		this.idDisciplina = idDisciplina;
	}
	
	// setters
	setNotaB1(notaB1){this.notaB1 = notaB1;}
	setNotaB2(notaB2){this.notaB2 = notaB2;}
	
	// getters
	getIdAluno(){return this.idAluno;}
	getIdDisciplina(){return this.idDisciplina;}
	
	// methods
	mediaAritmetica(){return (this.notaB1+this.notaB2)/2;}
	mediaPonderada(){return (this.notaB1*4+this.notaB2*6)/10;}
}