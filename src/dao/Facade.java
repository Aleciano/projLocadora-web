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

	public static int fazerLocacao(Cliente cliente, Funcionario funcionario,
			Date data, Midia midia/* , Promocao promocao , TipoLocacao tipo */)
			throws SQLException, ClassNotFoundException {
		Locacao locacao = LocadoraFactory.getLocacao();
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
		cal.add(Calendar.DAY_OF_YEAR, 2);
		locacao.setDtDevolucaoAgendada(new Date(cal.getTimeInMillis()));
		locacao.setMidia(midia);
		if (getPromocaoAberta() != null)
			locacao.setValor(Facade.getPromocaoAberta().getValor());
		// locacao.setTipoLocacao(tipo);
		new LocacaoDAO().save(locacao);
		((DVD) midia).setLocado(true);
		Facade.update((DVD) midia);
		return Facade.getLocacaoMaxId(cliente.getCpf()).getId();

	}

	public static int locarProduto(String cpf, String mat, Date data, short id)
			throws ClassNotFoundException, SQLException {

		if (getClienteByCpf(cpf) != null) {
			if (getFuncionarioPorMatricula(mat) != null) {
				DVD auxDvd = getDVD(id);
				if (auxDvd != null) {
					if (!getDVD(id).isLocado()) {
						Cliente c = getClienteByCpf(cpf);
						Funcionario f = getFuncionarioPorMatricula(mat);
						Midia m = getDVD(id);
						if (getLocacoesAbertas(cpf).size() < 3 && m != null)
							return fazerLocacao(c, f, data, m);
					}
				}
			}
		}

		return 0;

	}

	public static void fazerLocacao(Locacao locacao) throws SQLException,
			ClassNotFoundException {
		new LocacaoDAO().save(locacao);
	}

	public static void FinalizarLocacao(int id, double valor)
			throws ClassNotFoundException, SQLException {

		Calendar c = Calendar.getInstance();
		Locacao l = getLocacao(id);
		l.setDtDevolucao(new Date(c.getTimeInMillis()));
		l.setValorPago(valor);
		update(l);
		DVD d = (DVD) l.getMidia();
		d.setLocado(false);
		update(d);

	}

	public static void FinalizarLocacao(Locacao locacao, /* double valor_pago, */
			Multa multa) throws ClassNotFoundException, SQLException {

		locacao.setValor(multa);
		new LocacaoDAO().update(locacao);

		((DVD) locacao.getMidia()).setLocado(false);
		Facade.update((DVD) locacao.getMidia());
	}

	public static boolean cadastrarFuncionario(String nome, String cpf,
			String logradouro, int numero, String bairro, String cidade,
			String cep, String email, String fone, String celular,
			String login, String senha) throws SQLException,
			ClassNotFoundException {

		Funcionario funcionarioAux = null;
		funcionarioAux = getFuncionarioPorLoginESenha(login, senha);
		if (funcionarioAux != null)
			return false;

		if (Facade.isFuncionario(cpf))
			return false;

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
		funcionario.setNumero(numero);
		new FuncionarioDAO().save(funcionario);
		return true;
	}

	public static boolean cadastrarCliente(String cpf, String nome,
			String logradouro, int numero, String bairro, String cidade,
			String cep, String email, String fone, String celular)
			throws SQLException, ClassNotFoundException {
		if (Facade.isCliente(cpf))
			return false;

		Cliente cliente = LocadoraFactory.getCliente();
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
		return true;
	}

	/* Busca a ultima locacao do cliente. */
	public static Locacao getLocacaoMaxId(String cliente)
			throws ClassNotFoundException, SQLException {
		return Facade.getLocacao(LocacaoDAO.getLocacaoMaxId(cliente));

	}

	/* Busca a ultima locacao do cliente. */
	public static Double getValorUltimaLocacao(String cliente)
			throws ClassNotFoundException, SQLException {
		return Facade.getLocacao(LocacaoDAO.getLocacaoMaxId(cliente))
				.getValor();

	}

	public static void remove(String cpf) throws SQLException,
			ClassNotFoundException {
		Cliente cliente = LocadoraFactory.getCliente();
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
		DVD dvd = LocadoraFactory.getDVD(nome, descricao, qt, duracaoMinutos,
				sinopse);
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

	public static void cadastrarPromocao(String nome, double valor, int dia,
			int mes, int ano) throws SQLException, ClassNotFoundException {
		Promocao promocao = LocadoraFactory.getPromocao(nome, valor, dia, mes,
				ano);
		new PromocaoDAO().save(promocao);
	}

	public static void cadastrar(Cliente cliente) throws SQLException,
			ClassNotFoundException {

		new ClienteDAO().save(cliente);
	}

	public static boolean isCliente(String cpf) throws ClassNotFoundException,
			SQLException {
		ClienteDAO c = new ClienteDAO();

		if (c.getCliente(cpf) != null)
			return true;
		return false;
	}

	public static boolean isFuncionario(String cpf)
			throws ClassNotFoundException, SQLException {
		FuncionarioDAO f = new FuncionarioDAO();

		if (cpf.equalsIgnoreCase("") || f.getFuncionario(cpf) != null)
			return true;
		return false;
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
		DVD dvd = LocadoraFactory.getDVD();
		dvd.setId(id);
		new DVDDAO().remove(dvd);
	}

	public static ArrayList<String> getDVDs() throws SQLException,
			ClassNotFoundException {
		ArrayList<String> dvds = new ArrayList<String>();
		ArrayList<DVD> aux = (ArrayList<DVD>) new DVDDAO().get();
		for (DVD d : aux) {

			dvds.add(new String("Classificacao: " + d.getDescricao()
					+ ",\nTitulo: " + d.getNome())
					+ ",\nCodigo: " + d.getId() + ",\nLocado: " + d.isLocado());

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

	public static boolean removeLocacao(int id) throws SQLException,
			ClassNotFoundException {
		if (getLocacao(id) != null) {
			DVD d = (DVD) Facade.getLocacao(id).getMidia();
			d.setLocado(false);
			Facade.update(d);
			Locacao locacao = LocadoraFactory.getLocacao();
			locacao.setId(id);
			new LocacaoDAO().remove(locacao);
			return true;
		} else
			return false;
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
		return new ClienteDAO().getCliente(cpf);
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
	 * Retornara um array vazio se nao encontrar o DVD.
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
	 * Retornara um array vazio se na encontrar o DVD.
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

	public static ArrayList<String> getFuncionarios()
			throws ClassNotFoundException, SQLException {
		ArrayList<String> aux = new ArrayList<>();
		ArrayList<Funcionario> fun = (ArrayList<Funcionario>) new FuncionarioDAO()
				.get();
		for (Funcionario f : fun) {
			aux.add(new String("Nome: " + f.getNome() + "\nMatricula: "
					+ f.getMatricula()));

		}
		return aux;
	}

	public static Funcionario getFuncionario(String cpf)
			throws ClassNotFoundException, SQLException {
		return new FuncionarioDAO().getFuncionario(cpf);
	}

	public static Funcionario getFuncionarioPorMatricula(String matricula)
			throws ClassNotFoundException, SQLException {
		return new FuncionarioDAO().getFuncionarioPorMatricula(matricula);
	}

	public static Funcionario getFuncionario(int funcionario)
			throws ClassNotFoundException, SQLException {
		return new FuncionarioDAO().get(funcionario);
	}

	public static ArrayList<Locacao> getLocacao()
			throws ClassNotFoundException, SQLException {
		return (ArrayList<Locacao>) new LocacaoDAO().get();
	}

	public static ArrayList<String> getLocacoes()
			throws ClassNotFoundException, SQLException {
		ArrayList<Locacao> locacoes = getLocacao();
		ArrayList<String> laux = new ArrayList<String>();
		String estado = "em aberto";
		for (Locacao l : locacoes) {
			if (l.getValorPago() > 0)
				estado = "finalizada";
			else {
				estado = "em aberto";
			}
			laux.add(new String("Locação ID: " + l.getId()) + ",\n Cliente: "
					+ l.getCliente().getNome() + ",\nFuncionario: "
					+ l.getFuncionario().getNome() + ",\nID Produto: "
					+ l.getMidia().getId() + ",\nClassificacao: "
					+ l.getMidia().getDescricao() + ",\nTitulo: "
					+ l.getMidia().getNome() + ", Situacao: " + estado);
		}
		return laux;
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

			e.printStackTrace();
		} catch (SQLException e) {

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

	public static ArrayList<String> Extrato(String cpf, int idMulta)
			throws ClassNotFoundException, SQLException {

		ArrayList<String> aux = new ArrayList<String>();

		if (!isCliente(cpf))
			return null;
		String resultado = "Registro de Alugueis de "
				+ new ClienteDAO().getCliente(cpf).getNome();
		aux.add(resultado);
		ArrayList<Locacao> loc = (ArrayList<Locacao>) getLocacoes(cpf);
		Calendar c = Calendar.getInstance();
		Calendar d = Calendar.getInstance();
		int id_multa = idMulta;
		double valor_total = 0;
		for (Locacao l : loc) {
			if (l.getDtDevolucao() == null) {
				resultado = "Locação ID: " + l.getId() + ", Classificacao: "
						+ l.getMidia().getDescricao() + ", Titulo: "
						+ l.getMidia().getNome() + ", Valor: " + l.getValor();
				d.setTime(l.getDtDevolucaoAgendada());
				if (id_multa == 0) {
					int dias = (int) ((c.getTimeInMillis() - d
							.getTimeInMillis()) / (1000 * 60 * 60 * 24));
					if (dias > 2 && dias < 10)
						id_multa = 2;
					if (dias >= 10)
						id_multa = 3;
					if (dias <= 0)
						id_multa = 1;
				}

				resultado += ", multa: " + getMulta(id_multa).getNome()
						+ ", valor: " + getMulta(id_multa).getValor();
				valor_total += (l.getValor() + getMulta(id_multa).getValor());
				aux.add(resultado);

			}
		}
		aux.add(new String("Divida Total: " + valor_total));
		return aux;
	}

}
