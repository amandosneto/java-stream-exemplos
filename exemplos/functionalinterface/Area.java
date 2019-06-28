package exemplos.functionalinterface;

/**
 * Criando uma Functional Interface para calcular valores, passando três paramêtros e retornar o resultado.
 * @author Amando S. Neto
 *
 * @param <T>	Tipo do Primeiro paramêtro
 * @param <U>	Tipo do Segundo paramêtro
 * @param <V>	Tipo do Terceiro paramêtro
 * @param <R> 	Tipo do retorno Retorno
 */

public interface Area<T, U, V, R> {
	
	/**
	 * recebe 3 paramêtros e retorna um resultado
	 * @param t	Tipo do Primeiro paramêtro
	 * @param u Tipo do Segundo paramêtro
	 * @param v Tipo do Terceiro paramêtro
	 * @return	Retorna o resultado
	 */
	R calcular(T t, U u, V v);
}
