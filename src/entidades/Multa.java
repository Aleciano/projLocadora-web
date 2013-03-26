package entidades;

public class Multa {
	private int id;
	private String nome;
	private String descricao;
	private double percentual;
	private double valor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPercentual() {
		return percentual;
	}
	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Multa(int id, String nome, String descricao, double percentual,
			double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.percentual = percentual;
		this.valor = valor;
	}
	public Multa() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Multa [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + ", percentual=" + percentual + ", valor=" + valor
				+ ", getId()=" + getId() + ", getNome()=" + getNome()
				+ ", getDescricao()=" + getDescricao() + ", getPercentual()="
				+ getPercentual() + ", getValor()=" + getValor()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
