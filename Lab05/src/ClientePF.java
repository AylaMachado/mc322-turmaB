import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ClientePF extends Cliente {
	private final String CPF;
	private String genero;
	private String educacao;
	private Date dataNascimento;
	private List<Veiculo> listaVeiculos;

	// Constructor
	public ClientePF(String CPF, String genero, String educacao, Date dataNascimento, List<Veiculo> listaVeiculos, String nome, 
			String telefone, String endereco, String email) {
		super(nome, telefone, endereco, email);
		this.CPF = CPF;
		this.genero = genero;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.listaVeiculos = listaVeiculos;
	}

	// Getters e setters
	public String getCPF() {
		return CPF;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	// Adicionar um veiculo
	public boolean cadastrarVeiculo(Veiculo veiculo) {
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
		out = out + "Genero = " + getGenero() + "\n";
		out = out + "Educação = " + getEducacao() + "\n";
		out = out + "Data de Nascimento = " + dateFormat.format(getDataNascimento()) + "\n";
		out = out + "Lista de Veiculos: \n\n";
		for (int i = 0; i < this.listaVeiculos.size(); i++) {
			out = out + "-- Veículo " + (i+1) + " --\n";
			out = out + this.listaVeiculos.get(i) + "\n";
		}
		return out;
	}
}
