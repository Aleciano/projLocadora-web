package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


import db.BancoDeDados;

import entidades.Cliente;

public class ClienteDAO implements DAO<Cliente> {
	
	@Override
	public void save(Cliente obj) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO cliente (cpf, nome) VALUES (?, ?)";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setString(1, obj.getCpf());
		pstm.setString(2, obj.getNome());
		pstm.execute();
		BancoDeDados.desconectar();		
	}

	@Override
	public void update(Cliente obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Cliente obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente get(Cliente id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Cliente> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Cliente> get(String regex) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
