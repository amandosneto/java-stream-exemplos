package beans;

/**
 * 
 * @author Amando S. Neto
 * Classe Aluno que possui nome e valor da nota.
 *
 */
public class Aluno {
	private String nome;
	private double nota;
	
	public Aluno() {
		nome = "Nome não definido";
	}
	
	public Aluno(String nome, double nota) {
		super();
		this.nome = nome;
		this.nota = nota;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aluno [nome=").append(nome).append(", nota=").append(nota).append("]");
		return builder.toString();
	}
	
	
}
