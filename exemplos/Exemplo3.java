package exemplos;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import beans.Pessoa;
import util.Load;

/**
 * 
 * @author Amando S. Neto
 * Aqui teremos vários exemplos do uso da Expressão Lambda
 *
 */
public class Exemplo3 {

	public Exemplo3() {}
	
	/**
	 * Imprimir o conteudo do Stream
	 */
	private static void print() {
		List<Pessoa> pessoas = Load.readFile();
		pessoas.forEach(System.out::println);
	}
	
	/**
	 * Imprimir os 10 primeiros da lista em ordem alfabética por Código de Estado
	 */
	private static void orderByCodigoEstado() {
		List<Pessoa> pessoas = Load.readFile();
		pessoas.stream()
		.sorted((p1,p2) -> p2.getCodigoEstado().compareTo(p1.getCodigoEstado()))
		.limit(10)
		.forEach(p -> System.out.println(p));
		
	}
	
	/**
	 * Imprimir as mulheres acima de 45 anos  em ordem decrescente de idade
	 */
	private static void printMulheresMaior45() {
		List<Pessoa> pessoas = Load.readFile();
		pessoas.stream()
		.filter(p -> p.getSexo().equals("F"))
		.filter(p -> p.getIdade() > 45)
		.sorted(Comparator.comparingInt(Pessoa::getIdade).reversed())
		.forEach(System.out::println);
	}
	
	/**
	 * Imprimir a quantidade de pessoas por estado
	 */
	private static void groupByCodigoEstado() {
		List<Pessoa> pessoas = Load.readFile();
		Map<String, List<Pessoa>> map = pessoas.stream().collect(Collectors.groupingBy(Pessoa::getCodigoEstado));
		map.forEach((k,v) -> System.out.println(k + " " + v.size()) );
	}
	
	/**
	 * Obtendo a estatística por idade.
	 */
	private static void estatisticas() {
		List<Pessoa> pessoas = Load.readFile();
		IntSummaryStatistics statistics = pessoas.stream()
		        .mapToInt(Pessoa::getIdade)
		        .summaryStatistics();
		System.out.println(statistics);
		//System.out.println(statistics.getAverage());
	}
	
	/**
	 * Computando a idade minima do sexo masculino
	 */
	private static void idadeMinimaMasculino() {
		List<Pessoa> pessoas = Load.readFile();
		
		int min = pessoas.stream()
				.filter(p -> p.getSexo().equals("M"))
		        .mapToInt(Pessoa::getIdade)
		        .min()
		        .orElse( 0 );
		System.out.println("Idade min: " + min);
	}
	public static void main(String[] args) {
		long inicio = 0;
		long fim = 0;
		//print();
		
		inicio = System.currentTimeMillis();
		orderByCodigoEstado();
		fim = System.currentTimeMillis();
		System.out.println("Duração: " + (fim - inicio));
		
		inicio = System.currentTimeMillis();
		printMulheresMaior45();
		fim = System.currentTimeMillis();
		System.out.println("Duração: " + (fim - inicio));
		
		inicio = System.currentTimeMillis();
		groupByCodigoEstado();
		fim = System.currentTimeMillis();
		System.out.println("Duração: " + (fim - inicio));
		
		inicio = System.currentTimeMillis();
		estatisticas();
		fim = System.currentTimeMillis();
		System.out.println("Duração: " + (fim - inicio));
		
		inicio = System.currentTimeMillis();
		idadeMinimaMasculino();
		fim = System.currentTimeMillis();
		System.out.println("Duração: " + (fim - inicio));
	}
}
