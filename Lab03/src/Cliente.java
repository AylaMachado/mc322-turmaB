import java.util.List;

public class Cliente {
	protected String nome;
	protected String endereco;
	protected List<Veiculo> listaVeiculos;
	
	// Constructor
	public Cliente (String nome, String endereco, List<Veiculo> listaVeiculos) {
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = listaVeiculos;
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
	
	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public String toStringSimples() {
		String out = "Nome = " + getNome() + "\n";
		out = out + "Endereço = " + getEndereco() + "\n";
		return out;
	}
	
	@Override
	public String toString() {
		String out = "Nome = " + getNome() + "\n";
		out = out + "Endereço = " + getEndereco() + "\n";
		out = out + "Lista de Veículos = \n" + getListaVeiculos() + "\n";
		return out;
	}
}
