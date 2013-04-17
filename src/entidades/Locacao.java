package entidades;

import java.sql.Date;

/**
 *Esta clase representa uma locacao de um produto de uma locadora.

 */
/**
	 *  Esta clase representa uma locacao de um produto de uma locadora.
	 * Ela possui um numero de identificacao, uma midia, um tipo de multa, o valor da locacao e o valor acrescido de multa se houver
	 * um tipo de promocao, a data de locacao, a data agendada para entrega da midia, a data de devolucao que aconteceu
	 * o funcionario que realizou a locacao, o cliente que locou o produto, o tipo de locacao. 
	 * @author Aleciano, Tercio e Leonardo.
	 */
public class Locacao {
	
	
	private int id;
	private Midia midia;
	private double valor; // valor já existe dentro do tipo da locação.
	private double valorPago; 
	private Date dtLocacao;
	private Date dtDevolucaoAgendada;
	private Date dtDevolucao;
	private Funcionario funcionario;
	private Cliente cliente;

	/**
	 * Construtor vazio
	 */
	public Locacao() {
		super();
//		this.tipoLocacao = new TipoLocacao();
		
	}

	/**Construtor com parametros
	 * @param id numero de identificacao da locacao
	 * @param midia mida
	 * @param valor valor da locacao
	 * @param multa  multa aplicada a locacao

	 * @param promocao promocao em vigor
	 * @param dtLocacao data que foi realizada locacao
	 * @param dtDevolucaoAgendada data de devolução agendada
	 * @param dtDevolucao data que foi encerrada a locacao de fato
	 * @param funcionario funcionario que realizou a operacao
	 * @param cliente cliente que locou o produto.
	 * @param tipoLocacao tipo de Locação através da classificação da mídia

 */
	 
	public Locacao(int id, Midia midia, double valor, Multa multa,
			double valorPago, Promocao promocao, Date dtLocacao,
			Date dtDevolucaoAgendada, Date dtDevolucao,
			Funcionario funcionario, Cliente cliente, TipoLocacao tipoLocacao) {
		super();
		this.id = id;
		this.midia = midia;
		this.valor = valor;
//		this.multa = multa;
//		this.valorPago = valorPago;
//		this.promocao = promocao;
		this.dtLocacao = dtLocacao;
		this.dtDevolucaoAgendada = dtDevolucaoAgendada;
		this.dtDevolucao = dtDevolucao;
		this.funcionario = funcionario;
		this.cliente = cliente;
//		this.tipoLocacao = tipoLocacao;
	}

	/**
	 * Retorna o numero de identificacao da locacao
	 * @return o numero de identificacao da locacao
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set o id da locacao.
	 * @param id numero de identificacao da locacao
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retorna a midia qeu foi locada.
	 * @return a midia que foi locada
	 */
	public Midia getMidia() {
		return midia;
	}

	/**
	 * Seta a midia a ser locada.
	 * @param midia
	 */
	public void setMidia(Midia midia) {
		this.midia = midia;
	}

	/**
	 * Retorna o valor da locacao.
	 * @return o valor da locacao
	 */
	public double getValor() {
	
		return this.valor;
	}

	/**
	 * Seta o valor da locacao.
	 * @param valor valor da locacao
	 */
	public void setValor(double valor) {
		this.valor = valor;
		
	}
	/**
	 * Seta valor com base em uma multa.
	 * @param multa o tipo de Multa.
	 */
	public void setValor(Multa multa) {
		this.valor = (multa != null) ? this.valor + multa.getValor() : valor;
		
	}
	/**
	 * Seta valor com base em uma promocao.
	 * @param promocao O tipo de promoção.
	 */
	public void setValor(Promocao promocao) {
		this.valor = (promocao != null) ? this.valor - promocao.getValor() : valor;
		
	}

	/**
	 * Retorna a data de locacao.
	 * @return a data de locacao
	 */
	public Date getDtLocacao() {
		return dtLocacao;
	}

	/**
	 * Seta a data de locacao.
	 * @param dtLocacao a data da locacao
	 */
	public void setDtLocacao(Date dtLocacao) {
		this.dtLocacao = dtLocacao;
	}

	/**
	 * Retorna a data agendada para devolucao.
	 * @return a data agendada para devolucao
	 */
	public Date getDtDevolucaoAgendada() {
		return dtDevolucaoAgendada;
	}

	/**
	 * Seta a data agendada para devolucao.
	 * @param dtDevolucaoAgendada data agendada para devolucao
	 */
	public void setDtDevolucaoAgendada(Date dtDevolucaoAgendada) {
		this.dtDevolucaoAgendada = dtDevolucaoAgendada;
	}

	/**
	 * Retorna a data da que foi encerrada a locacao.
	 * @return a data da que foi encerrada a locacao
	 */
	public Date getDtDevolucao() {
		return dtDevolucao;
	}

	/**
	 * Seta a data que foi encerrada a locacao.
	 * @param dtDevolucao data que foi encerrada a locacao
	 */
	public void setDtDevolucao(Date dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}

	/**
	 * Retorna o funcionario que realizou a locacao.
	 * @return o funcionario que realizou a locacao
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * Seta o funcionario que realizou a locacao.
	 * @param funcionario funcionario que realizou a locacao
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * Retorna o cliente que fez a locacao.
	 * @return o cliente que fez a locacao
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Sera o cliente que locou o produto.
	 * @param cliente cliente que locou o produto
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * Retorna String com dados da locacao.
	 * @return a String com dados da locacao
	 */
	@Override
	public String toString() {
		return "Locacao [id=" + id + ", midia=" + midia + ", valor=" + getValor()
				+ ", dtLocacao=" + dtLocacao
				+ ", dtDevolucaoAgendada=" + dtDevolucaoAgendada
				+ ", dtDevolucao=" + dtDevolucao + ", funcionario="
				+ funcionario + ", cliente=" + cliente /*+ ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";*/
				;
	}
	/**
	 * Retorna o valor pago da locacao.
	 * @return valor pago da locacao.
	 */
	public double getValorPago() {
		return valorPago;
	}
	/**
	 * Seta o valor pago da locacao.
	 * @param valorPago
	 */
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

}
