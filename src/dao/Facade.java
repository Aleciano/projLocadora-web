package dao;

import java.sql.Date;
import java.util.ArrayList;

import entidades.Cliente;
import entidades.DVD;
import entidades.Funcionario;
import entidades.Locacao;
import entidades.Midia;
import entidades.Multa;
import entidades.Promocao;

public class Facade {
	
	
	public static void cadastrar(Funcionario funcionario) {
	}

	public static void cadastrar(Cliente cliente) {
		new ClienteDAO().save(cliente);
	}

	public static void cadastrar(DVD dvd) {

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
	
	public static void fazerLocação(Cliente cliente, Funcionario funcionario, double valor, Date data, Midia midia, Promocao promocao){
		
	}
	
	public static void fazerLocação(Locacao locacao){
		
	}
	
	public static void FinalizarLocação(Locacao locacao){
		
	}
}
