
public abstract class Cliente {
	protected String nome;
	protected String telefone;
	protected String endereco;
	protected String email;
	
	// Constructor
	public Cliente (String nome, String telefone, String endereco, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
	}

	// Getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public double calculaScore() {
		return 0;
	}

	public String toString() {
		String out;
		if (Validacao.validaNome(nome))
			out = "Nome = " + getNome() + "\n";
		else
			out = "Nome = Número inválido \n";
		out = out + "Telefone = " + getTelefone() + "\n";
		out = out + "Endereço = " + getEndereco() + "\n";
		out = out + "Email = " + getEmail() + "\n";
		return out;
	}
}
