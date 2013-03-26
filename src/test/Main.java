package test;

//tercio

//tercio
import java.sql.Date;
import java.sql.SQLException;

import dao.Facade;
import entidades.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
//			Funcionario funcionario = new Funcionario();
//			funcionario.setLogin("ricardo");
//			funcionario.setNome("ricardo");
//			funcionario.setSenha("123");
//
//			Cliente cliente = new Cliente();
//			cliente.setCpf("06755772");
//			cliente.setNome("Pedro");
//
//			 Facade.cadastrarFuncionario(funcionario.getNome(),
//			 funcionario.getLogin(), funcionario.getSenha());
//			 Facade.cadastrarCliente(cliente.getCpf(), cliente.getNome());
			 //Facade.cadastrarMidia("dvd 1", "bla", (short)1, 120, "etc");
//			 Facade.cadastrar(new DVD("Dragões", "Ação", (short) 2, 180,
//			 "Um filme aninador"));
			DVD dvd = Facade.getDVD(1);
			Cliente cliente = Facade.getCliente().get(0);
			Funcionario funcionario = Facade.getFuncionario().get(0);
			Facade.fazerLocao(cliente, funcionario, new Date(System.currentTimeMillis()), dvd, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		// cliente = Facade.getCliente(1);
		//
		// Date dt = new Date(System.currentTimeMillis());
		// dt.setDate(30);
		// Locacao locacao = new Locacao(midia, 5, null, new
		// Date(System.currentTimeMillis()), dt, funcionario, cliente);
		//
		// Facade.fazerLoca��o(locacao);
		// Facade.FinalizarLoca��o(locacao);

	}

}
