package entidades;

/**
 * 		Esta classe e uma classe abstrata filha
 *         de Produto. Ela modela uma midia locavel do mundo real. 
 */

/**@author Tercio, Aleciano, Leonardo
 * Esta classe e uma classe abstrata filha
 * de Produto. Ela modela uma midia locavel do mundo real. Ela possui um
 * numero de idendificacao da midia, um nome da midia, uma descricao da da midia
 * e uma quantidade de volumes da midia.
 * @author junior
 */
public abstract class Midia extends Produto {
	private short qt;

	/**
	 * @return quantidade de midias
	 */
	public short getQt() {
		return qt;
	}

	/**
	 * @param qt
	 *            quantidade de midias
	 */
	public void setQt(short qt) {
		this.qt = qt;
	}

	/**
	 * construtor
	 * 
	 * @param id
	 *            numero de idendificacao da midia
	 * @param nome
	 *            nome da midia
	 * @param descricao
	 *            descricao da da midia
	 * @param qt
	 *            quantidade de volumes da midia
	 */
	public Midia(int id, String nome, String descricao, short qt) {
		super(id, nome, descricao);
		this.qt = qt;
	}

	/**
	 * construtor sem o id
	 * 
	 * @param nome
	 *            nome da midia
	 * @param descricao
	 *            descricao da da midia
	 * @param qt
	 *            quantidade de volumes da midia
	 * 
	 */
	public Midia(String nome, String descricao, short qt) {
		super(nome, descricao);
		this.qt = qt;
	}

	/**
	 * construtor vazio
	 */
	public Midia() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Midia [qt=" + qt + ", getQt()=" + getQt() + ", getId()="
				+ getId() + ", getNome()=" + getNome() + ", getDescricao()="
				+ getDescricao() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}