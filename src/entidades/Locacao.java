package entidades;

import java.sql.Date;

/**
 * @author tercio
 *Esta clase simula uma locacao de um produto de uma locadora
 *Ela possui
 *um numero de identificacao @param id
 *uma Midia @param midia
 *um valor @param valor
 *um tipo de multa @param multa
 *o valor pago @param valorPago 
 *um tipo de promocao @param promocao
 *a data de locacao @param dtLocacao
 *a data agendada para entrega da midia @param dtDevolucaoAgendada 
 * a data de devolucao @param dtDevolucao
 * o funcionario que realizou a locacao @param funcionario
 * o cliente que locou a midia @param cliente
 * o tipo de locacao @param tipoLocacao  
 */


public class Locacao {

	private int id;
	private Midia midia;
//	private double valor; // valor já existe dentro do tipo da locação.
	private Multa multa;
	private double valorPago;
	private Promocao promocao;
	private Date dtLocacao;
	private Date dtDevolucaoAgendada;
	private Date dtDevolucao;
	private Funcionario funcionario;
	private Cliente cliente;
	private TipoLocacao tipoLocacao;

	/**
	 * construtor vazio
	 */
	public Locacao() {
		super();
		this.tipoLocacao = new TipoLocacao();
		// TODO Auto-generated constructor stub
	}

	/**construtor com parametros
	 * @param id numero de identificacao da locacao
	 * @param midia mida
//	 * @param valor valor da locacao
	 * @param multa  multa aplicada a locacao
	 * @param valorPago valor que o cliente  pagou
	 * @param promocao promocao em vigor
	 * @param dtLocacao data que foi realizada locacao
	 * @param dtDevolucaoAgendada data em que deve ser encerrada a locacao
	 * @param dtDevolucao data que foi encerrada a locacao
	 * @param funcionario funcionario que realizou a locacao
	 * @param cliente cliente que fez a locacao
	 * @param tipoLocacao o tipo de locacao
	 */
	public Locacao(int id, Midia midia, double valor, Multa multa,
			double valorPago, Promocao promocao, Date dtLocacao,
			Date dtDevolucaoAgendada, Date dtDevolucao,
			Funcionario funcionario, Cliente cliente, TipoLocacao tipoLocacao) {
		super();
		this.id = id;
		this.midia = midia;
//		this.valor = valor;
		this.multa = multa;
		this.valorPago = valorPago;
		this.promocao = promocao;
		this.dtLocacao = dtLocacao;
		this.dtDevolucaoAgendada = dtDevolucaoAgendada;
		this.dtDevolucao = dtDevolucao;
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.tipoLocacao = tipoLocacao;
	}

	/**
	 * @return o numero de identificacao da locacao
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id numero de identificacao da locacao
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return a midia que foi locada
	 */
	public Midia getMidia() {
		return midia;
	}

	/**
	 * @param midia
	 */
	public void setMidia(Midia midia) {
		this.midia = midia;
	}

	/**
	 * @return valor da locacao
	 */
	public double getValor() {
		return tipoLocacao.getValor_locacao();
	}

	/**
	 * @param valor valor da locacao
	 */
	public void setValor(double valor) {
		this.tipoLocacao.setValor_locacao(valor);
	}

	/**
	 * @return multa
	 */
	public Multa getMulta() {
		return multa;
	}

	/**
	 * @param multa multa da locacao
	 */
	public void setMulta(Multa multa) {
		this.multa = multa;
	}

	/**
	 * @return valor pago pelo cliente
	 */
	public double getValorPago() {
		return valorPago;
	}

	/**
	 * @param valorPago valor que cliente vai pagar
	 */
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	/**
	 * @return a promocao
	 */
	public Promocao getPromocao() {
		return promocao;
	}

	/**
	 * @param promocao uma promocao
	 */
	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}

	/**
	 * @return a data de locacao
	 */
	public Date getDtLocacao() {
		return dtLocacao;
	}

	/**
	 * @param dtLocacao a data da locacao
	 */
	public void setDtLocacao(Date dtLocacao) {
		this.dtLocacao = dtLocacao;
	}

	/**
	 * @return a data agendada para devolucao
	 */
	public Date getDtDevolucaoAgendada() {
		return dtDevolucaoAgendada;
	}

	/**
	 * @param dtDevolucaoAgendada data agendada para devolucao
	 */
	public void setDtDevolucaoAgendada(Date dtDevolucaoAgendada) {
		this.dtDevolucaoAgendada = dtDevolucaoAgendada;
	}

	/**
	 * @return a data da que foi encerrada a locacao
	 */
	public Date getDtDevolucao() {
		return dtDevolucao;
	}

	/**
	 * @param dtDevolucao data que foi encerrada a locacao
	 */
	public void setDtDevolucao(Date dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}

	/**
	 * @return o funcionario que realizou a locacao
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario funcionario que realizou a locacao
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return o cliente que fez a locacao
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente cliente que locou produto
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return tipo de locacao
	 */
	public TipoLocacao getTipoLocacao() {
		return tipoLocacao;
	}

	/**
	 * @param tipoLocacao um tipo de locacao
	 */
	public void setTipoLocacao(TipoLocacao tipoLocacao) {
		this.tipoLocacao = tipoLocacao;
	}

	@Override
	public String toString() {
		return "Locacao [id=" + id + ", midia=" + midia + ", valor=" + tipoLocacao.getValor_locacao()
				+ ", multa=" + multa + ", valorPago=" + valorPago
				+ ", promocao=" + promocao + ", dtLocacao=" + dtLocacao
				+ ", dtDevolucaoAgendada=" + dtDevolucaoAgendada
				+ ", dtDevolucao=" + dtDevolucao + ", funcionario="
				+ funcionario + ", cliente=" + cliente + ", tipoLocacao="
				+ tipoLocacao /*+ ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";*/
				;
	}

}
