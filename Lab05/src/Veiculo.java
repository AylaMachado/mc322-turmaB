
public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	
	// Constructor
	public Veiculo (String placa, String marca, String modelo, int anoFabricacao) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
	}
	
	// Getters e setters
	public String getPlaca() {
		return placa;
	}
		
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	public String toString() {
		String out = "Placa = " + getPlaca() + "\n";
		out = out + "Marca = " + getMarca() + "\n";
		out = out + "Modelo = " + getModelo() + "\n";
		out = out + "Ano de Fabricação = " + getAnoFabricacao() + "\n";
		return out;
	}
}
