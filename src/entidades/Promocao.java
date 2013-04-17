package entidades;

/**
 * Classe que representa uma Promocao da Locadora.
 */

/**
 * Promocao tem campos como identificador, nome, valor dela, data de inicio e data final de validade.
 * @author aleciano, tercio e leonardo
 */

import java.sql.*;

public class Promocao {
	private int id;
	private String nome;
	private double valor;
	private Date dtInit;
	private Date dtFinal;
	
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
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getDuracaoInit() {
		return dtInit;
	}
	public void setDuracaoInit(Date duracaoInit) {
		this.dtInit = duracaoInit;
	}
	public Date getDuracaoFinal() {
		return dtFinal;
	}
	public void setDuracaoFinal(Date duracaoFinal) {
		this.dtFinal = duracaoFinal;
	}
	public Promocao(int id, String nome, double percentual,
			double valor, Date duracaoInit, Date duracaoFinal) {
		super();
		this.id = id;
		this.nome = nome;

		this.valor = valor;
		this.dtInit = duracaoInit;
		this.dtFinal = duracaoFinal;
	}
	public Promocao(){
		
	}
	@Override
	public String toString() {
		return "Promocao [id=" + id + ", nome=" + nome + ", valor=" + valor
				+ ", dtInit=" + dtInit + ", dtFinal=" + dtFinal + "]";
	}
	
	

}
