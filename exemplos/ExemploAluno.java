package exemplos;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import beans.Aluno;
import util.LoadAluno;

public class ExemploAluno {

	private List<Aluno> alunos = null;
	
	public ExemploAluno() {
		alunos = LoadAluno.load();
	}
	
	public void classico() {
		double maiorNota = 0;
		
		for(int i=0; i<alunos.size(); i++) {
			if ( alunos.get(i).getNota() > maiorNota ) {
				maiorNota = alunos.get(i).getNota();
			}
		}
		System.out.println("Classico: Maior nota: " + maiorNota);
	}
	
	public void vintage() {
		double maiorNota = 0;
		
		for(Aluno al : alunos) {
			if ( al.getNota() > maiorNota ) {
				maiorNota = al.getNota();
			}
		}
		System.out.println("Vintage: Maior nota: " + maiorNota);
	}
	
	/**
	 * Usando o stream para obter a nota mais alta.
	 * Nesse exemplo, será retornado um Optional
	 */
	public void descolada() {
		//List<Aluno> alunos = new ArrayList<>();
		Optional<Aluno> maiorNota = alunos.stream().max(Comparator.comparing(Aluno::getNota));
		maiorNota.ifPresent(aluno -> System.out.println("Descolada: Maior nota: " + aluno.getNota()));
		
		
	}
	
	public static void main(String[] args) {
		ExemploAluno ea = new ExemploAluno();
		ea.classico();
		ea.vintage();
		ea.descolada();
	}

}
