package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import db.BancoDeDados;
import entidades.DVD;


public class DVDDAO implements DAO<DVD> {

	BancoDeDados bd = BancoDeDados.getInstance();
	
	@Override
	public void save(DVD obj) throws SQLException, ClassNotFoundException {
		bd.conecta();
		int id = 0;
		/* Busca o maior ID de Produto para cadastrar no próximo (+1) */
		String sql = "SELECT MAX(id) FROM produto";

		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);
		ResultSet res = pstm.executeQuery();
		while (res.next()) {
			id = res.getInt(1);
		}
		id++;

		sql = "INSERT INTO produto (id, nome, descricao) VALUES (?, ?, ?)";
		pstm = bd.getConexao().prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.setString(2, obj.getNome());
		pstm.setString(3, obj.getDescricao());
		pstm.execute();

		sql = "INSERT INTO midia (id, qt) VALUES (?, ?)";
		pstm = bd.getConexao().prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.setInt(2, obj.getQt());
		pstm.execute();

		sql = "INSERT INTO dvd (id, duracao_minutos, sinopse, locado) VALUES (?, ?, ?, ?)";
		pstm = bd.getConexao().prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.setInt(2, obj.getDuracaoMinutos());
		pstm.setString(3, obj.getSinopse());
		pstm.setBoolean(4, (false));
		pstm.execute();

		bd.desconectar();

	}

	@Override
	public void update(DVD obj) throws ClassNotFoundException, SQLException {
		bd.conecta();
		String sql = "UPDATE produto SET nome = ?, descricao = ? WHERE id = ?";
		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);

		pstm.setInt(3, obj.getId());
		pstm.setString(1, obj.getNome());
		pstm.setString(2, obj.getDescricao());
		pstm.execute();

		sql = "UPDATE midia SET qt = ? WHERE id = ?";
		pstm = bd.getConexao().prepareStatement(sql);

		pstm.setInt(2, obj.getId());
		pstm.setInt(1, obj.getQt());
		pstm.execute();

		sql = "UPDATE dvd SET duracao_minutos = ?, sinopse = ?, locado = ? WHERE id = ?";
		pstm = bd.getConexao().prepareStatement(sql);
		;
		pstm.setInt(4, obj.getId());
		pstm.setInt(1, obj.getDuracaoMinutos());
		pstm.setString(2, obj.getSinopse());
		pstm.setBoolean(3, obj.isLocado());
		pstm.execute();

		bd.desconectar();

	}

	@Override
	public void remove(DVD obj) throws ClassNotFoundException, SQLException {
		bd.conecta();
		String sql = "DELETE FROM dvd WHERE id = ?";
		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);

		pstm.setInt(1, obj.getId());
		pstm.execute();

		sql = "DELETE FROM midia WHERE id = ?";
		pstm = bd.getConexao().prepareStatement(sql);
		pstm.setInt(1, obj.getId());

		pstm.execute();

		sql = "DELETE FROM produto WHERE id = ?";
		pstm = bd.getConexao().prepareStatement(sql);
		pstm.setInt(1, obj.getId());
		pstm.execute();
		bd.desconectar();

	}

	@Override
	public DVD get(DVD id) throws ClassNotFoundException, SQLException {

		return get(id.getId());
	}

	public DVD get(int id) throws SQLException, ClassNotFoundException {
		bd.conecta();
		String sql = "SELECT * FROM produto WHERE id = ?";
		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);

		pstm.setInt(1, id);
		ResultSet res = pstm.executeQuery();
		DVD dvd = null;
		while (res.next()) {
			dvd = new DVD();
			dvd.setId(res.getInt("id"));
			dvd.setNome(res.getString("nome"));
			dvd.setDescricao(res.getString("descricao"));
		}

		sql = "SELECT * FROM midia WHERE id = ?";
		pstm = bd.getConexao().prepareStatement(sql);

		pstm.setInt(1, id);
		res = pstm.executeQuery();
		while (res.next()) {

			dvd.setQt(res.getShort("qt"));
		}

		sql = "SELECT * FROM dvd WHERE id = ?";
		pstm = bd.getConexao().prepareStatement(sql);
		;
		pstm.setInt(1, id);
		res = pstm.executeQuery();
		while (res.next()) {
			dvd.setLocado(res.getBoolean("locado"));
			dvd.setSinopse(res.getString("sinopse"));
			dvd.setDuracaoMinutos(res.getInt("duracao_minutos"));
		}

		bd.desconectar();

		return dvd;
	}

	@Override
	public Collection<DVD> get() throws SQLException, ClassNotFoundException {
		bd.conecta();
		String sql = "SELECT * FROM produto";
		PreparedStatement pstm = bd.getConexao()
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

		sql = "SELECT * FROM midia";
		pstm = bd.getConexao().prepareStatement(sql);
		res = pstm.executeQuery();
		int index = 0;
		while (res.next()) {
			dvds.get(index).setQt(res.getShort("qt"));
			index++;
		}

		sql = "SELECT * FROM dvd";
		pstm = bd.getConexao().prepareStatement(sql);
		res = pstm.executeQuery();
		index = 0;
		while (res.next()) {
			dvds.get(index).setSinopse(res.getString("sinopse"));
			dvds.get(index).setLocado(res.getBoolean("locado"));
			dvds.get(index).setDuracaoMinutos(res.getInt("duracao_minutos"));
			index++;
		}

		bd.desconectar();

		return dvds;
	}

	@Override
	public Collection<DVD> get(String regex) throws ClassNotFoundException,
			SQLException {
		bd.conecta();
		String sql = regex.replaceAll("dvd", "produto");

		PreparedStatement pstm = bd.getConexao()
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
			pstm = bd.getConexao().prepareStatement(sql2);
			pstm.setInt(1, dvd2.getId());
			res = pstm.executeQuery();
			while (res.next()) {
				dvd2.setQt(res.getShort("qt"));
			}
			sql2 = "SELECT * FROM dvd WHERE id = ?";
			pstm = bd.getConexao().prepareStatement(sql2);
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

	public Collection<DVD> getTodosDvds(String nome)
			throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM dvd WHERE nome LIKE '" + nome + "%' ";

		return get(sql);
	}

	public Collection<DVD> getDvdsNaoLocados(String nome)
			throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM dvd WHERE nome LIKE '" + nome + "' ";
		String subsql = "AND locado = false";
		bd.conecta();
		sql = sql.replaceAll("dvd", "produto");

		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);
		ResultSet res = pstm.executeQuery();
		ArrayList<DVD> auxDvds = new ArrayList<DVD>(); // auxiliar
		ArrayList<DVD> dvdsNLocados = new ArrayList<DVD>(); // efetivamente retornado
		DVD dvd = null;
		while (res.next()) {
			dvd = new DVD();
			dvd.setId(res.getInt("id"));
			dvd.setNome(res.getString("nome"));
			dvd.setDescricao(res.getString("descricao"));
			auxDvds.add(dvd);
		}

		for (DVD dvd2 : auxDvds) {
			String sql2 = "SELECT * FROM midia WHERE id = ?";
			pstm = bd.getConexao().prepareStatement(sql2);
			pstm.setInt(1, dvd2.getId());
			res = pstm.executeQuery();
			while (res.next()) {
				dvd2.setQt(res.getShort("qt"));
			}
			sql2 = "SELECT * FROM dvd WHERE id = ? " + subsql;
			pstm = bd.getConexao().prepareStatement(sql2);
			pstm.setInt(1, dvd2.getId());
			res = pstm.executeQuery();
			int results = 0;
			while (res.next()) {
				results++;
				dvd2.setSinopse(res.getString("sinopse"));
				dvd2.setDuracaoMinutos(res.getInt("duracao_minutos"));
				dvd2.setLocado(res.getBoolean("locado"));
				dvdsNLocados.add(dvd2);
			}

		}

		return dvdsNLocados;
	}
}