package entidades;

public class TipoLocacao {
	private int id;
	private String nome;
	private String descricao;
	private double valor_locacao;
	private int nDiasLocacao;

	public TipoLocacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoLocacao(int id, String nome, String descricao,
			double valor_locacao, int nDiasLocacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor_locacao = valor_locacao;
		this.nDiasLocacao = nDiasLocacao;
	}

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

	public double getValor_locacao() {
		return valor_locacao;
	}

	public void setValor_locacao(double valor_locacao) {
		this.valor_locacao = valor_locacao;
	}

	public int getnDiasLocacao() {
		return nDiasLocacao;
	}

	public void setnDiasLocacao(int nDiasLocacao) {
		this.nDiasLocacao = nDiasLocacao;
	}

	@Override
	public String toString() {
		return "TipoLocacao [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + ", valor_locacao=" + valor_locacao
				+ ", nDiasLocacao=" + nDiasLocacao + ", getId()=" + getId()
				+ ", getNome()=" + getNome() + ", getDescricao()="
				+ getDescricao() + ", getValor_locacao()=" + getValor_locacao()
				+ ", getnDiasLocacao()=" + getnDiasLocacao() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
