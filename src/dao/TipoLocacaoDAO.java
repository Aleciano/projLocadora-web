package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import db.BancoDeDados;

import entidades.Multa;
import entidades.TipoLocacao;

public class TipoLocacaoDAO implements DAO<TipoLocacao> {

	@Override
	public void save(TipoLocacao obj) throws SQLException,
			ClassNotFoundException {
		BancoDeDados.conecta();
		String sql = "INSERT INTO tipo_locacao (nome, valor_locacao, n_dias_locacao) VALUES (?, ?, ?)";
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		pstm.setString(1, obj.getNome());
		pstm.setDouble(2, obj.getValor_locacao());
		pstm.setDouble(3, obj.getnDiasLocacao());
		pstm.execute();
		BancoDeDados.desconectar();

	}

	@Override
	public void update(TipoLocacao obj) throws ClassNotFoundException,
			SQLException {
		BancoDeDados.conecta();
		String sql = "UPDATE tipo_locacao (nome, valor_locacao, n_dias_locacao) SET (?, ?, ?) WHERE id = ?";
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		pstm.setString(1, obj.getNome());
		pstm.setDouble(2, obj.getValor_locacao());
		pstm.setDouble(3, obj.getnDiasLocacao());
		pstm.setDouble(4, obj.getId());
		pstm.execute();
		BancoDeDados.desconectar();

	}

	@Override
	public void remove(TipoLocacao obj) throws ClassNotFoundException,
			SQLException {
		String sql = "DELETE tipo_locacao WHERE id = ?";
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		pstm.setDouble(1, obj.getId());

	}

	@Override
	public TipoLocacao get(TipoLocacao id) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<TipoLocacao> get() throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public TipoLocacao get(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM tipo_locacao WHERE id = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet res = pstm.executeQuery();
		TipoLocacao tipo = null;
		while (res.next()) {
			tipo = new TipoLocacao();
			tipo.setId(res.getInt("id"));
			tipo.setNome(res.getString("nome"));
			tipo.setValor_locacao(res.getDouble("valor_locacao"));
			tipo.setnDiasLocacao(res.getInt("n_dias_locacao"));

		}
		BancoDeDados.desconectar();

		return tipo;
	}

	public Collection<TipoLocacao> getTipoByNome(String nome)
			throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM tipo_locacao WHERE nome like '"+nome+"%' ";
		
		return get(sql);

	}

	@Override
	public Collection<TipoLocacao> get(String regex)
			throws ClassNotFoundException, SQLException {

		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao()
				.prepareStatement(regex);
		System.out.print(regex);
		// pstm.setInt(1, id);
		ResultSet res = pstm.executeQuery();
		ArrayList<TipoLocacao> tipos = new ArrayList<TipoLocacao>();
		TipoLocacao tipo = null;
		while (res.next()) {
			System.out.print("*");
			tipo = new TipoLocacao();
			tipo.setId(res.getInt("id"));
			tipo.setNome(res.getString("nome"));
			tipo.setValor_locacao(res.getDouble("valor_locacao"));
			tipo.setnDiasLocacao(res.getInt("n_dias_locacao"));
			tipos.add(tipo);

		}
		BancoDeDados.desconectar();

		return tipos;
	}

}
