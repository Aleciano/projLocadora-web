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
	
	
}
