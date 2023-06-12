import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AppMain {

	public static void main(String[] args) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");	

		// ===== INSTANCIAR CLIENTES PF E VEÍCULOS =====

		List<Veiculo> veiculosPF1 = new ArrayList<>();
		List<Veiculo> veiculosPF2 = new ArrayList<>();
		
		Veiculo veiculoPF1 = new Veiculo("JHS5S98", "Fiat", "Palio", 2015); 
		Veiculo veiculoPF2 = new Veiculo("LHK5Y62", "Ford", "Ranger", 2018);
		Veiculo veiculoPF3 = new Veiculo("THU5N36", "Ford", "Focus", 2018);

		ClientePF clientePF1 = new ClientePF("466.534.108-70", "feminino", "Engenharia de Computação (cursando)", 
				dateFormat.parse("11/10/1987"), veiculosPF1, "Ayla Machado", "(11)95987-9523", 
				"Rua Roxo Moreira, 601 - Cidade Universitária, Campinas/SP", "ayla.machado@gmail.com.br");

		ClientePF clientePF2 = new ClientePF("453.066.068-06", "feminino", "Engenharia de Computação (cursando)", 
				dateFormat.parse("15/04/1999"), veiculosPF2, "Maria Lobo", "(19)99873-2157",
				"Rua Roxo Moreira, 159 - Cidade Universitária, Campinas/SP", "maria.lobo@gmail.com.br");
		
		System.out.println("===== toString() classe Veiculo:\n" + veiculoPF1);
		System.out.println("=====\n");
		
		System.out.println("===== toString() classe ClientePF:\n" + clientePF1);
		System.out.println("=====\n");

		// ===== INSTANCIAR CLIENTES PJ, VEÍCULOS E FROTAS =====

		List<Veiculo> veiculosPJ1 = new ArrayList<>();
		List<Veiculo> veiculosPJ2 = new ArrayList<>();
		
		Veiculo veiculoPJ1 = new Veiculo("AMK5Y62", "Renault", "Sandero", 2013);
		Veiculo veiculoPJ2 = new Veiculo("BLA5Y63", "Chevrolet", "HB20", 2016);
		Veiculo veiculoPJ3 = new Veiculo("UHF6H49", "Ford", "Ka", 2009);
		
		List<Frota> frotaPJ1 = new ArrayList<>();
		List<Frota> frotaPJ2 = new ArrayList<>();
		
		Frota frota1 = new Frota("JHA6F98", veiculosPJ1);
		Frota frota2 = new Frota("VHT2A32", veiculosPJ2);

		ClientePJ clientePJ1 = new ClientePJ("07.526.557/0001-00", dateFormat.parse("08/09/2008"), 20, frotaPJ1, "Amnésia Soluções SA", 
				"(19)2569-8472", "Rua Roxo Moreira, 601 - Cidade Universitária, Campinas/SP", "amnesia@solucaos.com");

		ClientePJ clientePJ2 = new ClientePJ("09.227.084/0001-75", dateFormat.parse("13/06/2015"), 80, frotaPJ2, "Testando Soluções SA", 
				"(19)2356-8978", "Rua Amarela, 123 - Centro, Campinas/SP", "testando@solucoes.com.br");
		
		System.out.println("===== toString() classe ClientePJ:\n" + clientePJ1);
		System.out.println("=====\n");
		
		System.out.println("===== toString() classe Frota:\n" + frota1);
		System.out.println("=====\n");
		
		// ===== INSTANCIAR SEGURADORA =====
		
		List<Seguradora> seguradoras = new ArrayList<>();
		
		List<Seguro> seguros1 = new ArrayList<>();
		List<Seguro> seguros2 = new ArrayList<>();
		
		List<Cliente> clientes1 = new ArrayList<>();
		List<Cliente> clientes2 = new ArrayList<>();
		
		Seguradora seguradora1 = new Seguradora("61.198.164/0001-60", "Barão Seguros", "(19)2654-6584",
				"Av. Albino J. B. de Oliveira, 2615 - Santa Isabel, Campinas/SP", "seguradora1@baraoseguros.com", clientes1, seguros1);
		
		Seguradora seguradora2 = new Seguradora("18.236.120/0001-58", "Ativa Seguros", "(19)3659-6547", 
				"Av. Albino J. B. de Oliveira, 125 - Santa Isabel, Campinas/SP", "seguradora1@ativaseguros.com", clientes2, seguros2);
		
		seguradoras.add(seguradora1);
		seguradoras.add(seguradora2);
		
		System.out.println("===== toString() classe Seguradora:\n" + seguradora1);
		System.out.println("=====\n");
		
		// ===== INSTANCIAR SEGUROS PF =====
		
		List<Sinistro> sinistrosPF1 = new ArrayList<>();
		List<Sinistro> sinistrosPF2 = new ArrayList<>();
		
		List<Condutor> condutoresPF1 = new ArrayList<>();
		List<Condutor> condutoresPF2 = new ArrayList<>();
		
		SeguroPF seguroPF1 = new SeguroPF(veiculoPF1, clientePF1, dateFormat.parse("02/09/2021"), dateFormat.parse("02/09/2023"), 
				seguradora1, sinistrosPF1, condutoresPF1);
		
		SeguroPF seguroPF2 = new SeguroPF(veiculoPF2, clientePF1, dateFormat.parse("15/03/2020"), dateFormat.parse("15/03/2022"), 
				seguradora2, sinistrosPF2, condutoresPF2);
		
		System.out.println("===== toString() classe SeguroPF:\n" + seguroPF1);
		System.out.println("=====\n");
		
		// ===== INSTANCIAR SEGUROS PJ =====

		List<Sinistro> sinistrosPJ1 = new ArrayList<>();
		List<Sinistro> sinistrosPJ2 = new ArrayList<>();
		
		List<Condutor> condutoresPJ1 = new ArrayList<>();
		List<Condutor> condutoresPJ2 = new ArrayList<>();

		SeguroPJ seguroPJ1 = new SeguroPJ(frota1, clientePJ1, dateFormat.parse("02/09/2021"), dateFormat.parse("02/09/2023"), 
				seguradora1, sinistrosPJ1, condutoresPJ1);
		
		SeguroPJ seguroPJ2 = new SeguroPJ(frota2, clientePJ2, dateFormat.parse("15/03/2020"), dateFormat.parse("15/03/2022"), 
				seguradora2, sinistrosPJ2, condutoresPJ2);
		
		System.out.println("===== toString() classe SeguroPJ:\n" + seguroPJ1);
		System.out.println("=====\n");
		
		// ===== INSTANCIAR CONDUTORES =====
		
		List<Sinistro> sinistrosCondutor1 = new ArrayList<>();
		List<Sinistro> sinistrosCondutor2 = new ArrayList<>();
		
		Condutor condutor1 = new Condutor("353.491.370-18", "Marcinho do Pneu", "(13)95865-7412", 
				"Rua Atilio de Campos, 1547 - Cumbica, Praia Grande/SP", "marcinho.pneu@gmail.com", dateFormat.parse("15/12/1978"),
				sinistrosCondutor1);
		
		Condutor condutor2 = new Condutor("143.401.630-74", "João Gomes", "(13)95847-3541", 
				"Rua Atilio de Campos, 2658 - Cumbica, Praia Grande/SP", "joao.gomes@gmail.com", dateFormat.parse("02/07/1956"),
				sinistrosCondutor2);
		
		System.out.println("===== toString() classe Condutor:\n" + condutor1);
		System.out.println("=====\n");

		// ===== INSTANCIAR SINISTROS =====

		Sinistro sinistroPF = new Sinistro(dateFormat.parse("27/03/2023"),
				"Av. Professor Atílio Martini, 625 - Cidade Universitária, Campinas/SP", condutor1, seguroPF1);

		Sinistro sinistroPJ = new Sinistro(dateFormat.parse("25/03/2023"),
				"Av. Professor Atílio Martini, 1258 - Cidade Universitária, Campinas/SP", condutor2, seguroPJ1);
		
		System.out.println("===== toString() classe Sinistro:\n" + sinistroPF);
		System.out.println("=====\n");
		
		// ===== CADASTRAR CLIENTES =====
		
		System.out.println("===== Cadastrar Clientes =====\n");
		seguradora1.cadastrarCliente(clientePF1);
		seguradora1.cadastrarCliente(clientePF2);
		seguradora1.cadastrarCliente(clientePJ1);
		seguradora1.cadastrarCliente(clientePJ2);
		System.out.println("=====\n");

		// ===== LISTAR CLIENTES =====

		System.out.println("===== Listar Clientes - \"Pessoa Física\" =====\n");
		seguradora1.listarClientes("Pessoa Fisica");
		System.out.println("=====\n");

		System.out.println("===== Listar Clientes - \"Pessoa Jurídica\" =====\n");
		seguradora1.listarClientes("Pessoa Juridica");
		System.out.println("=====\n");
		
		// ===== GERAR SEGUROS =====
		
		System.out.println("===== Gerar Seguros =====\n");
		seguradora1.gerarSeguro(seguroPF1);
		seguradora1.gerarSeguro(seguroPF2);
		seguradora1.gerarSeguro(seguroPJ1);
		System.out.println("=====\n");

		// ===== VISUALIZAR SINISTROS =====

		System.out.println("===== Visualizar Sinistros =====\n");
		seguradora1.getSinistrosPorCliente(clientePF2);
		seguradora1.getSinistrosPorCliente(clientePJ2);
		System.out.println("=====\n");

		// ===== VISUALIZAR SEGUROS =====

		System.out.println("===== Visualizar Seguros =====\n");
		seguradora1.getSegurosPorCliente(clientePF1);
		seguradora1.getSegurosPorCliente(clientePJ1);
		System.out.println("=====\n");

		// ===== CALCULAR RECEITA =====

		System.out.println("===== Receita da Seguradora =====\n");
		seguradora1.calcularReceita();
		System.out.println("=====\n");

		// ===== MENU DE OPERAÇÕES =====
		
		menuOperacoes(seguradora1, clientePF2, clientePJ2, veiculoPF1, frota1, seguroPF1, sinistroPF);
		
	}
	
	public static void menuOperacoes(Seguradora seguradora, ClientePF clientepf, ClientePJ clientepj, Veiculo veiculo, Frota frota,
			SeguroPF seguro, Sinistro sinistro) {
		Scanner input = new Scanner(System.in);
		List<Seguradora> seguradoras = new ArrayList<>();
		
		MenuOperacoes opcoes = MenuOperacoes.CONTINUE;
		MenuExternoCadastro subOpcoesCadastro = MenuExternoCadastro.CONTINUE;
		MenuExternoListar subOpcoesListar = MenuExternoListar.CONTINUE;
		MenuExternoExcluir subOpcoesExcluir = MenuExternoExcluir.CONTINUE;
		MenuExternoSeguros subOpcoesSeguros = MenuExternoSeguros.CONTINUE;
		MenuExternoSinistros subOpcoesSinistros = MenuExternoSinistros.CONTINUE;
		int selecionado, subSelecionado;
		
		do {
			menu();
			System.out.println("Digite a operação desejada: ");
			selecionado = input.nextInt();
			if ( selecionado == 0)
				break;
			else if (selecionado > MenuOperacoes.values().length - 1) {
				System.out.println("Escolha uma opção válida\n");
			}
			else {
				opcoes = MenuOperacoes.values()[selecionado-1];
				
				switch (opcoes) {
					case CADASTRAR:
						do {
							menuCadastrar();
							System.out.println("Digite a operação desejada: ");
							subSelecionado = input.nextInt();
							if (subSelecionado > MenuExternoCadastro.values().length - 1)
								System.out.println("Escolha uma opção válida\n");
							else 
								subOpcoesCadastro = MenuExternoCadastro.values()[subSelecionado-1];
							
								switch (subOpcoesCadastro) {
									case CADASTRAR_CLIENTE_PF:
										seguradora.cadastrarCliente(clientepf);
										break;
									case CADASTRAR_CLIENTE_PJ:
										seguradora.cadastrarCliente(clientepj);
										break;
									case CADASTRAR_VEICULO_PF:
										clientepf.cadastrarVeiculo(veiculo);
										System.out.println("Veiculo cadastrado\n");
										break;
									case CADASTRAR_VEICULO_PJ:
										frota.adicionarVeiculo(veiculo);
										System.out.println("Veiculo cadastrado\n");
										break;
									case CADASTRAR_FROTA:
										clientepj.cadastrarFrota(frota);
										System.out.println("Frota cadastrada\n");
										break;
									case CADASTRAR_SEGURADORA:
										seguradoras.add(seguradora);
										System.out.println("Seguradora cadastrada\n");
										break;
									case VOLTAR:
										break;
									default:
										System.out.println("Escolha uma opção válida");
								}
								
						} while(subOpcoesCadastro != MenuExternoCadastro.VOLTAR);
						break;
						
					case LISTAR:
						do {
							menuListar();
							System.out.println("Digite a operação desejada: ");
							subSelecionado = input.nextInt();
							if (subSelecionado > MenuExternoListar.values().length - 1)
								System.out.println("Escolha uma opção válida\n");
							else 
								subOpcoesListar = MenuExternoListar.values()[subSelecionado-1];
							
								switch (subOpcoesListar) {
									case LISTAR_CLIENTES_SEGURADORA_PF:
										seguradora.listarClientes("Pessoa Fisica");
										break;
									case LISTAR_CLIENTES_SEGURADORA_PJ:
										seguradora.listarClientes("Pessoa Juridica");
										break;
									case LISTAR_SINISTROS_SEGURADORA:
										seguradora.listarSinistros();
										break;
									case LISTAR_SEGUROS_CLIENTE:
										seguradora.getSegurosPorCliente(clientepf);
										break;
									case LISTAR_SINISTROS_CLIENTE:
										seguradora.getSinistrosPorCliente(clientepj);
										break;
									case VOLTAR:
										break;
									default:
										System.out.println("Escolha uma opção válida");
								} 
								
						} while(subOpcoesListar != MenuExternoListar.VOLTAR);
						break;
						
					case EXCLUIR:
						do {
							menuExcluir();
							System.out.println("Digite a operação desejada: ");
							subSelecionado = input.nextInt();
							subOpcoesExcluir = MenuExternoExcluir.values()[subSelecionado-1];
							
							switch (subOpcoesExcluir) {
								case EXCLUIR_CLIENTE_PF:
									seguradora.removerCliente(clientepf);
									System.out.println("Cliente excluido\n");
									break;
								case EXCLUIR_CLIENTE_PJ:
									seguradora.removerCliente(clientepj);
									System.out.println("Cliente excluido\n");
									break;
								case EXCLUIR_VEICULO_PF:
									clientepf.removerVeiculo(veiculo);
									System.out.println("Veiculo excluido\n");
									break;
								case EXCLUIR_VEICULO_PJ:
									frota.removerVeiculo(veiculo);
									System.out.println("Veiculo excluido\n");
									break;
								case EXCLUIR_FROTA:
									clientepj.removerFrota(frota);
									System.out.println("Frota cadastrada\n");
									break;
								case EXCLUIR_SEGURADORA:
									seguradoras.remove(seguradora);
									System.out.println("Seguradora cadastrada\n");
									break;
								case VOLTAR:
									break;
								default:
									System.out.println("Escolha uma opção válida");
							} 
						
						} while(subOpcoesExcluir != MenuExternoExcluir.VOLTAR);
						break;
						
					case SEGUROS:
						do {
							menuSeguros();
							System.out.println("Digite a operação desejada: ");
							subSelecionado = input.nextInt();
							subOpcoesSeguros = MenuExternoSeguros.values()[subSelecionado-1];
							
							switch (subOpcoesSeguros) {
								case GERAR_SEGURO:
									seguradora.gerarSeguro(seguro);
									break;
								case CANCELAR_SEGURO:
									seguradora.cancelarSeguro(seguro);
									break;
								case VOLTAR:
									break;
								default:
									System.out.println("Escolha uma opção válida");
							} 
						
						} while(subOpcoesSeguros != MenuExternoSeguros.VOLTAR);
						break;
						
					case SINISTROS:
						do {
							menuSinistros();
							System.out.println("Digite a operação desejada: ");
							subSelecionado = input.nextInt();
							subOpcoesSinistros = MenuExternoSinistros.values()[subSelecionado-1];
							
							switch (subOpcoesSinistros) {
								case GERAR_SINISTRO:
									seguro.gerarSinistro(sinistro);
									break;
								case CANCELAR_SINISTRO:
									seguro.cancelarSinistro(sinistro);
									break;
								case VOLTAR:
									break;
								default:
									System.out.println("Escolha uma opção válida");
							} 
						
						} while(subOpcoesSinistros != MenuExternoSinistros.VOLTAR);
						break;
					case CALCULAR_RECEITA:
						System.out.println("A receita da seguradora é: ");
						seguradora.calcularReceita();
						break;
					case SAIR:
						break;
					default:
						System.out.println("Escolha uma opção válida");
				}
			}
		} while(opcoes != MenuOperacoes.SAIR);
		System.out.println("Você saiu do sistema");
		
		input.close();
	}

	public static void menu() {
		System.out.println("===== Menu ====\n");
		System.out.println(
				"1 - Cadastrar\n" +
				"2 - Listar\n" +
				"3 - Excluir\n" +
				"4 - Seguros\n" +
				"5 - Sinistros\n" +
				"6 - Calcular Receita da seguradora\n" +
				"0 - Sair\n"
		);
		System.out.println("===============\n");
	}
	
	public static void menuCadastrar() {
		System.out.println("===== Menu ====\n");
		System.out.println(
				"1 - Cadastrar Cliente PF\n" +
				"2 - Cadastrar Cliente PJ\n" +
				"3 - Cadastrar Veiculo PF\n" +
				"4 - Cadastrar Veiculo PJ\n" +
				"5 - Cadastrar Frota\n" +
				"6 - Cadastrar seguradora\n" +
				"7 - Voltar\n"
		);
		System.out.println("===============\n");
	}
	
	public static void menuListar() {
		System.out.println("===== Menu ====\n");
		System.out.println(
				"1 - Listar Clientes PF/PJ por seguradora\n" +
				"2 - Listar Sinistros por seguradora\n" +
				"3 - Listar Sinistros por Cliente\n" +
				"4 - Listar Veiculos por Cliente\n" +
				"5 - Listar Veiculo por seguradora\n" +
				"6 - Voltar\n"
		);
		System.out.println("===============\n");
	}
	
	public static void menuExcluir() {
		System.out.println("===== Menu ====\n");
		System.out.println(
				"1 - Excluir Cliente PF\n" +
				"2 - Excluir Cliente PJ\n" +
				"3 - Excluir Veiculo PF\n" +
				"4 - Excluir Veiculo PJ\n" +
				"5 - Excluir Frota\n" +
				"6 - Excluir seguradora\n" +
				"7 - Voltar\n"
		);
		System.out.println("===============\n");
	}
	
	public static void menuSeguros() {
		System.out.println("===== Menu ====\n");
		System.out.println(
				"1 - Gerar Seguro\n" +
				"2 - Cancelar Seguro\n" +
				"3 - Voltar\n"
		);
		System.out.println("===============\n");
	}
	
	public static void menuSinistros() {
		System.out.println("===== Menu ====\n");
		System.out.println(
				"1 - Gerar Sinitro\n" +
				"2 - Remover Sinitro\n" +
				"3 - Voltar\n"
		);
		System.out.println("===============\n");
	}

}
