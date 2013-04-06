package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import entidades.*;

public class Facade {
	// TODO alterar para receber promocoes
	public static int fazerLocacao(Cliente cliente, Funcionario funcionario,
			Date data, Midia midia/* , Promocao promocao , TipoLocacao tipo */)
			throws SQLException, ClassNotFoundException {
		Locacao locacao = new Locacao();
		locacao.setCliente(cliente);
		locacao.setFuncionario(funcionario);
		locacao.setDtLocacao(data);
		TipoLocacao tipo = null;

		tipo = (Facade.getTipoLocacao(midia.getDescricao())).get(0);
		if (tipo == null)
			return 0;
		else
			locacao.setValor(tipo.getValor_locacao());

		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date(data.getYear(), data.getMonth(), tipo
				.getnDiasLocacao() + data.getDate()));
		locacao.setDtDevolucaoAgendada(new Date(cal.getTime().getTime()));

		locacao.setMidia(midia);
		locacao.setValor(Facade.getPromocaoAberta());
		// locacao.setTipoLocacao(tipo);

		new LocacaoDAO().save(locacao);
		((DVD) midia).setLocado(true);
		Facade.update((DVD) midia);
		return Facade.getLocacaoMaxId(cliente.getCpf()).getId();

	}

	public static void fazerLocacao(Locacao locacao) throws SQLException,
			ClassNotFoundException {
		new LocacaoDAO().save(locacao);
	}

	public static void FinalizarLocao(Locacao locacao, /* double valor_pago, */
			Multa multa) throws ClassNotFoundException, SQLException {

		locacao.setValor(multa);
		// locacao.setDtDevolucao(new Date(System.currentTimeMillis()));

		new LocacaoDAO().update(locacao);

		((DVD) locacao.getMidia()).setLocado(false);
		Facade.update((DVD) locacao.getMidia());
	}

	public static void cadastrarFuncionario(String nome, String cpf,
			String logradouro, int numero, String bairro, String cidade,
			String cep, String email, String fone, String celular,
			String login, String senha) throws SQLException,
			ClassNotFoundException {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setLogin(login);
		funcionario.setSenha(senha);
		funcionario.setBairro(bairro);
		funcionario.setCelular(celular);
		funcionario.setCep(cep);
		funcionario.setCidade(cidade);
		funcionario.setCpf(cpf);
		funcionario.setEmail(email);
		funcionario.setFone(fone);
		funcionario.setLogradouro(logradouro);
		funcionario.setNome(nome);
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

	/* Busca a última locação do cliente. */
	public static Locacao getLocacaoMaxId(String cliente)
			throws ClassNotFoundException, SQLException {
		return Facade.getLocacao(LocacaoDAO.getLocacaoMaxId(cliente));

	}

	/* Busca a última locação do cliente. */
	public static Double getValorUltimaLocacao(String cliente)
			throws ClassNotFoundException, SQLException {
		return Facade.getLocacao(LocacaoDAO.getLocacaoMaxId(cliente))
				.getValor();

	}

	public static void remove(String cpf) throws SQLException,
			ClassNotFoundException {
		Cliente cliente = new Cliente();
		cliente.setCpf(cpf);
		new ClienteDAO().remove(cliente);
	}

	public static void cadastrarFuncionario(String nome, String login,
			String senha) throws SQLException, ClassNotFoundException {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setLogin(login);
		funcionario.setSenha(senha);
		new FuncionarioDAO().save(funcionario);
	}

	public static void cadastrar(Funcionario funcionario) throws SQLException,
			ClassNotFoundException {
		new FuncionarioDAO().save(funcionario);
	}

	public static void cadastrar(TipoLocacao tipo) throws SQLException,
			ClassNotFoundException {
		new TipoLocacaoDAO().save(tipo);
	}

	public static void cadastrar(DVD dvd) throws SQLException,
			ClassNotFoundException {
		new DVDDAO().save(dvd);
	}
	
	public static void cadastrarDvd(String nome, String descricao, short qt,
			int duracaoMinutos, String sinopse) throws SQLException,
			ClassNotFoundException {
		DVD dvd = new DVD(nome, descricao, qt, duracaoMinutos, sinopse);
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

	public static void update(TipoLocacao tipo) throws SQLException,
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

	public static void removeDVD(int id) throws SQLException,
		ClassNotFoundException {
			DVD dvd = new DVD();
			dvd.setId(id);
			new DVDDAO().remove(dvd);
	}

	
	public static ArrayList<String> getDVDs() throws SQLException,
			ClassNotFoundException {
		ArrayList<String> dvds = new ArrayList<String>();
		ArrayList<DVD> aux = (ArrayList<DVD>) new DVDDAO().get();
		for (DVD d : aux) {
			dvds.add(new String("Classificacao: " + d.getDescricao()
					+ "\ntitulo: " + d.getNome()));

		}
		return dvds;
	}
	
	public static void remove(Multa multa) throws SQLException,
			ClassNotFoundException {
		new MultaDAO().remove(multa);
	}

	public static void remove(int multa) throws SQLException,
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

	public static Funcionario getFuncionarioPorLoginESenha(String login,
			String senha) throws SQLException, ClassNotFoundException {
		return new FuncionarioDAO().getFuncionarioPorLogin(login, senha);
	}

	public static Locacao getLocacao(int id) throws ClassNotFoundException,
			SQLException {
		return new LocacaoDAO().get(id);
	}

	public static Collection<Locacao> getLocacoes(String cliente)
			throws ClassNotFoundException, SQLException {
		return new LocacaoDAO().getByCliente(cliente);
	}

	public static Collection<Locacao> getLocacoesAbertas(String cliente)
			throws ClassNotFoundException, SQLException {
		return new LocacaoDAO().getLocacoesAbertasByCliente(cliente);
	}

	public static Collection<Locacao> getLocacoesAbertas()
			throws ClassNotFoundException, SQLException {
		return new LocacaoDAO().getLocacoesAbertas();
	}

	public static Cliente getClienteByCpf(String cpf)
			throws ClassNotFoundException, SQLException {
		return new ClienteDAO().getByCpf(cpf);
	}

	public static Collection<Cliente> getCliente(String nome)
			throws ClassNotFoundException, SQLException {
		return new ClienteDAO().getByNome(nome);
	}

	public static DVD getDVD(int id) throws SQLException,
			ClassNotFoundException {
		return new DVDDAO().get(id);
	}

	/*
	 * Retornará¡ um array vazio se não encontrar o DVD.
	 */
	public static Collection<DVD> getDVD(String nome) throws SQLException,
			ClassNotFoundException {
		if (nome.equalsIgnoreCase("T") || nome == null)
			return getDVD();
		else
			return new DVDDAO().getTodosDvds(nome);
	}

	public static Collection<DVD> getDVDNaoLocados(String nome)
			throws SQLException, ClassNotFoundException {
		if (nome.equalsIgnoreCase("T") || nome == null)
			return getDVD();
		else
			return new DVDDAO().getDvdsNaoLocados(nome);
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

	public static Collection<Multa> getMultaPorNome(String nome)
			throws ClassNotFoundException, SQLException {
		return new MultaDAO().getMultaPorNome(nome);
	}

	public static ArrayList<Multa> getMulta() throws ClassNotFoundException,
			SQLException {
		return (ArrayList<Multa>) new MultaDAO().get();
	}

	public static Promocao getPromocaoAberta() throws ClassNotFoundException,
			SQLException {
		return new PromocaoDAO().getAbertas();
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

	public static Funcionario getFuncionario(String cpf)
			throws ClassNotFoundException, SQLException {
		return new FuncionarioDAO().getFuncionario(cpf);
	}

	public static Funcionario getFuncionario(int funcionario)
			throws ClassNotFoundException, SQLException {
		return new FuncionarioDAO().get(funcionario);
	}

	public static ArrayList<Locacao> getLocacao()
			throws ClassNotFoundException, SQLException {
		return (ArrayList<Locacao>) new LocacaoDAO().get();
	}

	public static ArrayList<Promocao> getPromocao()
			throws ClassNotFoundException, SQLException {
		return (ArrayList<Promocao>) new PromocaoDAO().get();
	}

	public static ArrayList<TipoLocacao> getTipoLocacao()
			throws ClassNotFoundException, SQLException {
		return (ArrayList<TipoLocacao>) new TipoLocacaoDAO().get();
	}

	public static ArrayList<TipoLocacao> getTipoLocacao(String descricao)
			throws ClassNotFoundException, SQLException {
		return ((ArrayList<TipoLocacao>) (new TipoLocacaoDAO()
				.getTipoByNome(descricao)));
	}

	public static boolean validarLogin(String login, String Senha) {

		FuncionarioDAO f = new FuncionarioDAO();
		try {
			ArrayList<Funcionario> funcionarios = (ArrayList<Funcionario>) f
					.get();
			for (Funcionario f1 : funcionarios) {
				if (f1.getLogin().equals(login) && f1.getSenha().equals(Senha))
					return true;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public static ArrayList<String> getCliente() throws ClassNotFoundException,
			SQLException {
		ArrayList<Cliente> cs = (ArrayList<Cliente>) new ClienteDAO().get();
		ArrayList<String> clientes = new ArrayList<String>();
		for (Cliente c : cs) {
			clientes.add("Nome: " + c.getNome() + "\nCPF: " + c.getCpf() + "\n");
		}
		return clientes;
	}
}
