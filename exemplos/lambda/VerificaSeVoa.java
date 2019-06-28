package exemplos.lambda;

/**
 * 
 * @author Amando S. Neto
 * Essa classe possui a implementação para saber de uma determinada especie voa ou não.
 *
 */
public class VerificaSeVoa implements CheckEspecie {

	@Override
	public boolean check(Animal a) {
		// TODO Auto-generated method stub
		return a.especiePodeVoar();
	}

}
