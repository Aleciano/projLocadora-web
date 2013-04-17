package entidades;

/**
 * Esta classe modela uma multa que pode ser aplicada a uma locacao de uma produto de uma locadora que teve a
 * entrega atrasada.  
 */
/**
 * Esta classe modela uma multa que pode ser aplicada a uma locacao de uma produto de uma locadora que teve a
 * entrega atrasada. Ela possui os seguintes atributos: um numero de identificacao, um nome, uma descricao e um valor.
 * @author Tercio, Aleciano e Leonardo
 * @param id identificacao da multa
 * @param nome nome da multa
 * @param valor da multa
*/


public class Multa {
	private int id;
	private String nome;

	private double valor;

	/**
	 * @return o numero de idendificacao da Multa
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id numero de identificacao da Multa
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return o nome da Multa
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome nome da Multa
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	/**
	 * @return o valor da Multa
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor valor da Multa
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**construtor com parametros
	 * @param id numero de idenditificação da Multa.
	 * @param nome nome da Multa

	 * @param valor valor da Multa
	 */
	public Multa(int id, String nome,
			double valor) {
		super();
		this.id = id;
		this.nome = nome;

		this.valor = valor;
	}
	
	/** Construtor com parametros
	 * @param nome nome da Multa

	 * @param valor valor da Multa
	 */
	public Multa(String nome,
			double valor) {
		super();
		this.id = 99;
		this.nome = nome;

		this.valor = valor;
	}

	/**construtor vazio
	 * 
	 */
	public Multa() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Multa [id=" + id + ", nome=" + nome + ", valor=" + valor
				+ ", getId()=" + getId() + ", getNome()=" + getNome()
				+ ", getValor()=" + getValor() + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	

}
