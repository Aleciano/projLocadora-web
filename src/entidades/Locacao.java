package entidades;

import java.sql.Date;

public class Locacao {

	private int id;
	private Midia midia;
	private double valor;
	private Multa multa;
	private double valorPago;
	private Promocao promocao;
	private Date dtLocacao;
	private Date dtDevolucaoAgendada;
	private Date dtDevolucao;
	private Funcionario funcionario;
	private Cliente cliente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Midia getMidia() {
		return midia;
	}

	public void setMidia(Midia midia) {
		this.midia = midia;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Multa getMulta() {
		return multa;
	}

	public void setMulta(Multa multa) {
		this.multa = multa;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	public Promocao getPromocao() {
		return promocao;
	}

	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}

	public Date getDtLocacao() {
		return dtLocacao;
	}

	public void setDtLocacao(Date dtLocacao) {
		this.dtLocacao = dtLocacao;
	}

	public Date getDtDevolucaoAgendada() {
		return dtDevolucaoAgendada;
	}

	public void setDtDevolucaoAgendada(Date dtDevolucaoAgendada) {
		this.dtDevolucaoAgendada = dtDevolucaoAgendada;
	}

	public Date getDtDevolucao() {
		return dtDevolucao;
	}

	public void setDtDevolucao(Date dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Locacao(int id, Midia midia, double valor, Multa multa,
			double valorPago, Promocao promocao, Date dtLocacao,
			Date dtDevolucaoAgendada, Date dtDevolucao,
			Funcionario funcionario, Cliente cliente) {
		super();
		this.id = id;
		this.midia = midia;
		this.valor = valor;
		this.multa = multa;
		this.valorPago = valorPago;
		this.promocao = promocao;
		this.dtLocacao = dtLocacao;
		this.dtDevolucaoAgendada = dtDevolucaoAgendada;
		this.dtDevolucao = dtDevolucao;
		this.funcionario = funcionario;
		this.cliente = cliente;
	}

	public Locacao(int id, Midia midia, double valor, Promocao promocao,
			Date dtLocacao, Date dtDevolucaoAgendada, Funcionario funcionario,
			Cliente cliente) {
		super();
		this.id = id;
		this.midia = midia;
		this.valor = valor;
		this.promocao = promocao;
		this.dtLocacao = dtLocacao;
		this.dtDevolucaoAgendada = dtDevolucaoAgendada;
		this.funcionario = funcionario;
		this.cliente = cliente;
	}

	public Locacao(Midia midia, double valor, Promocao promocao,
			Date dtLocacao, Date dtDevolucaoAgendada, Funcionario funcionario,
			Cliente cliente) {
		super();
		this.midia = midia;
		this.valor = valor;
		this.promocao = promocao;
		this.dtLocacao = dtLocacao;
		this.dtDevolucaoAgendada = dtDevolucaoAgendada;
		this.funcionario = funcionario;
		this.cliente = cliente;
	}
	public Locacao(){
		
	}

	@Override
	public String toString() {
		return "Locacao [id=" + id + ", midia=" + midia + ", valor=" + valor
				+ ", multa=" + multa + ", valorPago=" + valorPago
				+ ", promocao=" + promocao + ", dtLocacao=" + dtLocacao
				+ ", dtDevolucaoAgendada=" + dtDevolucaoAgendada
				+ ", dtDevolucao=" + dtDevolucao + ", funcionario="
				+ funcionario + ", cliente=" + cliente + "]";
	}
	
	
	
}
