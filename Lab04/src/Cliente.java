import java.text.NumberFormat;
import java.util.List;

public class Cliente {
	protected String nome;
	protected String endereco;
	protected List<Veiculo> listaVeiculos;
	protected double valorSeguro;
	
	// Constructor
	public Cliente (String nome, String endereco, List<Veiculo> listaVeiculos) {
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = listaVeiculos;
		this.valorSeguro = 0;
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
	
	public double getValorSeguro() {
		return valorSeguro;
	}
	
	public double calculaScore() {
		return 0;
	}

	public String toStringSimples() {
		String out;
		if (Validacao.validaNome(nome))
			out = "Nome = " + getNome() + "\n";
		else
			out = "Nome = Número inválido \n";
		out = out + "Endereço = " + getEndereco() + "\n";
		out = out + "Valor do Seguro = " + NumberFormat.getCurrencyInstance().format(getValorSeguro()) + "\n";
		return out;
	}

	public String toString() {
		String out;
		if (Validacao.validaNome(nome))
			out = "Nome = " + getNome() + "\n";
		else
			out = "Nome = Número inválido \n";
		out = out + "Endereço = " + getEndereco() + "\n";
		out = out + "Valor do Seguro = " + NumberFormat.getCurrencyInstance().format(getValorSeguro()) + "\n";
		out = out + "Lista de Veículos = \n" + getListaVeiculos() + "\n";
		return out;
	}
}
