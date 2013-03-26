package entidades;

public abstract class Midia extends Produto {
	private short qt;

	public short getQt() {
		return qt;
	}

	public void setQt(short qt) {
		this.qt = qt;
	}

	public Midia(int id, String nome, String descricao, short qt) {
		super(id, nome, descricao);
		this.qt = qt;
	}
	
	public Midia(String nome, String descricao, short qt) {
		super(nome, descricao);
		this.qt = qt;
	}

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
