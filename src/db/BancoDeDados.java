package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Conectar e fazer requisicoes ao mysql
 * 
 * @author Leonardo Cartaxo
 * 
 */
public class BancoDeDados {

	private static String driverJDBC = "com.mysql.jdbc.Driver";
	private static String domain = "jdbc:mysql://localhost/locadora_video";
	private static String user = "guest";
	private static String pass = "123";
	private static Connection con;
	private static Statement stm;

	public static void conecta() throws ClassNotFoundException, SQLException {
		Class.forName(driverJDBC);
		con = DriverManager.getConnection(domain, user, pass);
	}

	public static void desconectar() throws SQLException {
		con.close();
	}

	public static void setParametros(String driver, String url, String login,
			String senha) {
		driverJDBC = driver;
		domain = url;
		user = login;
		pass = senha;
	}

	public static String getDriverJDBC() {
		return driverJDBC;
	}

	public static void setDriverJDBC(String driverJDBC) {
		BancoDeDados.driverJDBC = driverJDBC;
	}

	public static String getUrl() {
		return domain;
	}

	public static void setUrl(String url) {
		BancoDeDados.domain = url;
	}

	public static String getLogin() {
		return user;
	}

	public static void setLogin(String login) {
		BancoDeDados.user = login;
	}

	public static String getSenha() {
		return pass;
	}

	public static void setSenha(String senha) {
		BancoDeDados.pass = senha;
	}

	public static Connection getConexao() {
		return con;
	}

	public static void setCon(Connection con) {
		BancoDeDados.con = con;
	}

	public static Statement getStm() {
		return stm;
	}

	public static void setStm(Statement stm) {
		BancoDeDados.stm = stm;
	}
}