package test;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import dao.Facade;
import entidades.DVD;

public class Main {

	Scanner s = new Scanner(System.in);
	
	int exibirMenu() {
		System.out.println("\n\n");
		System.out.println("----Projeto Locadora de V�deo----");
		System.out.println("1. Cadastrar DVD");
		System.out.println("2. Pesquisar DVD");
		System.out.println("3. Remover DVD");
		System.out.println("4. Cadastrar Cliente");
		System.out.println("5. Pesquisar Cliente");
		System.out.println("6. Remover Cliente");
		System.out.println("7. Realizar Emprestimo");
		System.out.println("8. Remover Emprestimo");
		System.out.println("9. Devolu��o de Emprestimo");
		System.out.println("10. Tarifar Promo��o");
		System.out.println("11. Sair");
		System.out.println("-------------------------------");
		System.out.print("Digite uma Op��o: ");
		try {
			int resultado = s.nextInt();
			return resultado;

		} catch (InputMismatchException e) {
			System.out.println("Entrada de dados invalida. Tente novamente");

		}
		return 0;
	}

	public static void main(String[] args) {

		Main m = new Main();

		Facade facade = new Facade();

		int opcao;
		do {
			opcao = m.exibirMenu();
			switch (opcao) {

			case 1:
				DVD dvd = new DVD();
				System.out.println("Bem vindo ao Cadastro de DVDS");
				System.out.println("Digite o nome do DVD: ");
				dvd.setNome(new Scanner(System.in).next());
				System.out.println("Digite o descri��o do DVD: ");
				dvd.setDescricao(new Scanner(System.in).next());
				System.out.println("Digite a quantidade de Disc: ");
				dvd.setQt(new Scanner(System.in).nextShort());
				System.out.println("Digite a dura��o: ");
				dvd.setDuracaoMinutos(new Scanner(System.in).nextInt());
				System.out.println("Digite a sinopse: ");
				dvd.setSinopse(new Scanner(System.in).next());
				System.out.println("Digite a quantidade de c�pias: ");
				int qtd = new Scanner(System.in).nextInt();
				dvd.setQt((short)qtd);
				try {
					facade.cadastrar(dvd);
				} catch (Exception e) {
					System.out.println("Erro: DVD n�o cadastrado!");
					e.printStackTrace();
				}
				break;

			case 2:
				break;

			case 3:

				break;
			case 4:

				break;

			case 5:

				break;

			case 6:
				break;

			case 7:
				break;

			case 8:
				break;

			case 9:
				break;

			case 10:
				break;

			case 11:
				System.out.println("Obrigado volte sempre.");
				break;
			default:
				System.out.println("Opcao invalida!!");
				break;
			}

		} while (opcao != 11);

	}

	// try {
	// Funcionario funcionario = new Funcionario();
	// funcionario.setLogin("ricardo");
	// funcionario.setNome("ricardo");
	//
	// Cliente cliente = new Cliente();
	// cliente.setCpf("06755772");
	// cliente.setNome("Pedro");
	//
	//
	// //Facade.cadastrarFuncionario(funcionario.getNome(),
	// funcionario.getLogin(), funcionario.getSenha());
	// //Facade.cadastrarCliente(cliente.getCpf(), cliente.getNome());

	// Facade.cadastrar(new
	// DVD("Drag�es","A��o",(short)2,180,"Um filme aninador"));
	// //
	// // cliente = Facade.getCliente(1);
	// //
	// // Date dt = new Date(System.currentTimeMillis());
	// // dt.setDate(30);
	// // Locacao locacao = new Locacao(midia, 5, null, new
	// Date(System.currentTimeMillis()), dt, funcionario, cliente);
	// //
	// // Facade.fazerLoca��o(locacao);
	// // Facade.FinalizarLoca��o(locacao);
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }

}
