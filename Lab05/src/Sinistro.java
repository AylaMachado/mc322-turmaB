import java.util.Date;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Sinistro {
	private final int ID;
	private Date data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;
	
	// Constructor
	public Sinistro (Date data, String endereco, Condutor condutor, Seguro seguro) {
		this.ID = geraId();
		this.data = data;
		this.endereco = endereco;
		this.condutor = condutor;
		this.seguro = seguro;
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

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
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
		out = out + "Condutor = " + getCondutor() + "\n";
		out = out + "Seguro:\n" + getSeguro() + "\n";
		return out;
	}
}
