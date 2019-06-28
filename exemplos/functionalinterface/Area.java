package exemplos.functionalinterface;

/**
 * Criando uma Functional Interface para calcular valores, passando tr�s param�tros e retornar o resultado.
 * @author Amando S. Neto
 *
 * @param <T>	Tipo do Primeiro param�tro
 * @param <U>	Tipo do Segundo param�tro
 * @param <V>	Tipo do Terceiro param�tro
 * @param <R> 	Tipo do retorno Retorno
 */

public interface Area<T, U, V, R> {
	
	/**
	 * recebe 3 param�tros e retorna um resultado
	 * @param t	Tipo do Primeiro param�tro
	 * @param u Tipo do Segundo param�tro
	 * @param v Tipo do Terceiro param�tro
	 * @return	Retorna o resultado
	 */
	R calcular(T t, U u, V v);
}
