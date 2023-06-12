import java.util.List;

public class Frota {
	private String code;
	private List<Veiculo> listaVeiculos;

	// Constructor
	public Frota(String code, List<Veiculo> listaVeiculos) {
		this.code = code;
		this.listaVeiculos = listaVeiculos;
	}

	// Getters e setters
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	// Adicionar um veiculo
	public boolean adicionarVeiculo(Veiculo veiculo) {
		if (listaVeiculos.add(veiculo))
			return true;
		return false;
	}
	
	// Remover um veiculo
	public boolean removerVeiculo(Veiculo veiculo) {
		if (listaVeiculos.remove(veiculo))
			return true;
		return false;
	}
	
	public String toString() {
		String out;
		out = "Código = " + getCode() + "\n";
		out = out + "Lista de Veiculos = " + getListaVeiculos() + "\n";
		return out;
	}
}
