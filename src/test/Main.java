package test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import dao.Facade;
import entidades.Cliente;
import entidades.DVD;
import entidades.Funcionario;
import entidades.Midia;
import entidades.Promocao;
import entidades.TipoLocacao;

public class Main {

	Scanner s = new Scanner(System.in);

	int exibirMenu() {
		System.out.println("\n\n");
		System.out.println("----Projeto Locadora de Vídeo----");
		System.out.println("1. Cadastrar DVD");
		System.out.println("2. Pesquisar DVD");
		System.out.println("3. Remover DVD");
		System.out.println("4. Cadastrar Cliente");
		System.out.println("5. Pesquisar Cliente");
		System.out.println("6. Remover Cliente");
		System.out.println("7. Realizar Emprestimo");
		System.out.println("8. Remover Emprestimo");
		System.out.println("9. Devolução de Emprestimo");
		System.out.println("10. Tarifar Promoção");
		System.out.println("11. Cadastrar Funcionario");
		System.out.println("12. Sair");
		System.out.println("-------------------------------");
		System.out.print("Digite uma Opção: ");
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
		int entradaInt;
		ArrayList<DVD> listaDvd;
		ArrayList<Cliente> listacls;
		DVD dvd = new DVD();
		Cliente cliente = new Cliente();
		Funcionario funcionario = new Funcionario();
		TipoLocacao tipo;
		Funcionario funcX;
		Cliente clienteaux = null;
		int opcao, i;
		Date dt = null;
		do {
			opcao = m.exibirMenu();
			switch (opcao) {

			case 1:

				System.out.println("Bem vindo ao Cadastro de DVDS");
				System.out.println("----------------------------------");
				System.out.println("Digite o nome do DVD: ");
				dvd.setNome(new Scanner(System.in).next());
				System.out.println("Digite o descrição do DVD: ");
				dvd.setDescricao(new Scanner(System.in).next());
				System.out.println("Digite a quantidade de Disc: ");
				dvd.setQt(new Scanner(System.in).nextShort());
				System.out.println("Digite a duração: ");
				dvd.setDuracaoMinutos(new Scanner(System.in).nextInt());
				System.out.println("Digite a sinopse: ");
				dvd.setSinopse(new Scanner(System.in).next());
				System.out.println("Digite a quantidade de cópias: ");
				int qtd = new Scanner(System.in).nextInt();

				try {
					for (i = 0; i < qtd; i++) {

						Facade.cadastrar(dvd);
					}
					System.out.println("DVD cadastrado com Sucesso!!");
				} catch (Exception e) {
					System.out.println("Erro: DVD não cadastrado!");
					e.printStackTrace();
				}
				break;

			case 2:

				System.out.println("Bem vindo a Pesquisa de DVD");
				System.out.println("----------------------------------");
				System.out.println("Digite o nome do DVD: ");
				String d = new Scanner(System.in).next();

				try {
					listaDvd = (ArrayList<DVD>) Facade.getDVD(d);
					if (listaDvd.size() > 0) {

						System.out.println("Foram Encontrados "
								+ listaDvd.size() + "DVD com a Descrição:");
						System.out
								.println("----------------------------------------------------------");
						System.out.println(listaDvd.get(0).toString());
					}

					else
						System.out
								.println("DVD não Consta na base de Dados!!!!");

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;

			case 3:
				System.out.println("Bem vindo a Remoção de DVD");
				System.out.println("----------------------------------");
				System.out.println("Digite o nome do DVD a ser removido: ");
				String rm = new Scanner(System.in).next();

				try {

					listaDvd = (ArrayList<DVD>) Facade.getDVD(rm);

					if (listaDvd.size() > 0) {

						System.out.println("DADOS DO DVD");
						System.out.println("----------------");
						System.out.println(listaDvd.get(0).toString());
						System.out
								.printf("DESEJA REALMENTE REMOVER ESTE DVD?(S/N)");
						String resp = new Scanner(System.in).next();

						if (resp.equalsIgnoreCase("S")) {
							System.out
									.printf("Existem %d cópias deste DVD, quer excluir quantas?",
											listaDvd.size());

							entradaInt = new Scanner(System.in).nextInt();
							if (entradaInt > listaDvd.size()) {
								for (DVD deletar : listaDvd)
									Facade.remove(deletar);
							} else
								for (i = 0; i < entradaInt; i++)
									Facade.remove(listaDvd.get(i));
							System.out.println("DVD " + rm + " Removido");
						} else {
							System.out
									.print("Retornando ao menu inicial, APERTE ENTER");
							rm = new Scanner(System.in).nextLine();
						}
					}

					else
						System.out
								.println("DVD não Consta na base de Dados!!!!");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				break;

			case 4:
				System.out.println("Bem vindo ao Cadastro de Cliente");
				System.out.println("----------------------------------");
				System.out.println("Digite o CPF do Cliente: ");

				String cpf = new Scanner(System.in).next();
				try {
					clienteaux = Facade.getClienteByCpf(cpf);

					if (clienteaux != null) {
						System.out.println("Cliente já cadastrado!");
						System.out
								.print("Retornando ao menu inicial, APERTE ENTER");
						rm = new Scanner(System.in).nextLine();
					} else {
						clienteaux = new Cliente();
						clienteaux.setCpf(cpf);
						System.out.println("Digite o nome do cliente: ");
						clienteaux.setNome(new Scanner(System.in).next());
						System.out.println("Logradouro: ");
						clienteaux.setLogradouro(new Scanner(System.in).next());
						System.out.println("Numero: ");
						clienteaux.setNumero(new Scanner(System.in).nextInt());
						System.out.println("Fone: ");
						clienteaux.setFone(new Scanner(System.in).next());
						System.out.println("Cidade: ");
						clienteaux.setCidade(new Scanner(System.in).next());

						Facade.cadastrar(clienteaux);
						System.out.println("Cliente cadastrado com Sucesso!!");
						System.out.println(clienteaux.toString());
					}

				} catch (Exception e) {
					System.out.println("Erro: Cliente não cadastrado!");
					e.printStackTrace();
				}

				break;

			case 5:
				System.out.println("Bem vindo a pesquisa de Clientes");
				System.out.println("----------------------------------");
				System.out.println("Digite o CPF do Cliente: ");
				String cpf2 = new Scanner(System.in).next();
				try {
					clienteaux = Facade.getClienteByCpf(cpf2);
					if (clienteaux != null) {
						System.out.println("DADOS DO CLIENTE");
						System.out.println("----------------------");
						System.out.println(clienteaux.toString());
					} else {
						System.out
								.println("Cliente não consta na base de dados!!");
						System.out
								.print("Retornando ao menu inicial, APERTE ENTER");
						rm = new Scanner(System.in).nextLine();
					}

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;

			case 6:
				break;

			case 7:
				System.out.println("Bem vindo ao Empréstimo de DVD");
				System.out.println("----------------------------------");
				System.out.println("Digite o CPF do Cliente: ");
				cpf2 = new Scanner(System.in).next();
				try {
					clienteaux = Facade.getClienteByCpf(cpf2);
					if (clienteaux == null) {
						System.out
								.println("Cliente não consta na base de dados!! \nCadastre anteriormente o cliente para fazer a locação.");
						System.out
								.print("Retornando ao menu inicial, APERTE ENTER");
						rm = new Scanner(System.in).nextLine();
					} else {
						System.out.println("Digite o Nome do Filme: ");
						d = new Scanner(System.in).next();

						listaDvd = (ArrayList<DVD>) Facade.getDVD(d);
						dt = new Date(System.currentTimeMillis());
						tipo = Facade.getTipoLocacao(1);
						funcX = Facade.getFuncionarioByNome("Felipe").get(0);
						Facade.fazerLocao(clienteaux, funcX, dt, listaDvd.get(0),
								null, tipo);
						Calendar cal = Calendar.getInstance();
						cal.setTime(new java.util.Date(dt.getYear(), dt
								.getMonth(), tipo.getnDiasLocacao()
								+ dt.getDate()));
						dt = new Date(cal.getTime().getTime()); 
						System.out
								.printf("Empréstimo realizado com sucesso\nData de entrega: %s\nValor: %f",
										dt.toString(),tipo.getValor_locacao());

					}
				} catch (Exception e) {
					System.out.println("Erro: Cliente não cadastrado!");
					e.printStackTrace();
				}

				break;

			case 8:
				break;

			case 9:
				break;

			case 10:
				break;

			case 11:

				System.out.println("Bem vindo ao Cadastro de Funcionario");
				System.out.println("----------------------------------");
				System.out.println("Digite o nome do DVD: ");
				funcionario.setLogin("ricardo");
				funcionario.setNome("ricardo");
				break;

			case 12:
				System.out.println("Obrigado por Usar o nosso Sistema.");
				System.out.println("5 GRAUS OESTE LTDA");
				break;
			default:
				System.out.println("Opcao invalida!");
				break;
			}

		} while (opcao != 12);

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
	// //Facade.cadastrarMidia("dvd 1", "bla", (short)1, 120, "etc");
	// Facade.cadastrar(new
	// DVD("Dragôes","Ação",(short)2,180,"Um filme aninador"));
	// //
	// // cliente = Facade.getCliente(1);
	// //
	// // Date dt = new Date(System.currentTimeMillis());
	// // dt.setDate(30);
	// // Locacao locacao = new Locacao(midia, 5, null, new
	// Date(System.currentTimeMillis()), dt, funcionario, cliente);
	// //
	// // Facade.fazerLocaï¿½ï¿½o(locacao);
	// // Facade.FinalizarLocaï¿½ï¿½o(locacao);
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }

}