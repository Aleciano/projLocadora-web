package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import db.BancoDeDados;

import entidades.Multa;
import entidades.Promocao;

public class PromocaoDAO implements DAO<Promocao>{

	@Override
	public void save(Promocao obj) throws SQLException, ClassNotFoundException {
		BancoDeDados.conecta();
		String sql = "INSERT INTO promocao (nome, descricao, valor, percentual, dt_init, dt_final) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		
		pstm.setString(1, obj.getNome());
		pstm.setString(2, obj.getDescricao());
		pstm.setDouble(3, obj.getValor());
		pstm.setDouble(4, obj.getPercentual());
		pstm.setDate(5, obj.getDuracaoInit());
		pstm.setDate(6, obj.getDuracaoFinal());
		pstm.execute();
		BancoDeDados.desconectar();
		
	}

	@Override
	public void update(Promocao obj) throws ClassNotFoundException,
			SQLException {
		String sql = "UPDATE promocao (nome, descricao, valor, percentual, dt_init, dt_final) SET (?, ?, ?, ?, ?, ?) WHERE id = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setString(1, obj.getNome());
		pstm.setString(2, obj.getDescricao());
		pstm.setDouble(3, obj.getValor());
		pstm.setDouble(4, obj.getPercentual());
		pstm.setDate(5, obj.getDuracaoInit());
		pstm.setDate(6, obj.getDuracaoFinal());
		pstm.setInt(7, obj.getId());
		pstm.execute();
		BancoDeDados.desconectar();
		
	}

	@Override
	public void remove(Promocao obj) throws ClassNotFoundException,
			SQLException {
		String sql = "DELETE promocao WHERE id = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setInt(1, obj.getId());
		pstm.execute();
		BancoDeDados.desconectar();
		
	}

	@Override
	public Promocao get(Promocao id) throws ClassNotFoundException,
			SQLException {
		String sql = "SELECT * FROM multa WHERE id = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setInt(1, id.getId());
		ResultSet res = pstm.executeQuery();
		Promocao promocao =  null;
		while (res.next()){
			promocao = new Promocao();
			promocao.setId(res.getInt("id"));
			promocao.setNome(res.getString("nome"));
			promocao.setDescricao(res.getString("descricao"));
			promocao.setValor(res.getDouble("valor"));
			promocao.setPercentual(res.getDouble("percentual"));
			promocao.setDuracaoInit(res.getDate("dt_init"));
			promocao.setDuracaoFinal(res.getDate("dt_final"));
		}
		BancoDeDados.desconectar();
		
		return promocao;
	}

	@Override
	public Collection<Promocao> get() throws ClassNotFoundException,
			SQLException {
		String sql = "SELECT * FROM multa";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		ResultSet res = pstm.executeQuery();
		ArrayList<Promocao> promocoes = new ArrayList<Promocao>();
		while (res.next()){
			Promocao promocao = new Promocao();
			promocao.setId(res.getInt("id"));
			promocao.setNome(res.getString("nome"));
			promocao.setDescricao(res.getString("descricao"));
			promocao.setValor(res.getDouble("valor"));
			promocao.setPercentual(res.getDouble("percentual"));
			promocao.setDuracaoInit(res.getDate("dt_init"));
			promocao.setDuracaoFinal(res.getDate("dt_final"));
			promocoes.add(promocao);
		}
		BancoDeDados.desconectar();
		
		return promocoes;
	}

	@Override
	public Collection<Promocao> get(String regex)
			throws ClassNotFoundException, SQLException {
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(regex);
		ResultSet res = pstm.executeQuery();
		ArrayList<Promocao> promocoes = new ArrayList<Promocao>();
		while (res.next()){
			Promocao promocao = new Promocao();
			promocao.setId(res.getInt("id"));
			promocao.setNome(res.getString("nome"));
			promocao.setDescricao(res.getString("descricao"));
			promocao.setValor(res.getDouble("valor"));
			promocao.setPercentual(res.getDouble("percentual"));
			promocao.setDuracaoInit(res.getDate("dt_init"));
			promocao.setDuracaoFinal(res.getDate("dt_final"));
			promocoes.add(promocao);
		}
		BancoDeDados.desconectar();
		
		return promocoes;
	}
	
	public PromocaoDAO() {
		// TODO Auto-generated constructor stub
	}

}
