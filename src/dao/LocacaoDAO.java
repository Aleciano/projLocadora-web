package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;

import db.BancoDeDados;

import entidades.Locacao;

public class LocacaoDAO implements DAO<Locacao>{

	@Override
	public void save(Locacao obj) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO locacao (valor, dt_locacao, dt_locacao_agendada, " +
				"cpf_cliente, mat_funcionario, cod_midia) VALUES (?, ?, ?, ?, ?, ?)";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setDouble(1, obj.getValor());
		Calendar cal = Calendar.getInstance();
		pstm.setDate(2, obj.getDtDevolucao());
		pstm.setDate(2, obj.getDtDevolucaoAgendada());
		pstm.setString(2, obj.getCliente().getCpf());
		pstm.setInt(2, obj.getFuncionario().getMatricula());
		pstm.setInt(2, obj.getMidia().getId());
		pstm.execute();
		BancoDeDados.desconectar();		
	}

	@Override
	public void update(Locacao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Locacao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Locacao get(Locacao id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Locacao> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Locacao> get(String regex) {
		// TODO Auto-generated method stub
		return null;
	}

}
