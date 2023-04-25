import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ClientePF extends Cliente {
	private final String CPF;
	private String genero;
	private Date dataLicenca;
	private String educacao;
	private Date dataNascimento;
	private String classeEconomica;

	// Constructor
	public ClientePF(String CPF, String genero, Date dataLicenca, String educacao, Date dataNascimento,
			String classeEconomica, String nome, String endereco, List<Veiculo> listaVeiculos) {
		super(nome, endereco, listaVeiculos);
		this.CPF = CPF;
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.classeEconomica = classeEconomica;
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

	public Date getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
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

	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}

	// Verificar se todos os dígitos do CPF são iguais
	private boolean digitosIguais(String cpf) {
		for (int i = 0; i < cpf.length() - 1; i++) {
			char caractere1 = cpf.charAt(i);
			char caractere2 = cpf.charAt(i + 1);
			if (caractere1 != caractere2)
				return true;
		}
		return false;
	}

	// Calcular os dígitos verificadores do CPF
	private int calculaDigito(String cpf) {
		int soma = 0, resto = 0, digito;
		String dig;

		for (int i = 1; i <= 9; i++) {
			soma = soma + Integer.parseInt(cpf.substring(i - 1, i)) * (11 - i);
			resto = (soma * 10) % 11;
		}

		if ((resto == 10) || (resto == 11))
			resto = 0;
		digito = resto;

		soma = 0;
		for (int i = 1; i <= 10; i++) {
			soma = soma + Integer.parseInt(cpf.substring(i - 1, i)) * (12 - i);
			resto = (soma * 10) % 11;
		}

		if ((resto == 10) || (resto == 11))
			resto = 0;
		dig = digito + "" + resto;
		digito = Integer.parseInt(dig);

		return digito;
	}

	// Validar o CPF do cliente
	public boolean validarCPF(String cpf) {
		cpf = cpf.replaceAll("[^0-9]+", "");
		if (cpf.length() != 11)
			return false;
		else if (!digitosIguais(cpf))
			return false;
		else if (calculaDigito(cpf) != Integer.parseInt(cpf.substring(9, 11)))
			return false;

		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String out;
		out = "Nome = " + getNome() + "\n";
		out = out + "Endereço = " + getEndereco() + "\n";
		if (validarCPF(CPF))
			out = out + "CPF = " + getCPF() + "\n";
		else
			out = out + "CPF = Número inválido \n";
		out = out + "Genero = " + getGenero() + "\n";
		out = out + "Data da Licença = " + formatter.format(getDataLicenca()) + "\n";
		out = out + "Educação = " + getEducacao() + "\n";
		out = out + "Data de Nascimento = " + formatter.format(getDataNascimento()) + "\n";
		out = out + "Classe Econômica = " + getClasseEconomica() + "\n";
		out = out + "Lista de Veículos: \n\n";
		for (int i = 0; i < this.listaVeiculos.size(); i++) {
			out = out + "-- Veículo " + (i+1) + " --\n";
			out = out + this.listaVeiculos.get(i) + "\n";
		}
		return out;
	}
}
