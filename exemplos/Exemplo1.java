package exemplos;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import beans.Aluno;
import util.LoadAluno;

/**
 * 
 * Essa classe permite processar uma coleção de alunos e saber a maior nota.
 * E vamos ver o tempo de cada execução.
 */
public class Exemplo1 {

	private List<Aluno> alunos = null;
	
	public Exemplo1() {
		alunos = LoadAluno.load();
	}
	
	/**
	 * Usando o método clássico para obter a maior nota usando o for loop.
	 */
	public void classico() {
		double maiorNota = 0;
		
		for(int i=0; i<alunos.size(); i++) {
			if ( alunos.get(i).getNota() > maiorNota ) {
				maiorNota = alunos.get(i).getNota();
			}
		}
		System.out.println("Classico: Maior nota: " + maiorNota);
	}
	
	/**
	 * Usando o for each loop 
	 */
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
	 * Nesse exemplo, será retornado uma Classe Optional<Aluno>
	 */
	public void descolada() {
		/*
		 * 1. Converte a coleção em stream.
		 * 2. Comparator.comparing: informo o que desejo comparar
		 * 3. chama a operação terminal para calcular a nota máxima
		 * 4. a função max retorna uma classe Optional
		 * 4.1 orElse: No caso de não encontrar a maior nota, cria um Aluno sem dado
		 */
		
		Aluno maiorNota = alunos.stream()
				.filter(a -> a.getNota() < 10.0)
				.max(Comparator.comparing(Aluno::getNota))
				.orElse(new Aluno());
				
		System.out.println("Descolada: Maior nota: " + maiorNota.getNota());
		
		
	}
	
	public static void main(String[] args) {
		long inicio = 0;
		long fim = 0;
		
		Exemplo1 ea = new Exemplo1();
		
		inicio = System.currentTimeMillis();
		ea.classico();
		fim = System.currentTimeMillis();
		System.out.println("Duração: " + (fim - inicio));
		
		inicio = System.currentTimeMillis();
		ea.vintage();
		fim = System.currentTimeMillis();
		System.out.println("Duração: " + (fim - inicio));
		
		inicio = System.currentTimeMillis();
		ea.descolada();
		fim = System.currentTimeMillis();
		System.out.println("Duração: " + (fim - inicio));
	}

}
