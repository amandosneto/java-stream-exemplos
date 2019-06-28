package exemplos.lambda;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Amando S. Neto
 * Vamos usar essa classe para resolver um problema usando uma expressão lamdba.
 */
public class BuscaTradicional {
	
	/**
	 * Verifica se a especie pode voar
	 * @param animals Coleção de animais
	 * @param checkEspecie	Classe que verifica se voa.
	 */
	private static void print(List<Animal> animals, CheckEspecie checkEspecie) {
		for (Animal animal : animals) {
			if (checkEspecie.check(animal)) {
				System.out.print(animal + " ");
			}
		}
		System.out.println();
	}
	
	/**
	 * Verifica se a especie pode voar
	 * @param animals Coleção de animais
	 * @param checkEspecie	Classe que verifica se voa.
	 */
	private static void print(List<Animal> animals, CheckEspecie checkEspecie) {
		for (Animal animal : animals) {
			if (checkEspecie.check(animal)) {
				System.out.print(animal + " ");
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("Peixe", true, false));
		animals.add(new Animal("Galinha", false, false));
		animals.add(new Animal("Gavião", false, true));
		animals.add(new Animal("Pato", true, true));
		
		//print(animals, new VerificaSeVoa());
		
		//Problema: O que devo fazer para verificar se uma especie pode nadar, e as que podem nadar e voar
		//Problema: O que devo fazer para verificar se uma especie pode nadar, e as que podem nadar e voar
		print2(animals, a -> a.especiePodeNadar());
		System.out.println("============== Pode Nadar");
		print2(animals, a -> a.especiePodeNadar() && a.especiePodeVoar());
		System.out.println("============== Pode Nadar e Voar");
		print2(animals, a -> a.especiePodeVoar());
		System.out.println("============== Pode Voar");
	}

}
