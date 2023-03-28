import java.util.Random;

public class Sinistro {
	private int id;
	private String data;
	private String endereco;
	
	// Constructor
	public Sinistro (String data, String endereco) {
		this.id = geraId();
		this.data = data;
		this.endereco = endereco;
	}
	
	// Getters e setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	// Função para gerar o Id
	private int geraId() {
		Random random = new Random();
		int idGerado = random.nextInt(1000);
		return idGerado;
	}
	
	// Função para retornar uma representação string do objeto Sinistro
	@Override
	public String toString() {
		String out = "Id = " + getId() + "\n";
		out = out + "Data = " + getData() + "\n";
		out = out + "Endereço = " + getEndereco() + "\n";
		return out;
	}
}
