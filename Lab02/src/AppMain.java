import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppMain {

	public static void main(String[] args) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		// ===== INSTANCIAR CLIENTES PF E VEÍCULOS =====

		List<Veiculo> veiculosPF = new ArrayList<>();
		Veiculo veiculoPF = new Veiculo("JHS5S98", "Fiat", "Palio", 2015); 
		
		List<Veiculo> veiculosPF1 = new ArrayList<>();
		Veiculo veiculoPF1 = new Veiculo("BHK5Y62", "Ford", "Ranger", 2018);
		veiculosPF1.add(veiculoPF1);

		ClientePF clientePF1 = new ClientePF("466.534.108-70", "feminino", dateFormat.parse("11/10/2022"),
				"Engenharia de Computação (cursando)", dateFormat.parse("19/05/1987"), "Primeira classe", "Ayla Machado",
				"Rua Roxo Moreira, 601 - Cidade Universitária, Campinas/SP", veiculosPF1);

		List<Veiculo> veiculosPF2 = new ArrayList<>();
		Veiculo veiculoPF2 = new Veiculo("THU5N36", "ford", "Focus", 2018);
		Veiculo veiculoPF3 = new Veiculo("UHF6H49", "ford", "Ka", 2009);
		veiculosPF2.add(veiculoPF2);
		veiculosPF1.add(veiculoPF);

		ClientePF clientePF2 = new ClientePF("453.066.068-06", "feminino", dateFormat.parse("17/05/2016"),
				"Engenharia de Computação (cursando)", dateFormat.parse("15/04/1999"), "Primeira classe", "Maria Lobo",
				"Rua Roxo Moreira, 601 - Cidade Universitária, Campinas/SP", veiculosPF2);

		// ===== INSTANCIAR CLIENTES PJ E VEÍCULOS =====

		List<Veiculo> veiculosPJ1 = new ArrayList<>();
		Veiculo veiculoPJ1 = new Veiculo("AMK5Y62", "Renault", "Sandero", 2013);
		veiculosPJ1.add(veiculoPJ1);

		ClientePJ clientePJ1 = new ClientePJ("07.526.557/0001-00", dateFormat.parse("08/09/2008"), 20,
				"Amnésia Soluções SA", "Rua Roxo Moreira, 601 - Cidade Universitária, Campinas/SP", veiculosPJ1);

		List<Veiculo> veiculosPJ2 = new ArrayList<>();
		Veiculo veiculoPJ2 = new Veiculo("BLA5Y63", "chevrolet", "HB20", 2016);
		veiculosPJ2.add(veiculoPJ2);

		ClientePJ clientePJ2 = new ClientePJ("07.526.557/0001-00", dateFormat.parse("13/06/2015"), 80,
				"Testando Soluções SA", "Rua Amarela, 123 - Centro, Campinas/SP", veiculosPJ2);

		// ===== INSTANCIAR SEGURADORA =====
		
		List<Cliente> clientes = new ArrayList<>();
		List<Cliente> clientes2 = new ArrayList<>();
		List<Sinistro> sinistros = new ArrayList<>();
		List<Sinistro> sinistros2 = new ArrayList<>();
		List<Seguradora> seguradoraList = new ArrayList<>();
		
		Seguradora seguradora = new Seguradora("Barão Seguros", "(19) 2651-6584", "seguradora@baraoseguros.com",
				"Av. Albino J. B. de Oliveira, 2615 - Santa Isabel, Campinas/SP", sinistros, clientes);
		
		Seguradora seguradora2 = new Seguradora("Ativa Seguros", "(19) 3659-6547", "seguradora@ativaseguros.com",
				"Av. Albino J. B. de Oliveira, 125 - Santa Isabel, Campinas/SP", sinistros2, clientes2);

		// ===== CADASTRAR CLIENTES NA SEGURADORA =====

		seguradora.cadastrarCliente(clientePJ1);
		seguradora.cadastrarCliente(clientePF1);
		seguradora.cadastrarCliente(clientePJ2);
		seguradora.cadastrarCliente(clientePF2);

		// ===== GERAR SINISTROS =====

		Sinistro sinistroPF = new Sinistro(dateFormat.parse("27/03/2023"),
				"Av. Professor Atílio Martini, 625 - Cidade Universitária, Campinas/SP", seguradora, veiculoPF1,
				clientePF1);
		seguradora.gerarSinistro(sinistroPF);

		Sinistro sinistroPJ = new Sinistro(dateFormat.parse("25/03/2023"),
				"Av. Professor Atílio Martini, 1258 - Cidade Universitária, Campinas/SP", seguradora, veiculoPJ2,
				clientePJ1);
		seguradora.gerarSinistro(sinistroPJ);

		// ===== LISTAR CLIENTES =====

		System.out.println("===== Listar Clientes - \"Pessoa Física\" =====\n");
		seguradora.listarClientes("Pessoa Física");
		System.out.println("=====\n");

		System.out.println("===== Listar Clientes - \"Pessoa Jurídica\" =====\n");
		seguradora.listarClientes("Pessoa Jurídica");
		System.out.println("=====\n");

		// ===== VISUALIZAR SINISTROS =====

		System.out.println("===== Visualizar Sinistros =====\n");
		seguradora.visualizarSinistros(clientePF1);
		seguradora.visualizarSinistros(clientePJ1);
		System.out.println("=====\n");

		// ===== LISTAR SINISTROS =====

		System.out.println("===== Listar Sinistros =====\n");
		seguradora.listarSinistros();
		System.out.println("=====\n");

		// ===== CALCULAR RECEITA =====

		System.out.println("===== Receita da Seguradora =====\n");
		seguradora.calcularReceita();
		System.out.println("=====\n");

		// ===== MENU DE OPERAÇÕES =====

		Scanner input = new Scanner(System.in);
		MenuOperacoes opcoes = MenuOperacoes.CONTINUE;
		MenuExternoCadastro subOpcoesCadastro = MenuExternoCadastro.CONTINUE;
		MenuExternoListar subOpcoesListar = MenuExternoListar.CONTINUE;
		MenuExternoExcluir subOpcoesExcluir = MenuExternoExcluir.CONTINUE;
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
									case CADASTRAR_CLIENTE_PF_PJ:
										seguradora.cadastrarCliente(clientePF1);
										System.out.println("Cliente cadastrado\n");
										break;
									case CADASTRAR_VEICULO:
										seguradora.cadastrarVeiculo(veiculoPF3, clientePF1);
										veiculosPF.add(veiculoPF);
										System.out.println("Veiculo cadastrado\n");
										break;
									case CADASTRAR_SEGURADORA:
										seguradoraList.add(seguradora2);
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
									case LISTAR_CLIENTES_SEGURADORA:
										seguradora.listarClientes("Pessoa Física");
										break;
									case LISTAR_SINISTROS_SEGURADORA:
										seguradora.listarSinistros();
										break;
									case LISTAR_SINISTROS_CLIENTE:
										seguradora.visualizarSinistros(clientePF1);
										break;
									case LISTAR_VEICULOS_CLIENTE:
										seguradora.visualizarVeiculos(clientePF1);
										break;
									case LISTAR_VEICULOS_SEGURADORA:
										seguradora.listarVeiculos();
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
								case EXCLUIR_CLIENTE:
									seguradora.removerCliente(clientePF1);
									System.out.println("Cliente excluido\n");
									break;
								case EXCLUIR_VEICULO:
									seguradora.removerVeiculo(veiculoPF3, clientePF1);
									System.out.println("Veiculo excluido\n");
									break;
								case EXCLUIR_SINISTRO:
									seguradora.excluirSinistro(sinistroPJ);
									System.out.println("Sinistro excluido\n");
									break;
								case VOLTAR:
									break;
								default:
									System.out.println("Escolha uma opção válida");
							} 
						
						} while(subOpcoesExcluir != MenuExternoExcluir.VOLTAR);
						break;
						
					case GERAR_SINISTRO:
						seguradora.gerarSinistro(sinistroPJ);
						System.out.println("Sinistro Gerado\n");
						break;
					case TRANSFERIR_SEGURO:
						seguradora.transferirSeguro(clientePF1, clientePF2);
						System.out.println("Seguro Transferido\n");
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
				"4 - Gerar Sinistro\n" +
				"5 - Transferir Seguro\n" +
				"6 - Calcular Receita da Seguradora\n" +
				"0 - Sair\n"
		);
		System.out.println("===============\n");
	}
	
	public static void menuCadastrar() {
		System.out.println("===== Menu ====\n");
		System.out.println(
				"1 - Cadastrar Cliente PF/PJ\n" +
				"2 - Cadastrar Veiculo\n" +
				"3 - Cadastrar Seguradora\n" +
				"4 - Voltar\n"
		);
		System.out.println("===============\n");
	}
	
	public static void menuListar() {
		System.out.println("===== Menu ====\n");
		System.out.println(
				"1 - Listar Clientes PF/PJ por Seguradora\n" +
				"2 - Listar Sinistros por Seguradora\n" +
				"3 - Listar Sinistros por Cliente\n" +
				"4 - Listar Veiculos por Cliente\n" +
				"5 - Listar Veiculo por Seguradora\n" +
				"6 - Voltar\n"
		);
		System.out.println("===============\n");
	}
	
	public static void menuExcluir() {
		System.out.println("===== Menu ====\n");
		System.out.println(
				"1 - Excluir Cliente\n" +
				"2 - Excluir Veiculo\n" +
				"3 - Excluir Sinistro\n" +
				"4 - Voltar\n"
		);
		System.out.println("===============\n");
	}

}
