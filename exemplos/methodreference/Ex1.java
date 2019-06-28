package exemplos.methodreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;


/**
 * Exemplos de Method Reference
 * 
 *
 */
public class Ex1 {
	
		
	/**
	 * métodos estático
	 * Class::staticMethod 
	 * 	Method Reference String::valueOf
	 * 	Lambda s -> String.valueOf(s)
	 * 
	 * Reference to a Static Method
	 */
	private static void metEstatico() {
		
		Stream.of(2,3,4, 6).forEach( Impar::ehImpar );
		Stream.of(2,3,4, 6).forEach((i) -> System.out.println(Impar.ehImpar(i)));
	}
	
	/**
	 * Class:instanceMethod	
	 * Method Reference	String::toString	 
	 * Lambda expression s -> s.toString()
	 * Reference to an Instance Method of an Arbitrary Object of a Particular Type
	 */
	private static void sort() {
		List<Integer> numbers = Arrays.asList(5, 3, 50, 24, 40, 2);
		numbers.stream().sorted((a, b) -> Integer.compare(a, b));
		numbers.stream().sorted(Integer::compare).forEach(System.out::println);
	}
	
	/**
	 * Reference to an instance method of a particular object
	 * instance::instanceMethod
	 * 	Method Reference	s:toString	 
	 * 	Lambda expression	() -> “string”.toString()
	 */
	private static void sort2() {
		List<String> nomes = Arrays.asList("Pedro", "Ana", "Laura", "Paulo");
		Comparator<String> comp = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		nomes.stream().sorted(comp::compare).forEach(System.out::println);
	}
	
	/**
	 * Cria uma nova instância do objeto
	 * Reference to a constructor	
	 * Class::new	
	 * 	Method Reference	String::new	
	 * Lambda expression	() -> new String()
	 * 
	 */
	private static void crearInstancia() {
		Supplier<List<String>> l = ArrayList<String>::new;
		
	}
	public static void main(String[] args) {
		metEstatico();
		sort();
		sort2();
		crearInstancia();
	}

}

class Impar{
	public static boolean ehImpar(int i) {		
		return (i % 2) != 0;
	}
}