package exemplos.lambda;

/**
 * 
 * @author Amando S. Neto
 * Essa classe possui a implementa��o para saber de uma determinada especie voa ou n�o.
 *
 */
public class VerificaSeVoa implements CheckEspecie {

	@Override
	public boolean check(Animal a) {
		// TODO Auto-generated method stub
		return a.especiePodeVoar();
	}

}
