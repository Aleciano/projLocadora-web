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
		String sql = "INSERT INTO locacao (valor, dt_locacao, dt_devolucao_agendada, " +
				"cpf_cliente, mat_funcionario, cod_midia) VALUES (?, ?, ?, ?, ?, ?)";
		BancoDeDados.conecta();
		PreparedStatement pstm = BancoDeDados.getConexao().prepareStatement(sql);
		pstm.setDouble(1, obj.getValor());
		Calendar cal = Calendar.getInstance();
		pstm.setDate(2, obj.getDtDevolucao());
		pstm.setDate(3, obj.getDtDevolucaoAgendada());
		pstm.setString(4, obj.getCliente().getCpf());
		pstm.setInt(5, obj.getFuncionario().getMatricula());
		pstm.setInt(6, obj.getMidia().getId());
		pstm.execute();
		BancoDeDados.desconectar();		
	}

	//alterar uma locação. Ex: adicionar multa.
	@Override
	public void update(Locacao obj) {
		
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
	
	/*public Locacao get(Locacao nome) {
		// TODO Auto-generated method stub
		return null;
	}*/

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
