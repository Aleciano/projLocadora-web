package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import db.BancoDeDados;

import entidades.DVD;
import entidades.Funcionario;

public class DVDDAO implements DAO<DVD> {

	@Override
	public void save(DVD obj) throws SQLException, ClassNotFoundException {
		BancoDeDados.conecta();
		int id = 0;
		/* Busca o maior ID de Produto para cadastrar no próximo (+1) */
		String sql = "SELECT MAX(id) FROM produto";
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		ResultSet res = pstm.executeQuery();
		while(res.next()){
			id = res.getInt(1);
		}
		System.out.println(id);
		id++;
		System.out.println(id);
		
		sql = "INSERT INTO produto (id, nome, descricao) VALUES (?, ?, ?)";		
		pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.setString(2, obj.getNome());
		pstm.setString(3, obj.getDescricao());
		pstm.execute();
		
		sql = "INSERT INTO midia (id, qt) VALUES (?, ?)";		
		pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.setInt(2, obj.getQt());
		pstm.execute();
		
		sql = "INSERT INTO dvd (id, duracao_minutos, sinopse) VALUES (?, ?, ?)";		
		pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.setInt(2, obj.getDuracaoMinutos());
		pstm.setString(3, obj.getSinopse());
		pstm.execute();		
		
		BancoDeDados.desconectar();
		
	}

	@Override
	public void update(DVD obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(DVD obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DVD get(DVD id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public DVD get(int id) throws SQLException, ClassNotFoundException {
		BancoDeDados.conecta();
		String sql = "SELECT * FROM produto WHERE id = ?";		
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);;
		pstm.setInt(1, id);
		ResultSet res = pstm.executeQuery();
		DVD dvd =  null;
		while (res.next()){
			dvd =  new DVD();
			dvd.setId(res.getInt("id"));
			dvd.setNome(res.getString("nome"));
		}
		
		sql = "SELECT * FROM midia WHERE id = ?";		
		pstm = BancoDeDados.getConexao().prepareStatement(sql);;
		pstm.setInt(1, id);
		res = pstm.executeQuery();
		while (res.next()){;
			dvd.setQt(res.getShort("qt"));
		}
		
		sql = "SELECT * FROM dvd WHERE id = ?";		
		pstm = BancoDeDados.getConexao().prepareStatement(sql);;
		pstm.setInt(1, id);
		res = pstm.executeQuery();
		while (res.next()){;
			dvd.setSinopse(res.getString("sinopse"));
		}
		
		BancoDeDados.desconectar();
		
		return dvd;
	}

	@Override
	public Collection<DVD> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DVD> get(String regex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
