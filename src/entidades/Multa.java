package entidades;

/**
 * @author tercio, aleciano e leonardo Esta classe modela uma multa que pode ser
 *         aplicada a uma locacao de uma produto de uma locadora que teve a
 *         entrega atrazada. Ela possui os seguintes atributos: um numero de
 *         identificacao, um nome ,uma descricao, um percentual e um valor 
 * 
 */
public class Multa {
	private int id;
	private String nome;
	private String descricao;
	private double percentual;
	private double valor;

	/**
	 * @return o numero de idendificacao da multa
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id numero de identificacao da multa
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return o nome da multa
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome nome da multa
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return a descricao da multa
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao descricao da multa
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return o percentual a multa
	 */
	public double getPercentual() {
		return percentual;
	}

	/**
	 * @param percentual percentual da multa
	 */
	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}

	/**
	 * @return o valor da multa
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor valor da multa
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**construtor com parametros
	 * @param id numero de idenditificacao da multa
	 * @param nome nome da multa
	 * @param descricao descricao a multa
	 * @param percentual percentual da multa 
	 * @param valor valor da multa
	 */
	public Multa(int id, String nome, String descricao, double percentual,
			double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.percentual = percentual;
		this.valor = valor;
	}

	/**construtor vazio
	 * 
	 */
	public Multa() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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
