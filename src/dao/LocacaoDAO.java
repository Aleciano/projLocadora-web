package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import db.BancoDeDados;
import entidades.Locacao;

public class LocacaoDAO implements DAO<Locacao>{

	@Override
	public void save(Locacao obj) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO locacao (valor, valor_pago, dt_locacao, dt_devolucao_agendada, dt_devolucao" +
				"cpf_cliente, mat_funcionario, cod_midia) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setDouble(1, obj.getValor());
		pstm.setDouble(2, obj.getValorPago());
		pstm.setDate(3, obj.getDtLocacao());		
		pstm.setDate(4, obj.getDtDevolucaoAgendada());
		pstm.setDate(5, obj.getDtDevolucao());
		pstm.setString(6, obj.getCliente().getCpf());
		pstm.setInt(7, obj.getFuncionario().getMatricula());
		pstm.setInt(8, obj.getMidia().getId());
		pstm.execute();
		BancoDeDados.desconectar();		
	}

	//alterar uma locação. Ex: adicionar multa.
	@Override
	public void update(Locacao obj) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE locacao (valor, valor_pago, dt_locacao, dt_devolucao_agendada, dt_devolucao" +
				"cpf_cliente, mat_funcionario, cod_midia) VALUES (?, ?, ?, ?, ?, ?, ?, ?) WHERE id = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setDouble(1, obj.getValor());
		pstm.setDate(2, obj.getDtDevolucao());
		pstm.setDate(3, obj.getDtDevolucaoAgendada());
		pstm.setString(4, obj.getCliente().getCpf());
		pstm.setInt(5, obj.getFuncionario().getMatricula());
		pstm.setInt(6, obj.getMidia().getId());
		pstm.setInt(7, obj.getId());
		pstm.execute();
		BancoDeDados.desconectar();
	}

	@Override
	public void remove(Locacao obj) throws ClassNotFoundException, SQLException {
		String sql = "DELETE locacao WHERE id = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);		
		pstm.setInt(1, obj.getId());
		pstm.execute();
		BancoDeDados.desconectar();
		
	}

	@Override
	public Locacao get(Locacao id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Locacao get(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM locacao WHERE id = ?";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);;
		pstm.setInt(1, id);
		ResultSet res = pstm.executeQuery();
		Locacao locacao = null;
		while (res.next()){
			locacao = new Locacao();
			locacao.setCliente(Facade.getCliente(res.getInt("cpf_cliente")));
			locacao.setFuncionario(Facade.getFuncionario(res.getInt("mat_funcionario")));
			locacao.setMidia(Facade.getDVD(res.getInt("cod_midia")));
			locacao.setDtDevolucao(res.getDate("dt_devolucao"));
			locacao.setDtDevolucaoAgendada(res.getDate("dt_devolucao_agendada"));
			locacao.setDtLocacao(res.getDate("dt_devolucao_agendada"));
			locacao.setId(res.getInt("id"));
			locacao.setValor(res.getDouble("valor"));
			locacao.setValorPago(res.getDouble("valor_pago"));
		}
		BancoDeDados.desconectar();
		
		return locacao;
	}	

	@Override
	public Collection<Locacao> get() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM locacao";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);;
		ResultSet res = pstm.executeQuery();
		
		ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
		while (res.next()){
			Locacao locacao = new Locacao();
			locacao.setCliente(Facade.getCliente(res.getInt("cpf_cliente")));
			locacao.setFuncionario(Facade.getFuncionario(res.getInt("mat_funcionario")));
			locacao.setMidia(Facade.getDVD(res.getInt("cod_midia")));
			locacao.setDtDevolucao(res.getDate("dt_devolucao"));
			locacao.setDtDevolucaoAgendada(res.getDate("dt_devolucao_agendada"));
			locacao.setDtLocacao(res.getDate("dt_devolucao_agendada"));
			locacao.setId(res.getInt("id"));
			locacao.setValor(res.getDouble("valor"));
			locacao.setValorPago(res.getDouble("valor_pago"));
			locacoes.add(locacao);
		}
		BancoDeDados.desconectar();
		
		return locacoes;
	}

	@Override
	public Collection<Locacao> get(String regex) throws ClassNotFoundException, SQLException {
		String sql = regex;
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);;
		ResultSet res = pstm.executeQuery();
		
		ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
		while (res.next()){
			Locacao locacao = new Locacao();
			locacao.setCliente(Facade.getCliente(res.getInt("cpf_cliente")));
			locacao.setFuncionario(Facade.getFuncionario(res.getInt("mat_funcionario")));
			locacao.setMidia(Facade.getDVD(res.getInt("cod_midia")));
			locacao.setDtDevolucao(res.getDate("dt_devolucao"));
			locacao.setDtDevolucaoAgendada(res.getDate("dt_devolucao_agendada"));
			locacao.setDtLocacao(res.getDate("dt_devolucao_agendada"));
			locacao.setId(res.getInt("id"));
			locacao.setValor(res.getDouble("valor"));
			locacao.setValorPago(res.getDouble("valor_pago"));
			locacoes.add(locacao);
		}
		BancoDeDados.desconectar();
		
		return locacoes;
	}

}
