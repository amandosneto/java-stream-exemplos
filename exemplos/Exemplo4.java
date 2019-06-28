package exemplos;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 * @author Amando dos Santos Neto
 * Esse exemplo mostra como podemos criar uma stream que não seja a partir de uma coleção.
 */
public class Exemplo4 {

	public static void main(String[] args) {
		IntStream.range(1, 3).forEach(i -> System.out.print(i + ", "));  // > 1, 2
		System.out.println();
		IntStream.rangeClosed(1, 3).forEach(i -> System.out.print(i + ", "));  // > 1, 2, 3
		System.out.println();

		Stream.of("Paulo", "Ana", "Pedro").forEach(i -> System.out.print(i + ", "));
		System.out.println();
		
		IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10)).limit(8).forEach(i -> System.out.print(i + ", "));
		System.out.println();
	}

}
