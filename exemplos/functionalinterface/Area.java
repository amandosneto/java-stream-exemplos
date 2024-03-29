package exemplos.functionalinterface;

/**
 * Criando uma Functional Interface para calcular valores, passando trÍs paramÍtros e retornar o resultado.
 * @author Amando S. Neto
 *
 * @param <T>	Tipo do Primeiro paramÍtro
 * @param <U>	Tipo do Segundo paramÍtro
 * @param <V>	Tipo do Terceiro paramÍtro
 * @param <R> 	Tipo do retorno Retorno
 */

public interface Area<T, U, V, R> {
	
	/**
	 * recebe 3 paramÍtros e retorna um resultado
	 * @param t	Tipo do Primeiro paramÍtro
	 * @param u Tipo do Segundo paramÍtro
	 * @param v Tipo do Terceiro paramÍtro
	 * @return	Retorna o resultado
	 */
	R calcular(T t, U u, V v);
}
