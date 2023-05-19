import java.text.NumberFormat;
import java.util.List;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private List<Sinistro> listaSinistros;
	private List<Cliente> listaClientes;

	// Constructor
	public Seguradora(String nome, String telefone, String email, String endereco, List<Sinistro> listaSinistros,
			List<Cliente> listaClientes) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaSinistros = listaSinistros;
		this.listaClientes = listaClientes;
	}

	// Getters e setters
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Sinistro> getListaSinistros() {
		return listaSinistros;
	}

	public void setListaSinistros(List<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	// Cadastrar um cliente
	public boolean cadastrarCliente(Cliente cliente) {
		if (listaClientes.add(cliente)) {
			cliente.valorSeguro = calcularPrecoSeguroCliente(cliente);
			return true;
		}
		return false;
	}

	// Remover um cliente
	public boolean removerCliente(Cliente cliente) {
		if (listaClientes.remove(cliente))
			return true;
		return false;
	}
	
	// Cadastrar um veiculo
	public boolean cadastrarVeiculo(Veiculo veiculo, Cliente cliente) {
		if (cliente.listaVeiculos.add(veiculo))
			return true;
		return false;
	}
	
	// Remover um veiculo
	public boolean removerVeiculo(Veiculo veiculo, Cliente cliente) {
		if (cliente.listaVeiculos.remove(veiculo))
			return true;
		return false;
	}

	// Gerar um sinistro
	public boolean gerarSinistro(Sinistro sinistro) {
		if (listaSinistros.add(sinistro))
			return true;
		return false;
	}
	
	// Excluir um sinistro
	public boolean excluirSinistro(Sinistro sinistro) {
		if (listaSinistros.remove(sinistro))
			return true;
		return false;
	}

	// Visualizar sinistros por cliente
	public void visualizarSinistros(Cliente cliente) {
		for (int i = 0; i < this.listaSinistros.size(); i++) {
			if (this.listaSinistros.get(i).getCliente() == cliente) {
				System.out.println("-- Sinistro " + (i+1) + " --");
				System.out.println(this.listaSinistros.get(i));
			}
		}
    }
	
	// Visualizar veiculos por cliente
	public void visualizarVeiculos(Cliente cliente) {
		System.out.println("--- Veiculos do cliente: " + cliente.nome + " ---\n");
		for (int i = 0; i < cliente.listaVeiculos.size(); i++) {
				System.out.println("-- Veiculo " + (i+1) + " --");
				System.out.println(cliente.listaVeiculos.get(i));
		}
    }

	// Listar clientes por tipo
	public void listarClientes(String tipoCliente) {
		int contagem = 1;
		for (int i = 0; i < this.listaClientes.size(); i++) {
			if ((tipoCliente.equals("Pessoa Física") && this.listaClientes.get(i) instanceof ClientePF) ||
			 (tipoCliente.equals("Pessoa Jurídica") && this.listaClientes.get(i) instanceof ClientePJ)) {
				System.out.println("-- Cliente " + contagem + " --");
				System.out.println(this.listaClientes.get(i));
				contagem++;
			}
		}
	}

	// Listar sinistros da seguradora
	public void listarSinistros() {
		for (int i = 0; i < this.listaSinistros.size(); i++) {
			System.out.println("-- Sinistro " + (i+1) + " --");
			System.out.println(this.listaSinistros.get(i));
		}
	}
	
	// Listar veiculos da seguradora
	public void listarVeiculos() {
		int contagem = 1;
		for (int i = 0; i < this.listaClientes.size(); i++) {
			for (int j = 0; j < this.listaClientes.get(i).listaVeiculos.size(); j++) {
				System.out.println("-- Veiculo " + contagem + " --");
				System.out.println(listaClientes.get(i).listaVeiculos.get(j));
				contagem++;
			}
		}
	}
	
	// Calcular o valor do seguro de um cliente
	public double calcularPrecoSeguroCliente(Cliente cliente) {
		double valor = 0, quantidadeSinistros = 0;
		for (int i = 0; i < this.listaSinistros.size(); i++) 
			if (listaSinistros.get(i).getCliente() == cliente)
				quantidadeSinistros++;
		if (cliente instanceof ClientePF)
			valor = (((ClientePF)cliente).calculaScore(cliente.getListaVeiculos())*(1 + quantidadeSinistros));
		else if (cliente instanceof ClientePJ)
			valor = (((ClientePJ)cliente).calculaScore(cliente.getListaVeiculos())*(1 + quantidadeSinistros));
		return valor;
	}
	
	// Calcular receita da seguradora 
	public void calcularReceita() {
		double valor = 0;
		for (int i = 0; i < this.listaClientes.size(); i++) {
			valor = valor + listaClientes.get(i).valorSeguro;
		}
		System.out.println(NumberFormat.getCurrencyInstance().format(valor) + "\n");
	}
	
	// Transferir seguro
	public boolean transferirSeguro(Cliente clienteAtual, Cliente novoCliente) {
		cadastrarCliente(novoCliente);
		novoCliente.listaVeiculos = clienteAtual.listaVeiculos;
		removerCliente(clienteAtual);
		return false;
	}
	
	public String toStringSimples() {
		String out = "Nome = " + getNome() + "\n";
		out = out + "Telefone = " + getTelefone() + "\n";
		out = out + "Email = " + getEmail() + "\n";
		out = out + "Endereço = " + getEndereco() + "\n";
		return out;
	}

	public String toString() {
		String out = "Nome = " + getNome() + "\n";
		out = out + "Telefone = " + getTelefone() + "\n";
		out = out + "Email = " + getEmail() + "\n";
		out = out + "Endereço = " + getEndereco() + "\n";
		out = out + "Lista de Sinistros: \n\n";
		for (int i = 0; i < this.listaSinistros.size(); i++) {
			out = out + "-- Sinistro " + (i+1) + " --\n";
			out = out + this.listaSinistros.get(i) + "\n";
		}
		out = out + "Lista de Clientes: \n\n";
		for (int i = 0; i < this.listaClientes.size(); i++) {
			out = out + "-- Cliente " + (i+1) + " --\n";
			out = out + this.listaClientes.get(i) + "\n";
		}
		return out;
	}
}