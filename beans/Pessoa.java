package beans;


/**
 * 
 * @author Amando S. Neto
 * Classe Pessoa que possui dados sobre nome, sexo, idade, estado e UF.
 *
 */
public class Pessoa {
	private String nome;
	private int idade;
	private String sexo;
	private String estado;
	private String codigoEstado;
	
	public Pessoa(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}
	
	public Pessoa(String nome, int idade, String sexo, String estado, String codigoEstado) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.estado = estado;
		this.codigoEstado = codigoEstado;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCodigoEstado() {
		return codigoEstado;
	}
	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", estado=" + estado + ", codigoEstado="
				+ codigoEstado + "]";
	}

	
	
}
