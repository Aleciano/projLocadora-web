package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import db.BancoDeDados;

import entidades.DVD;
import entidades.Funcionario;
import entidades.Locacao;

public class DVDDAO implements DAO<DVD> {

	@Override
	public void save(DVD obj) throws SQLException, ClassNotFoundException {
		BancoDeDados.conecta();
		int id = 0;
		/* Busca o maior ID de Produto para cadastrar no próximo (+1) */
		String sql = "SELECT MAX(id) FROM produto";
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		ResultSet res = pstm.executeQuery();
		while (res.next()) {
			id = res.getInt(1);
		}
		id++;

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

		sql = "INSERT INTO dvd (id, duracao_minutos, sinopse, locado) VALUES (?, ?, ?, ?)";
		pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.setInt(2, obj.getDuracaoMinutos());
		pstm.setString(3, obj.getSinopse());
		pstm.setBoolean(4, (false));
		pstm.execute();

		BancoDeDados.desconectar();

	}

	@Override
	public void update(DVD obj) throws ClassNotFoundException, SQLException {
		BancoDeDados.conecta();
		String sql = "UPDATE produto SET nome = ?, descricao = ? WHERE id = ?";
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
//		UPDATE produto SET nome='matrix2', descricao='filme' WHERE id = 2
		pstm.setInt(3, obj.getId());
		pstm.setString(1, obj.getNome());
		pstm.setString(2, obj.getDescricao());
		pstm.execute();
//		ResultSet res = pstm.executeQuery();

		//DVD dvd = null;
/*		while (res.next()) {
			dvd = new DVD();
			dvd.setId(res.getInt("id"));
			dvd.setNome(res.getString("nome"));
		}*/

		sql = "UPDATE midia SET qt = ? WHERE id = ?";
		pstm = BancoDeDados.getConexao().prepareStatement(sql);
		
		pstm.setInt(2, obj.getId());
		pstm.setInt(1, obj.getQt());
		pstm.execute();
/*		while (res.next()) {
			;
			dvd.setQt(res.getShort("qt"));
		}*/
		sql = "UPDATE dvd SET duracao_minutos = ?, sinopse = ?, locado = ? WHERE id = ?";
		pstm = BancoDeDados.getConexao().prepareStatement(sql);
		;
		pstm.setInt(4, obj.getId());
		pstm.setInt(1, obj.getDuracaoMinutos());
		pstm.setString(2, obj.getSinopse());
		pstm.setBoolean(3, obj.isLocado());
		pstm.execute();
/*		while (res.next()) {
			;
			dvd.setSinopse(res.getString("sinopse"));
			dvd.setDuracaoMinutos(res.getInt("duracao_minutos"));
		}*/

		BancoDeDados.desconectar();

	}

	@Override
	public void remove(DVD obj) throws ClassNotFoundException, SQLException {
		BancoDeDados.conecta();
		String sql = "DELETE FROM dvd WHERE id = ?";
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		;
		pstm.setInt(1, obj.getId());
		pstm.execute();

		sql = "DELETE FROM midia WHERE id = ?";
		pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setInt(1, obj.getId());

		pstm.execute();

		sql = "DELETE FROM produto WHERE id = ?";
		pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setInt(1, obj.getId());
		pstm.execute();
		BancoDeDados.desconectar();

	}

	@Override
	public DVD get(DVD id) {
		// TODO Auto-generated method stub
		return null;
	}

	public DVD get(int id) throws SQLException, ClassNotFoundException {
		BancoDeDados.conecta();
		String sql = "SELECT * FROM produto WHERE id = ?";
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		;
		pstm.setInt(1, id);
		ResultSet res = pstm.executeQuery();
		DVD dvd = null;
		while (res.next()) {
			dvd = new DVD();
			dvd.setId(res.getInt("id"));
			dvd.setNome(res.getString("nome"));
			dvd.setDescricao("descricao");
		}

		sql = "SELECT * FROM midia WHERE id = ?";
		pstm = BancoDeDados.getConexao().prepareStatement(sql);
		;
		pstm.setInt(1, id);
		res = pstm.executeQuery();
		while (res.next()) {
			;
			dvd.setQt(res.getShort("qt"));
		}

		sql = "SELECT * FROM dvd WHERE id = ?";
		pstm = BancoDeDados.getConexao().prepareStatement(sql);
		;
		pstm.setInt(1, id);
		res = pstm.executeQuery();
		while (res.next()) {
			;
			dvd.setSinopse(res.getString("sinopse"));
		}

		BancoDeDados.desconectar();

		return dvd;
	}

	@Override
	public Collection<DVD> get() throws SQLException, ClassNotFoundException {
		BancoDeDados.conecta();
		String sql = "SELECT * FROM produto";
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		ResultSet res = pstm.executeQuery();
		ArrayList<DVD> dvds = new ArrayList<DVD>();
		DVD dvd = null;
		while (res.next()) {
			dvd = new DVD();
			dvd.setId(res.getInt("id"));
			dvd.setNome(res.getString("nome"));
			dvd.setDescricao("descricao");
			dvds.add(dvd);
		}

		sql = "SELECT * FROM midia";
		pstm = BancoDeDados.getConexao().prepareStatement(sql);
		res = pstm.executeQuery();
		int index = 0;
		while (res.next()) {
			dvds.get(index).setQt(res.getShort("qt"));
			index++;
		}

		sql = "SELECT * FROM dvd";
		pstm = BancoDeDados.getConexao().prepareStatement(sql);
		res = pstm.executeQuery();
		index = 0;
		while (res.next()) {
			dvds.get(index).setSinopse(res.getString("sinopse"));
			index++;
		}

		BancoDeDados.desconectar();

		return dvds;
	}

	@Override
	public Collection<DVD> get(String regex) throws ClassNotFoundException,
			SQLException {
		BancoDeDados.conecta();
		String sql = regex.replaceAll("dvd", "produto");

		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		ResultSet res = pstm.executeQuery();
		ArrayList<DVD> dvds = new ArrayList<DVD>();
		DVD dvd = null;
		while (res.next()) {
			dvd = new DVD();
			dvd.setId(res.getInt("id"));
			dvd.setNome(res.getString("nome"));
			dvd.setDescricao(res.getString("descricao"));
			dvds.add(dvd);
		}

		for (DVD dvd2 : dvds) {
			String sql2 = "SELECT * FROM midia WHERE id = ?";
			pstm = BancoDeDados.getConexao().prepareStatement(sql2);
			pstm.setInt(1, dvd2.getId());
			res = pstm.executeQuery();
			while (res.next()) {
				dvd2.setQt(res.getShort("qt"));
			}
			sql2 = "SELECT * FROM dvd WHERE id = ?";
			pstm = BancoDeDados.getConexao().prepareStatement(sql2);
			pstm.setInt(1, dvd2.getId());
			res = pstm.executeQuery();
			while (res.next()) {
				dvd2.setSinopse(res.getString("sinopse"));
				dvd2.setDuracaoMinutos(res.getInt("duracao_minutos"));
				dvd2.setLocado(res.getBoolean("locado"));
			}
		}

		return dvds;
	}

	public Collection<DVD> getDvdByNome(String nome)
			throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM dvd WHERE nome LIKE '" + nome + "%' ";		
		//		String sql = "SELECT * FROM produto WHERE nome LIKE '" + nome + "%' ";


		return get(sql);
	}
}