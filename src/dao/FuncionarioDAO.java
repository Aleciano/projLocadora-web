package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import db.BancoDeDados;

import entidades.Funcionario;

public class FuncionarioDAO implements DAO<Funcionario> {

	@Override
	public void save(Funcionario obj) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO funcionario (nome, login, senha) VALUES (?, ?, ?)";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setString(1, obj.getNome());
		pstm.setString(2, obj.getLogin());
		pstm.setString(3, obj.getSenha());
		pstm.execute();
		BancoDeDados.desconectar();		
	}

	@Override
	public void update(Funcionario obj) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE funcionario (nome, login, senha) SET (?, ?, ?) WHERE matricula = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setString(1, obj.getNome());
		pstm.setString(2, obj.getLogin());
		pstm.setString(3, obj.getSenha());
		pstm.setInt(4, obj.getMatricula());
		pstm.execute();
		BancoDeDados.desconectar();
		
	}

	@Override
	public void remove(Funcionario obj) throws ClassNotFoundException, SQLException {
		String sql = "DELETE funcionario WHERE matricula = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setInt(1, obj.getMatricula());
		pstm.execute();
		BancoDeDados.desconectar();
		
	}

	
	public Funcionario get(int id) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM funcionario WHERE matricula = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);;
		pstm.setInt(1, id);
		ResultSet res = pstm.executeQuery();
		Funcionario funcionario =  null;
		while (res.next()){
			funcionario = new Funcionario();
			funcionario.setMatricula(res.getInt("matricula"));
			funcionario.setLogin(res.getString("login"));
			funcionario.setSenha(res.getString("senha"));
			funcionario.setNome(res.getString("nome"));
		}
		BancoDeDados.desconectar();
		
		return funcionario;
	}

	@Override
	public Collection<Funcionario> get() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM funcionario";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);;
		ResultSet res = pstm.executeQuery();
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		while (res.next()){
			Funcionario funcionario = new Funcionario();
			funcionario.setMatricula(res.getInt("matricula"));
			funcionario.setLogin(res.getString("login"));
			funcionario.setSenha(res.getString("senha"));
			funcionario.setNome(res.getString("nome"));
			funcionarios.add(funcionario);
		}
		BancoDeDados.desconectar();
		
		return funcionarios;
	}

	@Override
	public Collection<Funcionario> get(String regex) throws ClassNotFoundException, SQLException {
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(regex);;
		ResultSet res = pstm.executeQuery();
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		while (res.next()){
			Funcionario funcionario = new Funcionario();
			funcionario.setMatricula(res.getInt("matricula"));
			funcionario.setLogin(res.getString("login"));
			funcionario.setSenha(res.getString("senha"));
			funcionario.setNome(res.getString("nome"));
			funcionarios.add(funcionario);
		}
		BancoDeDados.desconectar();
		
		return funcionarios;
	}
	
	public Collection<Funcionario> getOndeNomeComecaComA() throws ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM funcionario WHERE nome LIKE 'A%'";
		
		return get(sql);
	}

	@Override
	public Funcionario get(Funcionario id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
