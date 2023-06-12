import java.text.NumberFormat;
import java.util.List;

public class Seguradora {
	private final String CNPJ;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private List<Cliente> listaClientes;
	private List<Seguro> listaSeguros;
	
	// Constructor
	public Seguradora(String CNPJ, String nome, String telefone, String endereco, String email, List<Cliente> listaClientes, 
			List<Seguro> listaSeguros) {
		this.CNPJ = CNPJ;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaClientes = listaClientes;
		this.listaSeguros = listaSeguros;
	}

	// Getters e setters
	public String getCNPJ() {
		return CNPJ;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	

	public List<Seguro> getListaSeguros() {
		return listaSeguros;
	}

	public void setListaSeguros(List<Seguro> listaSeguros) {
		this.listaSeguros = listaSeguros;
	}
	
	// Listar clientes por tipo
	public void listarClientes(String tipoCliente) {
		int contagem = 1;
		for (int i = 0; i < this.listaClientes.size(); i++) {
			if ((tipoCliente.equals("Pessoa Fisica") && this.listaClientes.get(i) instanceof ClientePF) ||
			 (tipoCliente.equals("Pessoa Juridica") && this.listaClientes.get(i) instanceof ClientePJ)) {
				System.out.println("-- Cliente " + contagem + " --");
				System.out.println(this.listaClientes.get(i));
				contagem++;
			}
		}
	}
	
	// Gerar um seguro
	public boolean gerarSeguro(Seguro seguro) {
		if (listaSeguros.add(seguro)) {
			System.out.println("Seguro gerado:\n");
			System.out.println(seguro);
			return true;
		}
		return false;
	}
	
	// Cancelar um seguro
	public boolean cancelarSeguro(Seguro seguro) {
		if (listaSeguros.remove(seguro)) {
			System.out.println("Seguro cancelado:\n");
			System.out.println(seguro);
			return true;
		}
		return false;
	}

	// Cadastrar um cliente
	public boolean cadastrarCliente(Cliente cliente) {
		if (listaClientes.add(cliente)) {
			System.out.println("Cliente cadastrado:\n");
			System.out.println(cliente);
			return true;
		}
		return false;
	}

	// Remover um cliente
	public boolean removerCliente(Cliente cliente) {
		if (listaClientes.remove(cliente)) {
			System.out.println("Cliente removido:\n");
			System.out.println(cliente);
			return true;
		}
		return false;
	}
	
	// Listar seguros por cliente
	public void getSegurosPorCliente(Cliente cliente) {
		System.out.println("--- Seguros do cliente: " + cliente.nome + " ---\n");
		int contagem = 1;
		for (int i = 0; i < this.listaSeguros.size(); i++) {
			if (cliente == this.listaSeguros.get(i).getCliente()) {
				System.out.println("-- Seguro " + contagem + " --");
				System.out.println(this.listaSeguros.get(i));
				contagem++;
			}
		}
	}
	
	// Listar sinistros por cliente
	public void getSinistrosPorCliente(Cliente cliente) {
		System.out.println("--- Sinistros do cliente: " + cliente.nome + " ---\n");
		int contagem = 1;
		for (int i = 0; i < this.listaSeguros.get(i).getListaSinistros().size(); i++) {
			if (cliente == this.listaSeguros.get(i).getCliente()) {
				System.out.println("-- Sinistro " + contagem + " --");
				System.out.println(this.listaSeguros.get(i).getListaSinistros());
				contagem++;
			}
		}
	}
	
	// Calcular receita da seguradora 
	public void calcularReceita() {
		double valor = 0;
		for (int i = 0; i < this.listaSeguros.size(); i++) {
			valor = valor + listaSeguros.get(i).valorMensal;
		}
		System.out.println(NumberFormat.getCurrencyInstance().format(valor) + "\n");
	}

	// Listar sinistros da seguradora
	public void listarSinistros() {
		int contagem = 1;
		for (int i = 0; i < this.listaSeguros.size(); i++) {
			for (int j = 0; j < this.listaSeguros.get(i).listaSinistros.size(); j++) {
			System.out.println("-- Sinistro " + contagem + " --");
			System.out.println(this.listaSeguros.get(i).listaSinistros.get(j));
			contagem++;
			}
		}
	}
	
	public String toStringSimples() {
		String out = "Nome = " + getNome() + "\n";
		out = out + "Telefone = " + getTelefone() + "\n";
		out = out + "Endereço = " + getEndereco() + "\n";
		out = out + "Email = " + getEmail() + "\n";
		if (Validacao.validaCNPJ(CNPJ))
			out = out + "CNPJ = " + getCNPJ() + "\n";
		else
			out = out + "CNPJ = Número inválido \n";
		return out;
	}

	public String toString() {
		String out = "Nome = " + getNome() + "\n";
		out = out + "Telefone = " + getTelefone() + "\n";
		out = out + "Endereço = " + getEndereco() + "\n";
		out = out + "Email = " + getEmail() + "\n";
		if (Validacao.validaCNPJ(CNPJ))
			out = out + "CNPJ = " + getCNPJ() + "\n";
		else
			out = out + "CNPJ = Número inválido \n";
		out = out + "Lista de Clientes: \n\n";
		for (int i = 0; i < this.listaClientes.size(); i++) {
			out = out + "-- Cliente " + (i+1) + " --\n";
			out = out + this.listaClientes.get(i) + "\n";
		}
		out = out + "Lista de Seguros: \n\n";
		for (int i = 0; i < this.listaSeguros.size(); i++) {
			out = out + "-- Seguros " + (i+1) + " --\n";
			out = out + this.listaSeguros.get(i) + "\n";
		}
		
		return out;
	}
}