package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import beans.Carro;
import beans.Pessoa;

/**
 * 
 * @author Amando dos Santos
 * Classe usada para criar uma coleção da classe Carro e cria um Stream<String> a partir de uma arquivo no formato
 * csv usando como delimitador o ;
 * O arquivo fica armazenado em /resource/pessoas.csv. Esse arquivo contém 101 linhas, incluindo o cabeçalho.
 * O arquivo contém o nome de pessoas, idade, sexo, estado e código do estado. 
 */
public class Load {
	
	public static List<Carro> obterListaCarros(){
		List<Carro> carros = new ArrayList<Carro>();
		
		carros.add(new Carro("Nissan", "Kicks", 2015));
		carros.add(new Carro("Mitsubishi", "L200 Savana", 2000));
		carros.add(new Carro("Mitsubishi", "Pajero Dakar", 1999));
		carros.add(new Carro("Peugeot", "207 SW", 2001));
		carros.add(new Carro("Porsche", "Boxster S", 2005));
		carros.add(new Carro("Porsche", "Cayenne", 2018));
		carros.add(new Carro("Toyota", "Corolla", 2002));
		carros.add(new Carro("Volkswagen", "Kombi", 1973));
		carros.add(new Carro("Volvo", "XC60", 2019));
		carros.add(new Carro("Honda", "Civic", 2017));
		carros.add(new Carro("Volkswagen", "Fusca", 1967));
		carros.add(new Carro("Volkswagen", "Gol", 2000));
		carros.add(new Carro("Volkswagen", "Variant", 1978));
		carros.add(new Carro("Nissan", "Altima", 2010));
		carros.add(new Carro("Peugeot", "207", 2019));
		
		return carros;
	}
	
	/**
	 * Criar um stream a partir de um arquivo csv.
	 * Cada linha do arquivo está separado por ;
	 * @return	List<Pessoa>
	 */
	public static List<Pessoa> readFile() {
		Stream<String> streamString = null;
		List<Pessoa> pessoas = null;
		try (InputStream istream = Load.class.getClass().getResourceAsStream("/resource/pessoas.csv"); 
			 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(istream)); ) {
			
			streamString = bufferedReader.lines();
			pessoas = streamString
					.skip(1)
					.map(p -> p.split(";"))
					.map( p -> new Pessoa(p[0], new Integer(p[1]), p[2], p[3], p[4]))
					.collect(Collectors.toList());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pessoas;
	}
	
}
