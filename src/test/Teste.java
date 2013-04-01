package test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.*;
import dao.DAO.*;
import dao.Facade;

public class Teste {

	/**
	 * @param args
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		int i = 0;
		/*
		 * TipoLocacao tipo_criança = new TipoLocacao(0, "infantil",
		 * "Menores de 14 anos", 2, 2); Facade.cadastrar(tipo_criança);
		 */

		Date dt = new Date(System.currentTimeMillis()); // passar a hora certa
														// também!!
		Midia midia_escolhida = (Midia) ((ArrayList<DVD>) Facade
				.getDVD("Matrix2")).get(0);
		Funcionario funcX = Facade.getFuncionarioByNome("Felipe").get(0);
		Cliente clienteX = Facade.getClienteByCpf("4545");
		
		 Facade.fazerLocacao(clienteX, funcX, dt, midia_escolhida, null);

		ArrayList<Locacao> locacoes_do_cliente = (ArrayList<Locacao>) Facade
				.getLocacoesAbertas(((ArrayList<Cliente>) Facade
						.getCliente("Vidal")).get(0).getCpf());
		for(i = 0; i < locacoes_do_cliente.size();i++){
			System.out.println(locacoes_do_cliente.get(i).toString());
//			Facade.FinalizarLocao(locacoes_do_cliente.get(0), locacoes_do_cliente.get(0).getValor() , null);
		}
		/*
		 * Multa multinha = new Multa(5,"Branda","Leve, poucos dias",0,5);
		 * Facade.cadastrar(multinha); ArrayList<Multa> mults =
		 * (ArrayList<Multa>) Facade.getMulta(); for (Multa multax : mults) {
		 * 
		 * System.out.println(multax.toString());
		 * 
		 * } for(int tal=0;tal<11;tal++) Facade.remove(tal);
		 */
		/*
		 * ArrayList<DVD> dvds = (ArrayList<DVD>) Facade.getDVD("matrix");
		 * System.out.printf("\n%d",dvds.size()); for(DVD value: dvds){
		 * System.out.println("\noi"); System.out.println( value.toString());
		 * 
		 * }
		 */
		
	/*	  Funcionario funcionario = new Funcionario();
		  funcionario.setLogin("Abraao"); funcionario.setNome("abraao");
		  funcionario.setSenha("abraao");
		  
		  Facade.cadastrarFuncionario(funcionario.getNome(),
		  funcionario.getLogin(), funcionario.getSenha());*/
		 
		/*
		 * ArrayList<Funcionario> funcs = (ArrayList<Funcionario>) Facade
		 * .getFuncionarioByNome("ricardo"); System.out.printf("\n%d\n",
		 * funcs.size()); for (Funcionario func : funcs) {
		 * 
		 * System.out.println(func.toString());
		 * 
		 * }
		 */

		/*
		 * Cliente cls = Facade.getClienteByCpf("873942342"); if (cls != null)
		 * System.out.print(cls.toString()); else
		 * System.out.print("Cliente não consta na base de dado");
		 */

		// try {
		// //
		// // cliente = Facade.getCliente(1);
		// //
		// // Date dt = new Date(System.currentTimeMillis());
		// // dt.setDate(30);
		// // Locacao locacao = new Locacao(midia, 5, null, new
		// Date(System.currentTimeMillis()), dt, funcionario, cliente);
		// //
		// // Facade.fazerLocacao(locacao);
		// // Facade.FinalizarLocacao(locacao);

	}
}
