package dao;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import entidades.*;

public abstract class LocadoraFactory {

	public static Cliente getCliente(String cpf) throws ClassNotFoundException, SQLException{
		return new ClienteDAO().getByCpf(cpf);
	}
	
	public static Cliente getCliente(){
		return new Cliente();
	}
	
	public static Funcionario getFuncionario(String matricula) throws ClassNotFoundException, SQLException{
		return new FuncionarioDAO().getFuncionarioPorMatricula(matricula);
	}
	
	public static Funcionario getFuncionario(){
		return new Funcionario();
	}
	
	public static DVD getDVD(short id) throws ClassNotFoundException, SQLException{
		return new DVDDAO().get(id);
	}
	
	public static DVD getDVD(){
		return new DVD();
	}
	
	public static DVD getDVD(String nome, String descricao, short qt, int duracaoMinutos, String sinopse){
		return new DVD(nome, descricao, qt, duracaoMinutos, sinopse);
	}
	
	public static Locacao getLocacao(int id) throws ClassNotFoundException, SQLException{
		return new LocacaoDAO().get(id);
	}
	
	public static Locacao getLocacao(){
		return new Locacao();
	}
	
	public static Multa getMulta( int id ){
		if (id == 0) 
			return new Multa("Sem", 0);
		if (id == 1)
			return new Multa("Branda", 5);
		if (id == 2)
			return new Multa("Severa", 10);
		return new Multa();
	}
	
	public static Multa getMulta(){
		return new Multa();
	}
	
	public static Promocao getPromocao(int id) throws ClassNotFoundException, SQLException{
		return new PromocaoDAO().get(id);
		
	}
	
	public static Promocao getPromocao(String nome, double valor, int dia, int mes, int ano){
		Calendar dfim = Calendar.getInstance();
		dfim.set(ano, mes -1, dia);
		Date d = new Date(dfim.getTimeInMillis());		
		Promocao promocao = LocadoraFactory.getPromocao();
		promocao.setDuracaoFinal(d);
		promocao.setNome(nome);
		promocao.setValor(valor);
		promocao.setDuracaoInit(new Date(Calendar.getInstance().getTimeInMillis()));
		return promocao;
	}
	
	public static Promocao getPromocao(){
		return new Promocao();
	}
	
	public static TipoLocacao getTipoLocacao(int id) throws ClassNotFoundException, SQLException{
		return new TipoLocacaoDAO().get(id);
	}
	
	public static TipoLocacao getTipoLocacao(){
		return new TipoLocacao();
	}
	
}
