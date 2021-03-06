package entidades;

/**
 * Classe que representa um Produto da Locadora.
 */

/**
 * Produto incluir campos como identificador, nome e descricao.
 * @author aleciano, tercio e leonardo
 */

public abstract class Produto {
	private int id;
	private String nome;
	private String descricao;

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

	public Produto(int id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	
	/**
	 * construtor
	 * @param nome nome do Produto
	 * param descricao descricao do tipo de mídia: filme, infantil e show.
	 */
	public Produto(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + ", getId()=" + getId() + ", getNome()="
				+ getNome() + ", getDescricao()=" + getDescricao()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}



}