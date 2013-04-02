package test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

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
		Scanner input = new Scanner(System.in);
		int i = 0, opcao = -1;
		Multa multa = null;
		Calendar cal = null;
		/*
		 * TipoLocacao tipo_criança = new TipoLocacao(0, "infantil",
		 * "Menores de 14 anos", 2, 2); Facade.cadastrar(tipo_criança);
		 */
		/*
		 * Date dt = new Date(System.currentTimeMillis()); // passar a hora
		 * certa // também!! Midia midia_escolhida = (Midia) ((ArrayList<DVD>)
		 * Facade .getDVD("Matrix2")).get(0); Funcionario funcX =
		 * Facade.getFuncionarioByNome("Felipe").get(0); Cliente clienteX =
		 * Facade.getClienteByCpf("4545");
		 * 
		 * Facade.fazerLocacao(clienteX, funcX, dt, midia_escolhida, null);
		 */
		ArrayList<Locacao> locacoes_do_cliente = (ArrayList<Locacao>) Facade
				.getLocacoesAbertas(((ArrayList<Cliente>) Facade
						.getCliente("Elias")).get(0).getCpf());
		for (i = 0; i < locacoes_do_cliente.size(); i++) {
			System.out.println(locacoes_do_cliente.get(i).toString());
		}
		System.out.printf("\nEncerrar qual locação? Digite %d para todas!",
				locacoes_do_cliente.size());
		opcao = input.nextInt();
		cal = Calendar.getInstance();
		// Calendar dateLocacao = Calendar.getInstance();

		if (opcao >= locacoes_do_cliente.size())
			for (Locacao fimLocacao : locacoes_do_cliente) {
				// fimLocacao = locacoes_do_cliente.get(opcao);

				// http://docs.oracle.com/javase/7/docs/api/constant-values.html#java.util.Calendar.DAY_OF_YEAR
				Calendar dateLocacao = Calendar.getInstance();
				cal.setTime(new java.util.Date(fimLocacao
						.getDtLocacao().getYear(), fimLocacao.getDtLocacao()
						.getMonth(), 15+fimLocacao.getDtLocacao().getDate()));

				if ((cal.get(6) - dateLocacao.get(6)) > 2) {
					System.out.println("Multa Branda!!");
					multa = ((ArrayList<Multa>) (Facade
							.getMultaPorNome("Branda"))).get(0);
				} else if ((cal.get(6) - dateLocacao.get(6)) > 10) {
					System.out.println("Multa Severa!!");
					multa = ((ArrayList<Multa>) (Facade
							.getMultaPorNome("Severa"))).get(0);
				}
				input.nextLine();
				
				Facade.FinalizarLocao(fimLocacao, multa);
			}
		else if (opcao > 0) {
			Calendar dateLocacao = Calendar.getInstance();
			cal.setTime(new java.util.Date(locacoes_do_cliente.get(opcao - 1)
					.getDtLocacao().getYear(), locacoes_do_cliente.get(opcao - 1).getDtLocacao()
					.getMonth(), 10 + (locacoes_do_cliente.get(opcao - 1).getDtLocacao().getDate())));
			if ((cal.get(6) - dateLocacao.get(6)) > 2) {
				System.out.println("Multa Branda!!");
				multa = ((ArrayList<Multa>) (Facade.getMultaPorNome("Branda")))
						.get(0);
			} else if ((cal.get(6) - dateLocacao.get(6)) > 10) {
				System.out.println("Multa Severa!!");
				multa = ((ArrayList<Multa>) (Facade.getMultaPorNome("Severa")))
						.get(0);
				
			}
			Facade.FinalizarLocao(locacoes_do_cliente.get(opcao - 1), multa);
		}
		System.out.print("\n:: Lista de locações do cliente atualizada ::");
		locacoes_do_cliente = (ArrayList<Locacao>) Facade.getLocacoes(((ArrayList<Cliente>) Facade
						.getCliente("Vidal")).get(0).getCpf());
		for (Locacao locacoes : locacoes_do_cliente){
			System.out.println(locacoes.toString());
		}

		/*
		 * Multa multinha = new Multa("Severa",10); Facade.cadastrar(multinha);
		 * Facade.cadastrar(multinha); ArrayList<Multa> mults =
		 * (ArrayList<Multa>) Facade.getMulta(); for (Multa multax : mults) {
		 * 
		 * System.out.println(multax.toString());
		 * 
		 * }
		 */
		/*
		 * for(int tal=0;tal<11;tal++) Facade.remove(tal);
		 * 
		 * 
		 * /* ArrayList<DVD> dvds = (ArrayList<DVD>) Facade.getDVD("matrix");
		 * System.out.printf("\n%d",dvds.size()); for(DVD value: dvds){
		 * System.out.println("\noi"); System.out.println( value.toString());
		 * 
		 * }
		 */

		/*
		 * Funcionario funcionario = new Funcionario();
		 * funcionario.setLogin("Abraao"); funcionario.setNome("abraao");
		 * funcionario.setSenha("abraao");
		 * 
		 * Facade.cadastrarFuncionario(funcionario.getNome(),
		 * funcionario.getLogin(), funcionario.getSenha());
		 */

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
