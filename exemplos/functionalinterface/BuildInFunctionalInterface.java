package exemplos.functionalinterface;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


/**
 * 
 * 
 * Apresentando algumas das Build-in Functional Interface. Os exemplos ser�o apresentados usado
 * express�es Lambda e Method Reference.
 * Functional Interfaces	# Parameters	Return Type	Single Abstract Method
   ---------------------	------------	-----------	-----------------------
 	Supplier<T>				0				T			get
	Consumer<T>				1 (T)			void		accept
	BiConsumer<T, U>		2 (T, U)		void		accept
	Predicate<T>			1 (T)			boolean		test
	BiPredicate<T, U>		2 (T, U)		boolean		test
	Function<T, R>			1 (T)			R			apply
	BiFunction<T, U, R>		2 (T, U)		R			apply
	UnaryOperator<T>		1 (T)			T			apply
	BinaryOperator<T>		2 (T, T)		T			apply

 * Refer�ncia OCP Oracle� Certified Professional Java� SE 8 Programmer II Study Guide
 * Jeanne Boyarsky
 * Scott Selikoff


 */
public class BuildInFunctionalInterface {

	/**
	 * Usado para gerar valor sem precisar prover param�tros
	 * 
	 */
	private static void supplier() {
		//Method Reference
		Supplier<LocalDate> s1 = LocalDate::now;
		
		//Express�o Lambda
		Supplier<LocalDate> s2 = () -> LocalDate.now();
		 
		LocalDate d1 = s1.get();
		LocalDate d2 = s2.get();
		 
		System.out.println(d1);
		System.out.println(d2);

	}
	
	/**
	 * Existe duas Functional Interface para o Consumer
	 * Consumer and BiConsumer
	 * Usa quando voc� deseja fazer alguma coisa com o param�tro sem precisar retornar alguma coisa.
	 */
	private static void consumer() {
		Consumer<String> c1 =  System.out::println;
		Consumer<String> c2 = x -> System.out.println(x);
		 
		c1.accept("Annie");
		c2.accept("Annie");

		
		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String, Integer> b1 =  map::put;
		BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
		 
		b1.accept("chicken", 7);
		b2.accept("chick", 1);
		 
		System.out.println(map);
	}
	
	/**
	 * Predicate e BiPredicate
	 * Usado para verifica��o.
	 */
	private static void  predicate() {
		Predicate<String> p1 =  String::isEmpty;
		Predicate<String> p2 = x -> x.isEmpty();

		System.out.println(p1.test(""));
		System.out.println(p2.test(""));

		BiPredicate<String, String> b1 =  String::startsWith;
		BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);
		 
		System.out.println(b1.test("chicken", "chick"));
		System.out.println(b2.test("chicken", "chick"));

	}
	
	/**
	 * Function e BiFunction
	 * Usado para processar um valor e retornar um resultado.
	 */
	private static void function() {
		Function<String, Integer> f1 =  String::length;
		Function<String, Integer> f2 = x -> x.length();
		 
		System.out.println(f1.apply("cluck"));  // 5
		System.out.println(f2.apply("cluck"));  // 5

		BiFunction<String, String, String> b1 =  String::concat;
		BiFunction<String, String, String> b2 = (string, toAdd) -> string.concat(toAdd);
		 
		System.out.println(b1.apply("baby ", "chick")); // baby chick
		System.out.println(b2.apply("baby ", "chick")); // baby chick

	}
	
	/**
	 * Usando uma Functional Interface customizada
	 */
	private static void calcular() {

		Area<Integer, Integer, Integer, Integer> triangulo = (b,h,d) -> (b * h) / d;
		Area<Double, Double, Integer, Double> hexagono = (a, p, d) -> (a * p) / d;
		
		System.out.println(triangulo.calcular(10, 30, 2)); //area = b.h / 2
		System.out.println(hexagono.calcular(4.7, 2.89, 2)); //area = a.p / 2
	}
	public static void main(String[] args) {
		System.out.println("----- CONSUMER -----");
		consumer();
		
		System.out.println("----- SUPPLIER -----");
		supplier();
		
		System.out.println("----- PREDICATE -----");
		predicate();
		
		System.out.println("----- FUNCTION -----");
		function();
		
		System.out.println("----- CUSTOM FUNCTION -----");
		calcular();
	}

}
