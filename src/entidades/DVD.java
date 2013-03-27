package entidades;

/**
 * @author tercio
 * DVD e filho de Midia e modela um dvd de uma locadora do mundo real
 * DVD possui atributos como tempo de duracao @paran duracaoMinutos e sinopse 
 * @paran sinopse
 */
public class DVD extends Midia {

	private int duracaoMinutos;
	private String sinopse;

	/**
	 * @return tempo de duracao do DVD em minutos
	 */
	public int getDuracaoMinutos() {
		return duracaoMinutos;
	}

	/**
	 * @param duracaoMinutos duracao do DVD em minutos
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
	 * @param sinopse sinopse do DVD
	 */
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	/* Construtor que recebe o Id explicitamente.*/
	/**
	 * construtor 
	 * @param id numero de identificacao do DVD
	 * @param nome nome do Produto
	 * @param descricao descricao do DVD
	 * @param qt quantidade de midias do DVD
	 * @param duracaoMinutos duracao do DVD em minutos
	 * @param sinopse sinopse do DVD
	 */
	public DVD(int id, String nome, String descricao, short qt,
			int duracaoMinutos, String sinopse) {
		super(id, nome, descricao, qt);
		this.duracaoMinutos = duracaoMinutos;
		this.sinopse = sinopse;
	}

	/**construtor sem id
	 * 
	 * @param nome 
	 * @param nome nome do Produto
	 * @param descricao descricao do DVD
	 * @param qt quantidade de midias do DVD
	 * @param duracaoMinutos duracao do DVD em minutos
	 * @param sinopse sinopse do DVD
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
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see entidades.Midia#toString()
	 */
	@Override
	public String toString() {
		return "DVD [duracaoMinutos=" + duracaoMinutos + ", sinopse=" + sinopse
				+ ", getDuracaoMinutos()=" + getDuracaoMinutos()
				+ ", getSinopse()=" + getSinopse() + ", getQt()=" + getQt()
				+ ", getId()=" + getId() + ", getNome()=" + getNome()
				+ ", getDescricao()=" + getDescricao() /*+ ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";*/
				;
	}
	
}
