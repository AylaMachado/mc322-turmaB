import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Condutor {
	private final String CPF;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private Date dataNascimento;
	private List<Sinistro> listaSinistros;
	
	// Constructor
	public Condutor(String CPF, String nome, String telefone, String endereco, String email, Date dataNascimento,
			List<Sinistro> listaSinistros) {
		this.CPF = CPF;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.listaSinistros = listaSinistros;
	}

	// Getters e setters
	public String getCPF() {
		return CPF;
	}
	
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Sinistro> getListaSinistros() {
		return listaSinistros;
	}

	public void setListaSinistros(List<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}

	// Adicionar um sinistro
	public boolean adicionarSinistro(Sinistro sinistro) {
		if (listaSinistros.add(sinistro))
			return true;
		return false;
	}
	
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String out;
		if (Validacao.validaNome(nome))
			out = "Nome = " + getNome() + "\n";
		else
			out = "Nome = Inválido \n";
		out = out + "Telefone = " + getTelefone() + "\n";
		out = out + "Endereço = " + getEndereco() + "\n";
		out = out + "Email = " + getEmail() + "\n";
		if (Validacao.validaCPF(CPF))
			out = out + "CPF = " + getCPF() + "\n";
		else
			out = out + "CPF = Número inválido \n";
		out = out + "Data de Nascimento = " + dateFormat.format(getDataNascimento()) + "\n";
		out = out + "Lista de Sinistros: \n\n";
		for (int i = 0; i < this.listaSinistros.size(); i++) {
			out = out + "-- Sinistro " + (i+1) + " --\n";
			out = out + this.listaSinistros.get(i) + "\n";
		}
		return out;
	}
}
