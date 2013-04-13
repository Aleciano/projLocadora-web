package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import db.BancoDeDados;
import entidades.Locacao;

public class LocacaoDAO implements DAO<Locacao> {
	
	BancoDeDados bd = BancoDeDados.getInstance();

	@Override
	public void save(Locacao obj) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO locacao (valor, dt_locacao, dt_devolucao_agendada, dt_devolucao, cpf_cliente, mat_funcionario, cod_midia) VALUES (?, ?, ?, ?, ?, ?, ?)";
		bd.conecta();
		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);
		pstm.setDouble(1, obj.getValor());
		// pstm.setDouble(2, obj.getValorPago());
		pstm.setDate(2, obj.getDtLocacao());
		pstm.setDate(3, obj.getDtDevolucaoAgendada());
		pstm.setDate(4, obj.getDtDevolucao());
		pstm.setString(5, obj.getCliente().getCpf());
		pstm.setInt(6, obj.getFuncionario().getMatricula());
		pstm.setInt(7, obj.getMidia().getId());
		// pstm.setInt(9, obj.getTipoLocacao().getId());
		pstm.execute();
		bd.desconectar();
	}

	// Se tiver multa ela já vem embutida no valor, já que aqui o interesse é só
	// salvar, e não fazer cálculos.
	@Override
	public void update(Locacao obj) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE locacao SET valor=?, valor_pago=?, dt_locacao=?, dt_devolucao_agendada=?, dt_devolucao=?, cpf_cliente=?, mat_funcionario=?, cod_midia=? WHERE id = ?";
		bd.conecta();
		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);
		pstm.setDouble(1, obj.getValor());
		 pstm.setDouble(2, obj.getValorPago());
		pstm.setDate(3, obj.getDtLocacao());
		pstm.setDate(4, obj.getDtDevolucaoAgendada());
		pstm.setDate(5, obj.getDtDevolucao());
		pstm.setString(6, obj.getCliente().getCpf());
		pstm.setInt(7, obj.getFuncionario().getMatricula());
		pstm.setInt(8, obj.getMidia().getId());
		pstm.setInt(9, obj.getId());
		pstm.execute();
		bd.desconectar();
	}

	@Override
	public void remove(Locacao obj) throws ClassNotFoundException, SQLException {
		String sql = "DELETE from locacao WHERE id = ?";
		bd.conecta();
		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);
		pstm.setInt(1, obj.getId());
		pstm.execute();
		bd.desconectar();

	}

	@Override
	public Locacao get(Locacao id) throws ClassNotFoundException, SQLException {
		
		return get(id.getId());
	}

	public Locacao get(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM locacao WHERE id = ?";
		bd.conecta();
		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);
		;
		pstm.setInt(1, id);
		ResultSet res = pstm.executeQuery();
		Locacao locacao = null;
		while (res.next()) {
			locacao = new Locacao();
			locacao.setCliente(Facade.getClienteByCpf(res
					.getString("cpf_cliente")));
			locacao.setFuncionario(Facade.getFuncionario(res
					.getInt("mat_funcionario")));
			locacao.setMidia(Facade.getDVD(res.getInt("cod_midia")));
			// locacao.setTipoLocacao(Facade.getTipoLocacao(res.getInt("cod_tipo_locacao")));
			locacao.setDtDevolucao(res.getDate("dt_devolucao"));
			locacao.setDtDevolucaoAgendada(res.getDate("dt_devolucao_agendada"));
			locacao.setDtLocacao(res.getDate("dt_devolucao_agendada"));
			locacao.setId(res.getInt("id"));
			locacao.setValor(res.getDouble("valor"));
			// locacao.setValorPago(res.getDouble("valor_pago"));
		}
		bd.desconectar();

		return locacao;
	}

	@Override
	public Collection<Locacao> get() throws ClassNotFoundException,
			SQLException {
		String sql = "SELECT * FROM locacao";
		bd.conecta();
		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);
		;
		ResultSet res = pstm.executeQuery();

		ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
		while (res.next()) {
			Locacao locacao = new Locacao();
			locacao.setCliente(Facade.getClienteByCpf(res
					.getString("cpf_cliente")));
			locacao.setFuncionario(Facade.getFuncionario(res
					.getInt("mat_funcionario")));
			locacao.setMidia(Facade.getDVD(res.getInt("cod_midia")));
			locacao.setDtDevolucao(res.getDate("dt_devolucao"));
			locacao.setDtDevolucaoAgendada(res.getDate("dt_devolucao_agendada"));
			locacao.setDtLocacao(res.getDate("dt_devolucao_agendada"));
			locacao.setId(res.getInt("id"));
			locacao.setValor(res.getDouble("valor"));
			locacao.setValorPago(res.getDouble("valor_pago"));
			locacoes.add(locacao);
		}
		bd.desconectar();

		return locacoes;
	}

	@Override
	public Collection<Locacao> get(String regex) throws ClassNotFoundException,
			SQLException {
		String sql = regex;
		bd.conecta();
		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);
		ResultSet res = pstm.executeQuery();

		ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
		while (res.next()) {
			Locacao locacao = new Locacao();
			locacao.setCliente(Facade.getClienteByCpf(res
					.getString("cpf_cliente")));
			locacao.setFuncionario(Facade.getFuncionario(res
					.getInt("mat_funcionario")));
			locacao.setMidia(Facade.getDVD(res.getInt("cod_midia")));
			locacao.setDtLocacao(res.getDate("dt_locacao"));
			locacao.setDtDevolucaoAgendada(res.getDate("dt_devolucao_agendada"));
			locacao.setDtDevolucao(res.getDate("dt_devolucao"));
			locacao.setId(res.getInt("id"));
			locacao.setValor(res.getDouble("valor"));
			// locacao.setValorPago(res.getDouble("valor_pago"));
			locacoes.add(locacao);
			locacao.toString();
		}
		bd.desconectar();

		return locacoes;
	}

	public Collection<Locacao> getLocacoesAbertas()
			throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM locacao WHERE dt_devolucao is NULL";

		return get(sql);
	}

	public Collection<Locacao> getByCliente(String cliente)
			throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM locacao WHERE cpf_cliente LIKE '" + cliente
				+ "' ";

		return get(sql);
	}

	public Collection<Locacao> getLocacoesAbertasByCliente(String cliente)
			throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM locacao WHERE cpf_cliente LIKE '" + cliente
				+ "' AND dt_devolucao is NULL";

		return get(sql);
	}

	public static int getLocacaoMaxId(String cliente) throws SQLException, ClassNotFoundException{
		BancoDeDados bd = BancoDeDados.getInstance();
		String sql = "SELECT Max(id) FROM locacao where cpf_cliente like ?";
		int id = 0;
		bd.conecta();
		PreparedStatement pstm = bd.getConexao()
				.prepareStatement(sql);
		pstm.setString(1, cliente);
		ResultSet res = pstm.executeQuery();
		while (res.next()) {
			
			id = res.getInt(1);
		}
		bd.desconectar();
		return id;
	}
}