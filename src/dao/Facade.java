package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import entidades.Cliente;
import entidades.DVD;
import entidades.Funcionario;
import entidades.Locacao;
import entidades.Midia;
import entidades.Multa;
import entidades.Promocao;
import entidades.TipoLocacao;

public class Facade {

	public static void fazerLocao(Cliente cliente, Funcionario funcionario,
			double valor, Date data, Midia midia, Promocao promocao,
			TipoLocacao tipo) throws SQLException, ClassNotFoundException {
		Locacao locacao = new Locacao();
		locacao.setCliente(cliente);
		locacao.setFuncionario(funcionario);
		locacao.setDtLocacao(data);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date(data.getYear(), data.getMonth(),
				2 + data.getDate()));
		locacao.setDtDevolucaoAgendada(new Date(cal.getTime().getTime()));
		locacao.setMidia(midia);
		locacao.setTipoLocacao(tipo);
		locacao.setValor(valor);

		new LocacaoDAO().save(locacao);
	}

	public static void fazerLocao(Cliente cliente, Funcionario funcionario,
			Date data, Midia midia, Promocao promocao, TipoLocacao tipo)
			throws SQLException, ClassNotFoundException {
		Locacao locacao = new Locacao();
		locacao.setCliente(cliente);
		locacao.setFuncionario(funcionario);
		locacao.setDtLocacao(data);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date(data.getYear(), data.getMonth(),
				2 + data.getDate()));
		locacao.setDtDevolucaoAgendada(new Date(cal.getTime().getTime()));
		locacao.setMidia(midia);
		locacao.setTipoLocacao(tipo);
		locacao.setValor(3);

		new LocacaoDAO().save(locacao);

	}

	public static void fazerLocao(Locacao locacao) throws SQLException,
			ClassNotFoundException {
		new LocacaoDAO().save(locacao);
	}

	public static void FinalizarLocao(Locacao locacao, double valor_pago,
			Multa multa) throws ClassNotFoundException, SQLException {
		locacao.setValor(valor_pago);
		locacao.setDtDevolucao(new Date(System.currentTimeMillis()));
		locacao.setMulta(multa);
		new LocacaoDAO().update(locacao);
	}

	public static void cadastrarFuncionario(String nome, String login,
			String senha) throws SQLException, ClassNotFoundException {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setLogin(login);
		funcionario.setSenha(senha);
		new FuncionarioDAO().save(funcionario);
	}

	public static void cadastrarCliente(String cpf, String nome,
			String logradouro, int numero, String bairro, String cidade,
			String cep, String email, String fone, String celular)
			throws SQLException, ClassNotFoundException {
		Cliente cliente = new Cliente();
		cliente.setCpf(cpf);
		cliente.setNome(nome);
		cliente.setLogradouro(logradouro);
		cliente.setNumero(numero);
		cliente.setBairro(bairro);
		cliente.setCidade(cidade);
		cliente.setCep(cep);
		cliente.setEmail(email);
		cliente.setFone(fone);
		cliente.setCelular(celular);

		new ClienteDAO().save(cliente);
	}

	public static void cadastrar(Funcionario funcionario) throws SQLException,
			ClassNotFoundException {
		new FuncionarioDAO().save(funcionario);
	}

	public void cadastrar(TipoLocacao tipo) throws SQLException,
			ClassNotFoundException {
		new TipoLocacaoDAO().save(tipo);
	}

	public static void cadastrar(DVD dvd) throws SQLException,
			ClassNotFoundException {
		new DVDDAO().save(dvd);
	}

	public static void cadastrar(Multa multa) throws SQLException,
			ClassNotFoundException {
		new MultaDAO().save(multa);
	}

	public static void cadastrar(Promocao promocao) throws SQLException,
			ClassNotFoundException {
		new PromocaoDAO().save(promocao);
	}

	public static void cadastrar(Cliente cliente) throws SQLException,
			ClassNotFoundException {

		new ClienteDAO().save(cliente);
	}

	public static void update(Funcionario funcionario) throws SQLException,
			ClassNotFoundException {
		new FuncionarioDAO().update(funcionario);
	}

	public static void update(Cliente cliente) throws SQLException,
			ClassNotFoundException {
		new ClienteDAO().update(cliente);
	}

	public static void update(DVD dvd) throws SQLException,
			ClassNotFoundException {
		new DVDDAO().update(dvd);
	}

	public static void update(Multa multa) throws SQLException,
			ClassNotFoundException {
		new MultaDAO().update(multa);
	}

	public static void update(Promocao promocao) throws SQLException,
			ClassNotFoundException {
		new PromocaoDAO().update(promocao);
	}

	public static void update(Locacao locacao) throws SQLException,
			ClassNotFoundException {
		new LocacaoDAO().update(locacao);
	}

	public void update(TipoLocacao tipo) throws SQLException,
			ClassNotFoundException {
		new TipoLocacaoDAO().update(tipo);
	}

	public static void remove(Funcionario funcionario) throws SQLException,
			ClassNotFoundException {
		new FuncionarioDAO().remove(funcionario);
	}

	public static void remove(Cliente cliente) throws SQLException,
			ClassNotFoundException {
		new ClienteDAO().remove(cliente);
	}

	public static void remove(DVD dvd) throws SQLException,
			ClassNotFoundException {
		new DVDDAO().remove(dvd);
	}

	public static void remove(Multa multa) throws SQLException,
			ClassNotFoundException {
		new MultaDAO().remove(multa);
	}

	public static void remove(Promocao promocao) throws SQLException,
			ClassNotFoundException {
		new PromocaoDAO().remove(promocao);
	}

	public static void remove(Locacao locacao) throws SQLException,
			ClassNotFoundException {
		new LocacaoDAO().remove(locacao);
	}

	public static void remove(TipoLocacao tipo) throws SQLException,
			ClassNotFoundException {
		new TipoLocacaoDAO().remove(tipo);
	}

	public static Funcionario getFuncionario(int id) throws SQLException,
			ClassNotFoundException {
		return new FuncionarioDAO().get(id);
	}

	public static Locacao getLocacao(int id) throws ClassNotFoundException,
			SQLException {
		return new LocacaoDAO().get(id);
	}

	public static Cliente getCliente(String cpf) throws ClassNotFoundException,
			SQLException {
		return new ClienteDAO().getByCpf(cpf);
	}

	public static DVD getDVD(int id) throws SQLException,
			ClassNotFoundException {
		return new DVDDAO().get(id);
	}
	/*
	 * Retornará um array vazio se não encontrar o DVD.
	 */
	public static Collection<DVD> getDVD(String nome) throws SQLException,
			ClassNotFoundException {
		return new DVDDAO().getDvdPorNome(nome);
	}
	/*
	 * Retornará um array vazio se não encontrar o DVD.
	 */
	public static ArrayList<DVD> getDVD() throws SQLException,
			ClassNotFoundException {
		return (ArrayList<DVD>) new DVDDAO().get();
	}

	public static Multa getMulta(int id) throws ClassNotFoundException,
			SQLException {
		return new MultaDAO().get(id);
	}

	public static Promocao getPromocao(int id) throws ClassNotFoundException,
			SQLException {
		return new PromocaoDAO().get(id);
	}

	public static TipoLocacao getTipoLocacao(int id)
			throws ClassNotFoundException, SQLException {
		return new TipoLocacaoDAO().get(id);
	}

	public static ArrayList<Funcionario> getFuncionario()
			throws ClassNotFoundException, SQLException {
		return (ArrayList<Funcionario>) new FuncionarioDAO().get();
	}

	public static ArrayList<Locacao> getLocacao()
			throws ClassNotFoundException, SQLException {
		return (ArrayList<Locacao>) new LocacaoDAO().get();
	}

	public static ArrayList<Cliente> getCliente()
			throws ClassNotFoundException, SQLException {
		return (ArrayList<Cliente>) new ClienteDAO().get();
	}

	public static ArrayList<Multa> getMulta() throws ClassNotFoundException,
			SQLException {
		return (ArrayList<Multa>) new MultaDAO().get();
	}

	public static ArrayList<Promocao> getPromocao()
			throws ClassNotFoundException, SQLException {
		return (ArrayList<Promocao>) new PromocaoDAO().get();
	}

	public static ArrayList<TipoLocacao> getTipoLocacao()
			throws ClassNotFoundException, SQLException {
		return (ArrayList<TipoLocacao>) new TipoLocacaoDAO().get();
	}
}
