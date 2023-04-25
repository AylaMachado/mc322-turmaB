import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ParseException {
		List<Cliente> clientes = new ArrayList<>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		// ===== CRIAR CLIENTES PF =====
		// Cliente PF
		List<Veiculo> veiculosPF1 = new ArrayList<>();
		Veiculo veiculoPF1 = new Veiculo("BHK5Y62", "Ford", "Ranger", 2018);
		veiculosPF1.add(veiculoPF1);
		
		System.out.println("===== toString() classe Veiculo:\n" + veiculoPF1);
		System.out.println("=====\n");
		
		
		ClientePF clientePF1 = new ClientePF("466.534.108-70", "feminino", formatter.parse("2022-10-11"), "Engenharia de Computação (cursando)", formatter.parse("1999-03-17"),
				"Primeira classe", "Ayla Machado", "Rua Roxo Moreira, 601 - Cidade Universitária, Campinas/SP", veiculosPF1);
		System.out.println("===== Validação CPF: " + clientePF1.validarCPF(clientePF1.getCPF()) + " =====\n");
		
		System.out.println("===== toString() classe ClientePF:\n" + clientePF1);
		System.out.println("=====\n");
		clientes.add(clientePF1);
		
		// Cliente PF a ser removido
		List<Veiculo> veiculosPF2 = new ArrayList<>();
		Veiculo veiculoPF2 = new Veiculo("THU5N36", "ford", "Focus", 2018); 
		veiculosPF2.add(veiculoPF2);

		ClientePF clientePF2 = new ClientePF("453.066.068-06", "feminino", formatter.parse("2023-02-11"), "Engenharia de Computação (cursando)", formatter.parse("1997-12-26"),
				"Primeira classe", "Maria Lobo", "Rua Roxo Moreira, 601 - Cidade Universitária, Campinas/SP", veiculosPF2);
		
		// ===== CRIAR CLIENTES PJ =====
		// Cliente PJ
		List<Veiculo> veiculosPJ1 = new ArrayList<>();
		Veiculo veiculoPJ1 = new Veiculo("AMK5Y62", "Renault", "Sandero", 2013); 
		veiculosPJ1.add(veiculoPJ1);
		
		ClientePJ clientePJ1 = new ClientePJ("07.526.557/0001-00", formatter.parse("2008-09-08"), "Amnésia Soluções SA",
				"Rua Roxo Moreira, 601 - Cidade Universitária, Campinas/SP", veiculosPJ1);
		System.out.println("===== Validação CNPJ: " + clientePJ1.validarCNPJ(clientePJ1.getCNPJ()) + " =====\n");

		System.out.println("===== toString() classe ClientePJ:\n" + clientePJ1 + "=====");
		System.out.println("=====\n");
		clientes.add(clientePJ1);
		
		// Cliente PJ a ser removido
		List<Veiculo> veiculosPJ2 = new ArrayList<>();
		Veiculo veiculoPJ2 = new Veiculo("BLA5Y63", "chevrolet", "HB20", 2016); 
		veiculosPJ2.add(veiculoPJ2);

		ClientePJ clientePJ2 = new ClientePJ("07.526.557/0001-00", formatter.parse("2008-10-11"), "Testando Soluções SA",
				"Rua Amarela, 123 - Centro, Campinas/SP", veiculosPJ2);

		// ===== CRIAR SEGURADORA =====
		List<Sinistro> sinistros = new ArrayList<>();
		Seguradora seguradora = new Seguradora("Barão Seguros", "(19) 2651-6584", "seguradora@baraoseguros.com",
				"Av. Albino J. B. de Oliveira, 2615 - Santa Isabel, Campinas/SP", sinistros, clientes);
		
		// ===== ADD CLIENTES À SEGURADORA =====
		seguradora.cadastrarCliente(clientePJ2);
		seguradora.cadastrarCliente(clientePF2);
		
		// ===== CRIAR SINISTROS =====
		Sinistro sinistroPF = new Sinistro("27/03/2023", "Av. Professor Atílio Martini, 625 - Cidade Universitária, Campinas/SP",
				seguradora, veiculoPF1, clientePF1);

		System.out.println("===== toString() classe Sinistro:\n" + sinistroPF);
		System.out.println("=====\n");
		
		seguradora.gerarSinistro(sinistroPF);

		Sinistro sinistroPJ = new Sinistro("28/03/2023", "Av. Professor Atílio Martini, 625 - Cidade Universitária, Campinas/SP",
				seguradora, veiculoPJ2, clientePJ1);
		seguradora.gerarSinistro(sinistroPJ);
		
		System.out.println("===== listarSinistros()\n");
		seguradora.listarSinistros();
		System.out.println("=====\n");
		
		System.out.println("===== visualizarSinistros()\n");
		seguradora.visualizarSinistros(clientePF1);
		System.out.println("=====\n");

		// ===== REMOVER CLIENTES =====
		seguradora.removerCliente(clientePF2);
		seguradora.removerCliente(clientePJ2);
		
		System.out.println("===== listarClientes(\"Pessoa Física\"):\n");
		seguradora.listarClientes("Pessoa Física");
		System.out.println("=====\n");
		
		System.out.println("===== listarClientes(\"Pessoa Jurídica\"):\n");
		seguradora.listarClientes("Pessoa Jurídica");
		System.out.println("=====\n");
		
		System.out.println("===== toString() classe Seguradora:\n" + seguradora);
		System.out.println("=====\n");
		
		// Receber parâmetros pelo terminal
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o tipo de cliente da seguradora que você deseja visualizar: ");
		String tipoCliente = scan.nextLine().trim().replace("\n", "");
		seguradora.listarClientes(tipoCliente);
		scan.close();
		
	}
}
