package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import db.BancoDeDados;

import entidades.Cliente;


public class ClienteDAO implements DAO<Cliente> {

	@Override
	public void save(Cliente obj) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO cliente (cpf, nome, logradouro, numero, bairro, cidade, cep, email, fone, celular) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		pstm.setString(1, obj.getCpf());
		pstm.setString(2, obj.getNome());
		pstm.setString(3, obj.getLogradouro());
		pstm.setInt(4, obj.getNumero());
		pstm.setString(5, obj.getBairro());
		pstm.setString(6, obj.getCidade());
		pstm.setString(7, obj.getCep());
		pstm.setString(8, obj.getEmail());
		pstm.setString(9, obj.getFone());
		pstm.setString(10, obj.getCelular());
		pstm.execute();

		BancoDeDados.desconectar();
	}

	@Override
	public void update(Cliente obj) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE cliente (cpf, nome) SET (?, ?) WHERE cpf = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		pstm.setString(1, obj.getCpf());
		pstm.setString(2, obj.getNome());
		pstm.setString(3, obj.getCpf());

		pstm.execute();
		BancoDeDados.desconectar();

	}

	@Override
	public void remove(Cliente obj) throws ClassNotFoundException, SQLException {
		String sql = "DELETE cliente WHERE cpf = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		pstm.setString(1, obj.getCpf());

		pstm.execute();
		BancoDeDados.desconectar();

	}

	public Cliente getByCpf(String cpf) throws ClassNotFoundException,
			SQLException {
		String sql = "SELECT * FROM cliente WHERE cpf = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		
		pstm.setString(1, cpf);
		ResultSet res = pstm.executeQuery();
		Cliente cliente = null;
		while (res.next()) {
			cliente = new Cliente();
			cliente.setCpf(res.getString("cpf"));
			cliente.setNome(res.getString("nome"));
		}
		BancoDeDados.desconectar();

		return cliente;
	}

	public Collection<Cliente> getByNome(String nome)
			throws ClassNotFoundException, SQLException {
				
		String sql = "SELECT * FROM cliente WHERE nome LIKE '"+nome+"' ";
		
		return get(sql);

	}

	@Override
	public Collection<Cliente> get() throws ClassNotFoundException,
			SQLException {
		String sql = "SELECT * FROM cliente";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		
		ResultSet res = pstm.executeQuery();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		while (res.next()) {
			Cliente cliente = new Cliente();
			cliente.setCpf(res.getString("cpf"));
			cliente.setNome(res.getString("nome"));
			clientes.add(cliente);
		}
		BancoDeDados.desconectar();

		return clientes;
	}

	@Override
	public Collection<Cliente> get(String regex) throws ClassNotFoundException,
			SQLException {
		String sql = regex;
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		System.out.print(sql);
		ResultSet res = pstm.executeQuery();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		while (res.next()) {
			Cliente cliente = new Cliente();
			cliente.setCpf(res.getString("cpf"));
			cliente.setNome(res.getString("nome"));
			cliente.setLogradouro(res.getString("logradouro"));
			cliente.setNumero(res.getInt("numero"));
			cliente.setBairro(res.getString("bairro"));
			cliente.setCidade(res.getString("cidade"));
			cliente.setCep(res.getString("cep"));
			cliente.setEmail(res.getString("email"));
			cliente.setFone(res.getString("fone"));
			cliente.setCelular(res.getString("celular"));
			clientes.add(cliente);
		}
		BancoDeDados.desconectar();

		return clientes;
	}

	@Override
	public Cliente get(Cliente id) {
		// TODO Auto-generated method stub
		return null;
	}

}
