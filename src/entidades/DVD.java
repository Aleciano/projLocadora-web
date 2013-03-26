package entidades;

public class DVD extends Midia {

	private int duracaoMinutos;
	private String sinopse;

	public int getDuracaoMinutos() {
		return duracaoMinutos;
	}

	public void setDuracaoMinutos(int duracaoMinutos) {
		this.duracaoMinutos = duracaoMinutos;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	/* Construtor que recebe o Id explicitamente.*/
	public DVD(int id, String nome, String descricao, short qt,
			int duracaoMinutos, String sinopse) {
		super(id, nome, descricao, qt);
		this.duracaoMinutos = duracaoMinutos;
		this.sinopse = sinopse;
	}

	public DVD(String nome, String descricao, short qt, int duracaoMinutos,
			String sinopse) {
		super(nome, descricao, qt);
		this.duracaoMinutos = duracaoMinutos;
		this.sinopse = sinopse;
	}

	public DVD() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DVD [duracaoMinutos=" + duracaoMinutos + ", sinopse=" + sinopse
				+ ", getDuracaoMinutos()=" + getDuracaoMinutos()
				+ ", getSinopse()=" + getSinopse() + ", getQt()=" + getQt()
				+ ", getId()=" + getId() + ", getNome()=" + getNome()
				+ ", getDescricao()=" + getDescricao() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
