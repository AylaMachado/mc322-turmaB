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
		if (listaClientes.add(cliente))
			return true;
		return false;
	}

	// Remover um cliente
	public boolean removerCliente(Cliente cliente) {
		if (listaClientes.remove(cliente))
			return true;
		return false;
	}

	// Listar clientes por tipo
	 public void listarClientes(String tipoCliente) {
		 int contagem = 1;
		 for (int i = 0; i < this.listaSinistros.size(); i++) {
			 if ((tipoCliente.equals("Pessoa Física") && this.listaClientes.get(i) instanceof ClientePF) ||
					 (tipoCliente.equals("Pessoa Jurídica") && this.listaClientes.get(i) instanceof ClientePJ)) {
				 System.out.println("-- Cliente " + contagem + " --");
				 System.out.println(this.listaClientes.get(i));
			 }
		}
	}

	// Função para gerar um sinistro
	public boolean gerarSinistro(Sinistro sinistro) {
		if (listaSinistros.add(sinistro))
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

	// Listar sinistros da seguradora
	public void listarSinistros() {
		System.out.println("Sinistros: \n\n");
		for (int i = 0; i < this.listaSinistros.size(); i++) {
			System.out.println("-- Sinistro " + (i+1) + " --");
			System.out.println(this.listaSinistros.get(i));
		}
	}
	
	public String toStringSimples() {
		String out = "Nome = " + getNome() + "\n";
		out = out + "Telefone = " + getTelefone() + "\n";
		out = out + "Email = " + getEmail() + "\n";
		out = out + "Endereço = " + getEndereco() + "\n";
		return out;
	}

	@Override
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