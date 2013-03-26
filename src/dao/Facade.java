package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

//import com.sun.org.apache.bcel.internal.generic.NEW;

import entidades.Cliente;
import entidades.DVD;
import entidades.Funcionario;
import entidades.Locacao;
import entidades.Midia;
import entidades.Multa;
import entidades.Promocao;

public class Facade {

	public static void fazerLocao(Cliente cliente, Funcionario funcionario,
			double valor, Date data, Date data_devolucao, Midia midia,
			Promocao promocao) {

	}

	public static void fazerLocao(Cliente cliente, Funcionario funcionario,
			double valor, Date data, Midia midia, Promocao promocao) {

	}

	public static void fazerLocao(Cliente cliente, Funcionario funcionario,
			Date data, Midia midia, Promocao promocao) throws SQLException,
			ClassNotFoundException {
		Locacao locacao = new Locacao();
		locacao.setCliente(cliente);
		locacao.setFuncionario(funcionario);
		locacao.setDtLocacao(data);

		Calendar cal = Calendar.getInstance();

		cal.setTime(new java.util.Date(data.getYear(), data.getMonth(),
				2 + data.getDate()));
		// cal.setTime(data);
		locacao.setDtDevolucaoAgendada(new Date(cal.getTime().getTime()));
		locacao.setMidia(midia);
		locacao.setValor(3);

		new LocacaoDAO().save(locacao);

	}

	public static void cadastrarFuncionario(String nome, String login,
			String senha) throws SQLException, ClassNotFoundException {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setLogin(login);
		funcionario.setSenha(senha);
		new FuncionarioDAO().save(funcionario);
	}

	public static void cadastrarCliente(Cliente cliente) throws SQLException,
			ClassNotFoundException {

		new ClienteDAO().save(cliente);
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

	// Comentado pois só servia para DVD e não para mídias em geral.
	/*
	 * public static void cadastrarMidia(String nome, String descricao, short
	 * qt, int duracaoMinutos, String sinopse) throws SQLException,
	 * ClassNotFoundException { DVD midia = new DVD(nome, descricao, qt,
	 * duracaoMinutos, sinopse); new DVDDAO().save(midia); }
	 */
	public static void cadastrar(Funcionario funcionario) throws SQLException,
			ClassNotFoundException {
		new FuncionarioDAO().save(funcionario);
	}

	public static void cadastrar(Cliente cliente) throws SQLException,
			ClassNotFoundException {
		new ClienteDAO().save(cliente);
	}

	public static void cadastrar(DVD dvd) throws SQLException,
			ClassNotFoundException {

		new DVDDAO().save(dvd);
	}

	public static void cadastrar(Multa multa) {

	}

	public static void cadastrar(Promocao promocao) {

	}

	public static Funcionario getFuncionario(int id) {
		return null;
	}

	public static Locacao getLocacao(int id) {
		return null;
	}

	public static Cliente getCliente(int id) {
		return null;
	}

	public static DVD getDVD(int id) throws SQLException,
			ClassNotFoundException {
		return new DVDDAO().get(id);
	}

	public Multa getMulta(int id) {
		return null;
	}

	public Promocao getPromocao(int id) {
		return null;
	}

	public static ArrayList<Funcionario> getFuncionario()
			throws ClassNotFoundException, SQLException {
		return (ArrayList<Funcionario>) new FuncionarioDAO().get();
	}

	public static ArrayList<Locacao> getLocacao() {
		return null;
	}

	public static ArrayList<Cliente> getCliente()
			throws ClassNotFoundException, SQLException {
		return (ArrayList<Cliente>) new ClienteDAO().get();
	}

	public static ArrayList<DVD> getDVD() {
		return null;
	}

	public static ArrayList<Multa> getMulta() {
		return null;
	}

	public static ArrayList<Promocao> getPromocao() {
		return null;
	}

	public static void fazerLocao(Locacao locacao) throws SQLException,
			ClassNotFoundException {
		new LocacaoDAO().save(locacao);
	}

	public static void FinalizarLocao(Locacao locacao) {

	}
}
