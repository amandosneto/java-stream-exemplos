package exemplos.lambda;


/**
 * 
 * @author Amando S. Neto
 * Classe que identificar se uma especie pode nadar ou voar.
 *
 */
public class Animal {
	private String especie;
	private boolean podeNadar;
	private boolean podeVoar;

	public Animal(String especie, boolean podeNadar, boolean podeVoar) {
		this.especie = especie;
		this.podeNadar = podeNadar;
		this.podeVoar = podeVoar;
	}

	public boolean especiePodeNadar() { return podeNadar; }
	public boolean especiePodeVoar() { return podeVoar; }
	public String toString() { return especie; }

}
