package entidades;

import java.util.Date;

public class Promocao {
	private int id;
	private String nome;
	private String descricao;
	private double percentual;
	private double valor;
	private Date duracaoInit;
	private Date duracaoFinal;
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
	public double getPercentual() {
		return percentual;
	}
	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getDuracaoInit() {
		return duracaoInit;
	}
	public void setDuracaoInit(Date duracaoInit) {
		this.duracaoInit = duracaoInit;
	}
	public Date getDuracaoFinal() {
		return duracaoFinal;
	}
	public void setDuracaoFinal(Date duracaoFinal) {
		this.duracaoFinal = duracaoFinal;
	}
	public Promocao(int id, String nome, String descricao, double percentual,
			double valor, Date duracaoInit, Date duracaoFinal) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.percentual = percentual;
		this.valor = valor;
		this.duracaoInit = duracaoInit;
		this.duracaoFinal = duracaoFinal;
	}
	
	

}
