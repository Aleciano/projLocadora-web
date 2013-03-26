package test;


import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import dao.Facade;
import entidades.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {

/*			Funcionario funcionario = new Funcionario();
			funcionario.setLogin("felipeadd");
			funcionario.setNome("Felipe");
			funcionario.setSenha("123");
*/
/*			Cliente cliente = new Cliente();
			cliente.setCpf("873942342");
			cliente.setNome("Elano");
*/
/*		 Facade.cadastrarFuncionario(funcionario.getNome(),
			 funcionario.getLogin(), funcionario.getSenha());*/
			
//			 Facade.cadastrarCliente(cliente.getCpf(), cliente.getNome());
			 
			 //Facade.cadastrarMidia("dvd 1", "bla", (short)1, 120, "etc");
/*			 Facade.cadastrar(new DVD("Dragao Azul", "Acao", (short) 2, 180,
			 "Um filme aninador"));*/
			DVD dvd = Facade.getDVD(1);
			Cliente cliente2 = Facade.getCliente().get(0);
			Funcionario funcionario2 = Facade.getFuncionario().get(0);
			Calendar agora = Calendar.getInstance();
			
			Facade.fazerLocao(cliente2, funcionario2, new Date(System.currentTimeMillis()), dvd, null);

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
