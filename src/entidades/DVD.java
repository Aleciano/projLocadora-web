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
	public DVD(int id, String nome, String descricao, short qt,
			int duracaoMinutos, String sinopse) {
		super(id, nome, descricao, qt);
		this.duracaoMinutos = duracaoMinutos;
		this.sinopse = sinopse;
	}	
	
}
