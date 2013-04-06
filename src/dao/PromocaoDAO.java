package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import db.BancoDeDados;

import entidades.Multa;
import entidades.Promocao;

public class PromocaoDAO implements DAO<Promocao> {

	@Override
	public void save(Promocao obj) throws SQLException, ClassNotFoundException {
		BancoDeDados.conecta();
		String sql = "INSERT INTO promocao (nome, valor, dt_init, dt_final) VALUES (?, ?, ?, ?)";
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);

		pstm.setString(1, obj.getNome());
		pstm.setDouble(2, obj.getValor());
		pstm.setDate(3, obj.getDuracaoInit());
		pstm.setDate(4, obj.getDuracaoFinal());
		pstm.execute();
		BancoDeDados.desconectar();

	}

	@Override
	public void update(Promocao obj) throws ClassNotFoundException,
			SQLException {
		String sql = "UPDATE promocao SET nome=?, valor=?, dt_init=?, dt_final=?  WHERE id = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		pstm.setString(1, obj.getNome());
		pstm.setDouble(2, obj.getValor());
		pstm.setDate(3, obj.getDuracaoInit());
		pstm.setDate(4, obj.getDuracaoFinal());
		pstm.setInt(5, obj.getId());
		pstm.execute();
		BancoDeDados.desconectar();

	}

	@Override
	public void remove(Promocao obj) throws ClassNotFoundException,
			SQLException {
		String sql = "DELETE promocao WHERE id = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		pstm.setInt(1, obj.getId());
		pstm.execute();
		BancoDeDados.desconectar();

	}

	@Override
	public Promocao get(Promocao id) throws ClassNotFoundException,
			SQLException {

		return get(id.getId());
	}

	public Promocao get(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM promocao WHERE id = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet res = pstm.executeQuery();
		Promocao promocao = null;
		while (res.next()) {
			promocao = new Promocao();
			promocao.setId(res.getInt("id"));
			promocao.setNome(res.getString("nome"));
			promocao.setValor(res.getDouble("valor"));
			promocao.setDuracaoInit(res.getDate("dt_init"));
			promocao.setDuracaoFinal(res.getDate("dt_final"));
		}
		BancoDeDados.desconectar();

		return promocao;
	}

	@Override
	public Collection<Promocao> get() throws ClassNotFoundException,
			SQLException {
		String sql = "SELECT * FROM promocao";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		ResultSet res = pstm.executeQuery();
		ArrayList<Promocao> promocoes = new ArrayList<Promocao>();
		while (res.next()) {
			Promocao promocao = new Promocao();
			promocao.setId(res.getInt("id"));
			promocao.setNome(res.getString("nome"));
			promocao.setValor(res.getDouble("valor"));
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
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(
				regex);
		ResultSet res = pstm.executeQuery();
		ArrayList<Promocao> promocoes = new ArrayList<Promocao>();
		while (res.next()) {
			Promocao promocao = new Promocao();
			promocao.setId(res.getInt("id"));
			promocao.setNome(res.getString("nome"));
			promocao.setValor(res.getDouble("valor"));
			promocao.setDuracaoInit(res.getDate("dt_init"));
			promocao.setDuracaoFinal(res.getDate("dt_final"));
			promocoes.add(promocao);
		}
		BancoDeDados.desconectar();

		return promocoes;
	}
	
	public Promocao getAbertas() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM promocao WHERE dt_init <= ? AND dt_final >= ? ";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql); 
		Calendar cal = Calendar.getInstance();
		String formatoDataInit = "'"+String.valueOf(cal.get(1))+"-"+String.valueOf(cal.get(2)+1)+"-"+String.valueOf(cal.get(5))+"'";
//		String formatoDataFim = String.valueOf(cal.get(1))+"-"+String.valueOf(cal.get(2))+"-"+String.valueOf(5);
		System.out.println(formatoDataInit);
		pstm.setDate(1, new Date(cal.getTime().getTime()), cal);
		pstm.setDate(2, new Date(cal.getTime().getTime()), cal);
		
		ResultSet res = pstm.executeQuery();
		Promocao promocao = null;
		while (res.next()) {
			promocao = new Promocao();
			promocao.setId(res.getInt("id"));
			promocao.setNome(res.getString("nome"));
			promocao.setValor(res.getDouble("valor"));
			promocao.setDuracaoInit(res.getDate("dt_init"));
			promocao.setDuracaoFinal(res.getDate("dt_final"));

		}
		BancoDeDados.desconectar();

		return promocao;
	}

}
