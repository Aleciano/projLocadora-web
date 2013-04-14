package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import db.BancoDeDados;
import entidades.Funcionario;

public class FuncionarioDAO implements DAO<Funcionario> {
	
	BancoDeDados bd = BancoDeDados.getInstance();

	@Override
	public void save(Funcionario obj) throws SQLException,
			ClassNotFoundException {
		String sql = "INSERT INTO funcionario (nome, login, cpf, senha, logradouro, numero, bairro, cidade, cep, email, fone, celular) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		bd.conecta();
		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);
		pstm.setString(1, obj.getNome());
		pstm.setString(2, obj.getLogin());
		pstm.setString(3, obj.getCpf());
		pstm.setString(4, obj.getSenha());
		pstm.setString(5, obj.getLogradouro());
		pstm.setInt(6, obj.getNumero());
		pstm.setString(7, obj.getBairro());
		pstm.setString(8, obj.getCidade());
		pstm.setString(9, obj.getCep());
		pstm.setString(10, obj.getEmail());
		pstm.setString(11, obj.getFone());
		pstm.setString(12, obj.getCelular());
		pstm.execute();
		bd.desconectar();
	}
	
	@Override
	public void update(Funcionario obj) throws ClassNotFoundException,
			SQLException {
		String sql = "UPDATE funcionario SET nome=?, login=?, cpf=?, senha=?, logradouro=?, numero=?, bairro=?, cidade=?, cep=?, email=?, fone=?, celular=? WHERE matricula = ?";
		bd.conecta();
		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);
		pstm.setString(1, obj.getNome());
		pstm.setString(2, obj.getLogin());
		pstm.setString(3, obj.getCpf());
		pstm.setString(4, obj.getSenha());
		pstm.setString(5, obj.getLogradouro());
		pstm.setInt(6, obj.getNumero());
		pstm.setString(7, obj.getBairro());
		pstm.setString(8, obj.getCidade());
		pstm.setString(9, obj.getCep());
		pstm.setString(10, obj.getEmail());
		pstm.setString(11, obj.getFone());
		pstm.setString(12, obj.getCelular());
		pstm.setInt(13, obj.getMatricula());
		pstm.execute();
		bd.desconectar();

	}

	@Override
	public void remove(Funcionario obj) throws ClassNotFoundException,
			SQLException {
		String sql = "DELETE from funcionario WHERE matricula = ?";
		bd.conecta();
		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);
		pstm.setInt(1, obj.getMatricula());
		pstm.execute();
		bd.desconectar();

	}

	@Override
	public Funcionario get(Funcionario id) throws ClassNotFoundException,
			SQLException {
		/*
		 * String sql = "SELECT * FROM funcionario WHERE matricula = ?";
		 * bd.conecta(); PreparedStatement pstm =
		 * BancoDeDados.getConexao() .prepareStatement(sql); pstm.setInt(1,
		 * id.getMatricula()); ResultSet res = pstm.executeQuery(); Funcionario
		 * funcionario = null; while (res.next()) { funcionario = new
		 * LocadoraFactory.getFuncionario(); funcionario.setMatricula(res.getInt("matricula"));
		 * funcionario.setLogin(res.getString("login"));
		 * funcionario.setSenha(res.getString("senha"));
		 * funcionario.setNome(res.getString("nome"));
		 * funcionario.setNumero(res.getInt("numero"));
		 * funcionario.setCep(res.getString("cep"));
		 * funcionario.setEmail(res.getString("email"));
		 * funcionario.setLogradouro(res.getString("logradouro"));
		 * funcionario.setCidade(res.getString("cidade"));
		 * funcionario.setBairro(res.getString("bairro"));
		 * funcionario.setCpf(res.getString("cpf"));
		 * funcionario.setCelular(res.getString("celular"));
		 * funcionario.setFone(res.getString("fone")); } return funcionario;
		 */
		return get(id.getMatricula());
	}

	public Funcionario get(int id) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM funcionario WHERE matricula = ?";
		bd.conecta();
		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet res = pstm.executeQuery();
		Funcionario funcionario = null;
		while (res.next()) {
			funcionario = LocadoraFactory.getFuncionario();
			funcionario.setMatricula(res.getInt("matricula"));
			funcionario.setLogin(res.getString("login"));
			funcionario.setSenha(res.getString("senha"));
			funcionario.setNome(res.getString("nome"));
			funcionario.setNumero(res.getInt("numero"));
			funcionario.setCep(res.getString("cep"));
			funcionario.setEmail(res.getString("email"));
			funcionario.setLogradouro(res.getString("logradouro"));
			funcionario.setCidade(res.getString("cidade"));
			funcionario.setBairro(res.getString("bairro"));
			funcionario.setCpf(res.getString("cpf"));
			funcionario.setCelular(res.getString("celular"));
			funcionario.setFone(res.getString("fone"));

		}
		bd.desconectar();

		return funcionario;
	}

	@Override
	public Collection<Funcionario> get() throws ClassNotFoundException,
			SQLException {
		String sql = "SELECT * FROM funcionario";
		/*
		 * bd.conecta(); PreparedStatement pstm =
		 * bd.getConexao() .prepareStatement(sql); ResultSet res =
		 * pstm.executeQuery(); ArrayList<Funcionario> funcionarios = new
		 * ArrayList<Funcionario>(); while (res.next()) { Funcionario
		 * funcionario = LocadoraFactory.getFuncionario();
		 * funcionario.setMatricula(res.getInt("matricula"));
		 * funcionario.setLogin(res.getString("login"));
		 * funcionario.setSenha(res.getString("senha"));
		 * funcionario.setNome(res.getString("nome"));
		 * funcionario.setNumero(res.getInt("numero"));
		 * funcionario.setCep(res.getString("cep"));
		 * funcionario.setEmail(res.getString("email"));
		 * funcionario.setLogradouro(res.getString("logradouro"));
		 * funcionario.setCidade(res.getString("cidade"));
		 * funcionario.setBairro(res.getString("bairro"));
		 * funcionario.setCpf(res.getString("cpf"));
		 * funcionario.setCelular(res.getString("celular"));
		 * funcionario.setFone(res.getString("fone"));
		 * funcionarios.add(funcionario); } bd.desconectar();
		 */
		return get(sql);
	}

	@Override
	public Collection<Funcionario> get(String regex)
			throws ClassNotFoundException, SQLException {
		bd.conecta();
		PreparedStatement pstm = bd.getConexao().prepareStatement(
				regex);
		;
		ResultSet res = pstm.executeQuery();
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		while (res.next()) {
			Funcionario funcionario = LocadoraFactory.getFuncionario();
			funcionario.setMatricula(res.getInt("matricula"));
			funcionario.setLogin(res.getString("login"));
			funcionario.setSenha(res.getString("senha"));
			funcionario.setNome(res.getString("nome"));
			funcionario.setNumero(res.getInt("numero"));
			funcionario.setCep(res.getString("cep"));
			funcionario.setEmail(res.getString("email"));
			funcionario.setLogradouro(res.getString("logradouro"));
			funcionario.setCidade(res.getString("cidade"));
			funcionario.setBairro(res.getString("bairro"));
			funcionario.setCpf(res.getString("cpf"));
			funcionario.setCelular(res.getString("celular"));
			funcionario.setFone(res.getString("fone"));
			funcionarios.add(funcionario);

		}
		bd.desconectar();

		return funcionarios;
	}

	public Funcionario getFuncionario(String cpf)
			throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM funcionario WHERE cpf like ?";
		bd.conecta();
		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);

		pstm.setString(1, cpf);
		ResultSet res = pstm.executeQuery();
		Funcionario funcionario = null;
		while (res.next()) {

			funcionario = LocadoraFactory.getFuncionario();
			funcionario.setCpf(res.getString("cpf"));
			funcionario.setMatricula(res.getInt("matricula"));
			funcionario.setLogin(res.getString("login"));
			funcionario.setSenha(res.getString("senha"));
			funcionario.setNome(res.getString("nome"));
			funcionario.setLogradouro(res.getString("logradouro"));
			funcionario.setBairro(res.getString("bairro"));
			funcionario.setCidade(res.getString("cidade"));
			funcionario.setNumero(res.getInt("numero"));
			funcionario.setCep(res.getString("cep"));
			funcionario.setEmail(res.getString("email"));
			funcionario.setCelular(res.getString("celular"));
			funcionario.setFone(res.getString("fone"));
		}
		bd.desconectar();

		return funcionario;
	}

	public Funcionario getFuncionarioPorLogin(String login, String senha)
			throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM funcionario WHERE login like ? AND senha like ?";
		bd.conecta();
		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);

		pstm.setString(1, login);
		pstm.setString(2, (senha=="")? "*" : senha);
		ResultSet res = pstm.executeQuery();
		Funcionario funcionario = null;
		while (res.next()) {

			funcionario = LocadoraFactory.getFuncionario();
			funcionario.setCpf(res.getString("cpf"));
			funcionario.setMatricula(res.getInt("matricula"));
			funcionario.setLogin(res.getString("login"));
			funcionario.setSenha(res.getString("senha"));
			funcionario.setNome(res.getString("nome"));
			funcionario.setLogradouro(res.getString("logradouro"));
			funcionario.setBairro(res.getString("bairro"));
			funcionario.setCidade(res.getString("cidade"));
			funcionario.setNumero(res.getInt("numero"));
			funcionario.setCep(res.getString("cep"));
			funcionario.setEmail(res.getString("email"));
			funcionario.setCelular(res.getString("celular"));
			funcionario.setFone(res.getString("fone"));
		}
		bd.desconectar();

		return funcionario;
	}
	
	public Funcionario getFuncionarioPorMatricula(String matricula)
			throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM funcionario WHERE matricula = ?";
		bd.conecta();
		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);

		pstm.setString(1, matricula);
		ResultSet res = pstm.executeQuery();
		Funcionario funcionario = null;
		while (res.next()) {

			funcionario = LocadoraFactory.getFuncionario();
			funcionario.setCpf(res.getString("cpf"));
			funcionario.setMatricula(res.getInt("matricula"));
			funcionario.setLogin(res.getString("login"));
			funcionario.setSenha(res.getString("senha"));
			funcionario.setNome(res.getString("nome"));
			funcionario.setLogradouro(res.getString("logradouro"));
			funcionario.setBairro(res.getString("bairro"));
			funcionario.setCidade(res.getString("cidade"));
			funcionario.setNumero(res.getInt("numero"));
			funcionario.setCep(res.getString("cep"));
			funcionario.setEmail(res.getString("email"));
			funcionario.setCelular(res.getString("celular"));
			funcionario.setFone(res.getString("fone"));
		}
		bd.desconectar();

		return funcionario;
	}

}
