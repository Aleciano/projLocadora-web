package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.sun.org.apache.bcel.internal.generic.NEW;

import entidades.Cliente;
import entidades.DVD;
import entidades.Funcionario;
import entidades.Locacao;
import entidades.Midia;
import entidades.Multa;
import entidades.Promocao;

public class Facade {	
	
	public static void fazerLocação(Cliente cliente, Funcionario funcionario, double valor, Date data, Date data_devolucao, Midia midia, Promocao promocao){
		
	}
	
	public static void fazerLocação(Cliente cliente, Funcionario funcionario, double valor, Date data, Midia midia, Promocao promocao){
		
	}
	
	public static void fazerLocação(Cliente cliente, Funcionario funcionario, Date data, Midia midia, Promocao promocao){
//		Date dt_devolucao = data; 
//		Locacao locacao = new Locacao(midia, 5, promocao, data, dtDevolucaoAgendada, funcionario, cliente)
	}	
	
	public static void cadastrarFuncionario(String nome, String login, String senha) throws SQLException, ClassNotFoundException {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setLogin(login);
		funcionario.setSenha(senha);
		new FuncionarioDAO().save(funcionario);
	}
	
	public static void cadastrarCliente(String cpf, String nome) throws SQLException, ClassNotFoundException {
		Cliente cliente = new Cliente();
		cliente.setCpf(cpf);
		cliente.setNome(nome);
		new ClienteDAO().save(cliente);
	}
	//Comentado pois só servia para DVD e não para mídias em geral.
	/*
	public static void cadastrarMidia(String nome, String descricao, short qt,
			int duracaoMinutos, String sinopse) throws SQLException, ClassNotFoundException {
		DVD midia = new DVD(nome, descricao, qt, duracaoMinutos, sinopse);
		new DVDDAO().save(midia);
	}
	*/
	public static void cadastrar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
		new FuncionarioDAO().save(funcionario);
	}
	
	public static void cadastrar(Cliente cliente) throws SQLException, ClassNotFoundException {
		new ClienteDAO().save(cliente);
	}

	public static void cadastrar(DVD dvd) throws SQLException, ClassNotFoundException {
		
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

	public static DVD getDVD(int id) {
		return null;
	}

	public Multa getMulta(int id) {
		return null;
	}

	public Promocao getPromocao(int id) {
		return null;
	}

	public static ArrayList<Funcionario> getFuncionario() {
		return null;
	}
	
	public static ArrayList<Locacao> getLocacao() {
		return null;
	}

	public static ArrayList<Cliente> getCliente() {
		return null;
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
	
	public static void fazerLocação(Locacao locacao) throws SQLException, ClassNotFoundException{
		new LocacaoDAO().save(locacao);			
	}
	
	public static void FinalizarLocação(Locacao locacao){
		
	}
}
