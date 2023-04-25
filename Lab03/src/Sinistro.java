import java.util.Random;

public class Sinistro {
	private final int ID;
	private String data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	
	// Constructor
	public Sinistro (String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		this.ID = geraId();
		this.data = data;
		this.endereco = endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}
	
	// Getters e setters
	public int getID() {
		return ID;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// Gerar id
	private int geraId() {
		Random random = new Random();
		int idGerado = random.nextInt(1000);
		return idGerado;
	}
	
	@Override
	public String toString() {
		String out = "ID = " + getID() + "\n";
		out = out + "Data = " + getData() + "\n";
		out = out + "Endereço = " + getEndereco() + "\n";
		out = out + "Seguradora = " + getSeguradora().toStringSimples() + "\n";
		out = out + "Veículo:\n" + getVeiculo() + "\n";
		out = out + "Cliente:\n" + getCliente().toStringSimples() + "\n";
		return out;
	}
}
