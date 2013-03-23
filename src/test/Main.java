package test;

//Aleciano esteve aqui.

import java.util.Date;

import dao.Facade;
import entidades.Cliente;
import entidades.DVD;
import entidades.Funcionario;
import entidades.Locacao;
import entidades.Midia;

//Classe principal!!
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Funcionario funcionario =  new Funcionario();
		funcionario.setMatricula(133);
		Cliente cliente = new Cliente();
		cliente.setCpf("06755772");
		cliente.setNome("Jose da Silva");
		DVD midia = new DVD(101, "filme 1", "bla", (short)1, 120, "bla");
		System.out.print("1 2 3");
				
		Facade.cadastrar(funcionario);
		Facade.cadastrar(cliente);
		Facade.cadastrar(midia);
		
		
		cliente = Facade.getCliente(1);
		
		Date dt = new Date();
		dt.setDate(30);
		Locacao locacao = new Locacao(1, midia, 2, null, new Date(), dt, funcionario, cliente);
		
		Facade.fazerLocacao(locacao);		
		Facade.FinalizarLocacao(locacao);
		

	}

}
