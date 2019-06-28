package exemplos;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import beans.Carro;
import util.Load;

/**
 * 
 * @author Amando dos Santos Neto
 * @version 1.0
 * Essa classe permite ordernar uma cole��o de carros por nome do fabricante, modelo e ano.
 * Nesse exemplo apresento a forma cl�ssica e usado Lambda para realizar a ordena��o
 * 
 */
public class Exemplo2 {
	
	public Exemplo2() {
		
	}
	
	/**
	 * Fazendo a ordena��o por nome do fabricante usando o modelo cl�ssico.
	 * Vamos criar uma Classe An�nima para fazer o sort
	 */
	public void ordenarPorFabricante() {
		List<Carro> carros = Load.obterListaCarros();
		
		//Criando uma classe an�nima para realizar a ordena��o.
		Collections.sort(carros, new Comparator<Carro>() {
			@Override
		    public int compare(Carro car1, Carro car2) {				
		        return car1.getFabricante().compareTo(car2.getFabricante());
		    }
		});
		System.out.println();
		System.out.println("********** Classic :: SORT BY FABRICANTE **********");
		for(Carro carro : carros) {
			System.out.println(carro);
		}
	}
	
	/**
	 * Fazendo o ordena��o por nome do fabricante usando a Express�o Lambda.
	 */
	public void ordenarPorFabricanteUsandoLambda1() {
		List<Carro> carros = Load.obterListaCarros();
		
		//Usando o c
		Collections.sort(carros, (c1, c2) -> c1.getFabricante().compareTo(c2.getFabricante()));
		System.out.println();
		System.out.println("********** Lambda-1:: SORT BY FABRICANTE **********");
		carros.forEach(carro -> System.out.println(carro));
	}
	
	/**
	 * Fazendo o ordena��o por nome do fabricante usando a Express�o Lambda.
	 * E fazendo usa de alguma melhorias na Interface Comparator ( thenComparing )
	 */
	public void ordenarPorFabricanteUsandoLambda2() {
		List<Carro> carros = Load.obterListaCarros();
		System.out.println();
		System.out.println("********** Lambda-2 :: SORT BY FABRICANTE **********");
		carros.stream()
		.sorted( Comparator.comparing(Carro::getFabricante)
				.thenComparing(Carro::getModelo))
		.forEach(System.out::println);
		
	}
	
	
	/**
	 * Fazendo o ordena��o pelo modelo usando a Express�o Lambda.
	 */
	public void ordenarPorModelo() {
		//a ser implementado
	}
	
	/**
	 * Fazendo o ordena��o pelo ano usando a Express�o Lambda.
	 */
	public void ordenarPorAno() {
		
	}
	
	/**
	 * Imprimindo o conteudo de uma lista
	 */
	private void listNaoOrdernada() {
		List<Carro> carros = Load.obterListaCarros();		
		for( Carro carro : carros) {
			System.out.println(carro);
		}
	}
	
	public static void main(String[] args) {
		long inicio = 0;
		long fim = 0;
		Exemplo2 ex = new Exemplo2();
		ex.listNaoOrdernada();
		
		inicio = System.currentTimeMillis();
		ex.ordenarPorFabricante();
		fim = System.currentTimeMillis();
		System.out.println("Dura��o: " + (fim - inicio));
		
		inicio = System.currentTimeMillis();
		ex.ordenarPorFabricanteUsandoLambda1();
		fim = System.currentTimeMillis();
		System.out.println("Dura��o: " + (fim - inicio));
		
		inicio = System.currentTimeMillis();
		ex.ordenarPorFabricanteUsandoLambda2();
		fim = System.currentTimeMillis();
		System.out.println("Dura��o: " + (fim - inicio));
	}

}
