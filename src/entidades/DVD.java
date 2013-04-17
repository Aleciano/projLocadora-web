package entidades;

/**
 * DVD e filho de Midia e modela um dvd de uma locadora do mundo real DVD possui
 * atributos como tempo de duracao duracaoMinutos e sinopse
 * 
 * @author Aleciano, Tercio e Leonardo
 */

public class DVD extends Midia {
	/**
	 * @param duracaoMinutos
	 *            duracao do DVD
	 * @param sinopse
	 *            sinopse do DVD
	 * @param locado
	 *            estado do DVD
	 */

	/**
	 * DVD e filho de Midia e modela um dvd de uma locadora do mundo real DVD
	 * possui atributos como tempo de duracao duracaoMinutos e sinopse
	 * 
	 */
	private int duracaoMinutos;
	private String sinopse;
	boolean locado;

	/**
	 * @return tempo de duracao do DVD em minutos
	 */
	public int getDuracaoMinutos() {
		return duracaoMinutos;
	}

	/**
	 * @param duracaoMinutos
	 *            duracao do DVD em minutos
	 */
	public void setDuracaoMinutos(int duracaoMinutos) {
		this.duracaoMinutos = duracaoMinutos;
	}

	/**
	 * @return texto com sinopse do DVD
	 */
	public String getSinopse() {
		return sinopse;
	}

	/**
	 * @param sinopse
	 *            sinopse do DVD
	 */
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public boolean isLocado() {
		return locado;
	}

	public void setLocado(boolean locado) {
		this.locado = locado;
	}

	/* Construtor que recebe o Id explicitamente. */
	/**
	 * construtor
	 * 
	 * @param id
	 *            numero de identificacao do DVD
	 * @param nome
	 *            nome do Produto
	 * @param descricao
	 *            descricao do DVD
	 * @param qt
	 *            quantidade de midias do DVD
	 * @param duracaoMinutos
	 *            duracao do DVD em minutos
	 * @param sinopse
	 *            sinopse do DVD
	 */
	public DVD(int id, String nome, String descricao, short qt,
			int duracaoMinutos, String sinopse) {
		super(id, nome, descricao, qt);
		this.duracaoMinutos = duracaoMinutos;
		this.sinopse = sinopse;
		this.locado = false;
	}

	/**
	 * construtor sem id
	 * 
	 * @param nome
	 *            nome do Produto
	 * @param descricao
	 *            descricao do DVD
	 * @param qt
	 *            quantidade de midias do DVD
	 * @param duracaoMinutos
	 *            duracao do DVD em minutos
	 * @param sinopse
	 *            sinopse do DVD
	 */
	public DVD(String nome, String descricao, short qt, int duracaoMinutos,
			String sinopse) {
		super(nome, descricao, qt);
		this.duracaoMinutos = duracaoMinutos;
		this.sinopse = sinopse;
	}

	/**
	 * construtor vazio
	 */
	public DVD() {
		super();

	}

	@Override
	public String toString() {
		return "DVD [nome = " + getNome() + ", duracaoMinutos="
				+ duracaoMinutos + ", locado=" + locado + ", sinopse="
				+ sinopse + "]";
	}

}