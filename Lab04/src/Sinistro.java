import java.util.Date;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Sinistro {
	private final int ID;
	private Date data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	
	// Constructor
	public Sinistro (Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
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
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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
	
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String out;
		out = "ID = " + getID() + "\n";
		out = out + "Data = " + dateFormat.format(getData()) + "\n";
		out = out + "Endereço = " + getEndereco() + "\n";
		out = out + "Seguradora = " + getSeguradora().toStringSimples() + "\n";
		out = out + "Veículo:\n" + getVeiculo() + "\n";
		out = out + "Cliente:\n" + getCliente().toStringSimples() + "\n";
		return out;
	}
}
