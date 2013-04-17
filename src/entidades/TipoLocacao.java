package entidades;

/**
 *Esta classe modela um tipo de locacao que pode ser realizado em uma locadora do mundo real
 */

/**
 *Esta classe modela um tipo de locacao que pode ser realizado em uma locadora do mundo real
 *Ela possui:
 * um numero de identificacao, 
 * um nome, 
 * uma descricao,
 * um valor para locacao e
 * a quantidade de dias da locacao.
 * @author tercio, leonardo e aleciano
 *
 */
public class TipoLocacao {
	
	private int id;
	private String nome;
	private double valor_locacao;
	private int nDiasLocacao;

	/**
	 * construtor vazio
	 */
	public TipoLocacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id numero de identificacao do tipo de locacao
	 * @param nome nome do tipo de locacao
	 * @param descricao descricao do tipo de  locacao
	 * @param valor_locacao valor do tipo de locacao
	 * @param nDiasLocacao numero de dias de locacao deste tipo
	 */
	public TipoLocacao(int id, String nome, String descricao,
			double valor_locacao, int nDiasLocacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor_locacao = valor_locacao;
		this.nDiasLocacao = nDiasLocacao;
	}

	/**
	 * @return o numero de identificacao
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id numero de identificacao
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return o nome 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	/**
	 * @return o valor
	 */
	public double getValor_locacao() {
		return valor_locacao;
	}

	/**
	 * @param valor_locacao valor
	 */
	public void setValor_locacao(double valor_locacao) {
		this.valor_locacao = valor_locacao;
	}

	/**
	 * @return numero de dias de locacao
	 */
	public int getnDiasLocacao() {
		return nDiasLocacao;
	}

	/**
	 * @param nDiasLocacao dias de locacao
	 */
	public void setnDiasLocacao(int nDiasLocacao) {
		this.nDiasLocacao = nDiasLocacao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TipoLocacao [id=" + id + ", nome=" + nome + ", valor_locacao=" + valor_locacao
				+ ", nDiasLocacao=" + nDiasLocacao + ", getId()=" + getId()
				+ ", getNome()=" + getNome() + ", getValor_locacao()=" + getValor_locacao()
				+ ", getnDiasLocacao()=" + getnDiasLocacao() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
