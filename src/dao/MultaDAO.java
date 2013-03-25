package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import db.BancoDeDados;

import entidades.Funcionario;
import entidades.Multa;

public class MultaDAO implements DAO<Multa> {

	@Override
	public void save(Multa obj) throws SQLException, ClassNotFoundException {
		BancoDeDados.conecta();
		String sql = "INSERT INTO multa (id, nome, descricao, valor, percentual) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setInt(1, obj.getId());
		pstm.setString(2, obj.getNome());
		pstm.setString(3, obj.getDescricao());
		pstm.setDouble(4, obj.getValor());
		pstm.setDouble(5, obj.getPercentual());
		pstm.execute();
		BancoDeDados.desconectar();
	}

	@Override
	public void update(Multa obj) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE multa (nome, descricao, valor, percentual) SET (?, ?, ?, ?) WHERE id = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setString(1, obj.getNome());
		pstm.setString(2, obj.getDescricao());
		pstm.setDouble(3, obj.getValor());
		pstm.setDouble(4, obj.getPercentual());
		pstm.setInt(5, obj.getId());
		pstm.execute();
		BancoDeDados.desconectar();
		
	}

	@Override
	public void remove(Multa obj) throws ClassNotFoundException, SQLException {
		String sql = "DELETE multa WHERE id = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setInt(1, obj.getId());
		pstm.execute();
		BancoDeDados.desconectar();
		
	}

	//@Override
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
			multa.setNome(res.getString("descricao"));
			multa.setValor(res.getDouble("valor"));
			multa.setPercentual(res.getDouble("percentual"));
			
		}
		BancoDeDados.desconectar();
		
		return multa;
	}

	@Override
	public Multa get (Multa id){
		return null;
	}
	
	@Override
	public Collection<Multa> get() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Multa> get(String regex) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
