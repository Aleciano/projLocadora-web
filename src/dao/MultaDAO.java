package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import db.BancoDeDados;

import entidades.Multa;

public class MultaDAO implements DAO<Multa> {

	@Override
	public void save(Multa obj) throws SQLException, ClassNotFoundException {
		BancoDeDados.conecta();
		String sql = "INSERT INTO multa (nome, valor) VALUES (?, ?)";
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		
		pstm.setString(1, obj.getNome());

		pstm.setDouble(2, obj.getValor());

		pstm.execute();
		BancoDeDados.desconectar();
	}

	@Override
	public void update(Multa obj) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE multa (nome, valor) SET (?, ?) WHERE id = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setString(1, obj.getNome());

		pstm.setDouble(2, obj.getValor());

		pstm.setInt(3, obj.getId());
		pstm.execute();
		BancoDeDados.desconectar();
		
	}

	@Override
	public void remove(Multa obj) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM multa WHERE id = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setInt(1, obj.getId());
		pstm.execute();
		BancoDeDados.desconectar();
		
	}
	
	public void remove(int multa) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM multa WHERE id = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setInt(1, multa);
		pstm.execute();
		BancoDeDados.desconectar();
		
	}

	
	public Multa get(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM multa WHERE id = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet res = pstm.executeQuery();
		Multa multa =  null;
		while (res.next()){
			multa = new Multa();
			multa.setId(res.getInt("id"));
			multa.setNome(res.getString("nome"));
			multa.setValor(res.getDouble("valor"));
			
		}
		BancoDeDados.desconectar();
		
		return multa;
	}
	
	@Override
	public Multa get (Multa id) throws ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM multa WHERE id = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setInt(1, id.getId());
		ResultSet res = pstm.executeQuery();
		Multa multa =  null;
		while (res.next()){
			multa = new Multa();
			multa.setId(res.getInt("id"));
			multa.setNome(res.getString("nome"));
			multa.setValor(res.getDouble("valor"));
	
		}
		BancoDeDados.desconectar();
		
		return multa;
	}
	
	@Override
	public Collection<Multa> get() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM multa";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);;
		ResultSet res = pstm.executeQuery();
		ArrayList<Multa> multas = new ArrayList<Multa>();
		while (res.next()){
			Multa multa = new Multa();
			multa.setId(res.getInt("id"));
			multa.setNome(res.getString("nome"));
			multa.setValor(res.getDouble("valor"));
			multas.add(multa);
		}
		BancoDeDados.desconectar();
		
		return multas;
	}

	@Override
	public Collection<Multa> get(String regex) throws ClassNotFoundException,
			SQLException {
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(regex);;
		ResultSet res = pstm.executeQuery();
		ArrayList<Multa> multas = new ArrayList<Multa>();
		while (res.next()){
			Multa multa = new Multa();
			multa.setId(res.getInt("id"));
			multa.setNome(res.getString("nome"));
			multa.setValor(res.getDouble("valor"));
			multas.add(multa);
		}
		BancoDeDados.desconectar();
		
		return multas;
		
	}

}