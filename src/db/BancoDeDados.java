package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Conectar e fazer requisicoes ao mysql
 * 
 * 
 *  */
public class BancoDeDados {

	private  String driverJDBC = "com.mysql.jdbc.Driver";
	private  String domain = "jdbc:mysql://localhost/locadora_video";
	private  String user = "guest";
	private  String pass = "123";
	private  Connection con;
	private  Statement stm;
	private static final BancoDeDados bancoDeDados = new BancoDeDados();
	
	

	private BancoDeDados() {
		super();
	}
	
	public static BancoDeDados getInstance(){
		return bancoDeDados;
	}

	public  void conecta() throws ClassNotFoundException, SQLException {
		Class.forName(driverJDBC);
		con = DriverManager.getConnection(domain, user, pass);
	}

	public  void desconectar() throws SQLException {
		con.close();
	}

	public  void setParametros(String driver, String url, String login,
			String senha) {
		driverJDBC = driver;
		domain = url;
		user = login;
		pass = senha;
	}

	public  String getDriverJDBC() {
		return driverJDBC;
	}

	public  void setDriverJDBC(String driverJDBC) {
		this.driverJDBC = driverJDBC;
	}

	public  String getUrl() {
		return domain;
	}

	public  void setUrl(String url) {
		this.domain = url;
	}

	public  String getLogin() {
		return user;
	}

	public  void setLogin(String login) {
		this.user = login;
	}

	public  String getSenha() {
		return pass;
	}

	public  void setSenha(String senha) {
		this.pass = senha;
	}

	public  Connection getConexao() {
		return con;
	}

	public  void setCon(Connection con) {
		this.con = con;
	}

	public  Statement getStm() {
		return stm;
	}

	public  void setStm(Statement stm) {
		this.stm = stm;
	}
}