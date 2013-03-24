package test;


//tercio

//tercio
import java.sql.SQLException;

import dao.Facade;
import entidades.Cliente;
import entidades.Funcionario;	

public class Main {

	/**
	 * @param args vidal modificou
	 */
	public static void main(String[] args) {
		
		
				
		try {
			Funcionario funcionario =  new Funcionario();
			funcionario.setLogin("ricardo");
			funcionario.setNome("ricardo");
			
			Cliente cliente = new Cliente();
			cliente.setCpf("06755772");
			cliente.setNome("Pedro");
			
						
			//Facade.cadastrarFuncionario(funcionario.getNome(), funcionario.getLogin(), funcionario.getSenha());
			//Facade.cadastrarCliente(cliente.getCpf(), cliente.getNome());
			Facade.cadastrarMidia("dvd 1", "bla", (short)1, 120, "etc");
			
//			
//			cliente = Facade.getCliente(1);
//			
//			Date dt = new Date(System.currentTimeMillis());
//			dt.setDate(30);
//			Locacao locacao = new Locacao(midia, 5, null, new Date(System.currentTimeMillis()), dt, funcionario, cliente);
//			
//			Facade.fazerLoca��o(locacao);		
//			Facade.FinalizarLoca��o(locacao);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
