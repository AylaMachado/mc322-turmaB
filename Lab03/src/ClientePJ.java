import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente {
	private final String CNPJ;
	private Date dataFundacao;
	
	// Constructor
	public ClientePJ (String CNPJ, Date dataFundacao, String nome, String endereco, List<Veiculo> listaVeiculos) {
		super(nome, endereco, listaVeiculos);
		this.CNPJ = CNPJ;
		this.dataFundacao = dataFundacao;
	}
	
	// Getters e setters
	public String getCNPJ() {
		return CNPJ;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	// Verificar se todos os dígitos do CNPJ são iguais
	private boolean digitosIguais(String cnpj) {
		for (int i = 0; i < cnpj.length() - 1; i++) {
			char caractere1 = cnpj.charAt(i);
			char caractere2 = cnpj.charAt(i + 1);
			if (caractere1 != caractere2)
				return true;
		}
		return false;
	}

	// Calcular os dígitos verificadores do CNPJ
	private int calculaDigito(String cnpj) {
		int soma, resto, peso, digito, teste;
		String dig;

		soma = 0;
		peso = 2;
		for (int i = 11; i >= 0; i--) {
			soma = soma + (cnpj.charAt(i)-48) * peso;
			peso = peso + 1;
			if (peso == 10)
				peso = 2;
		}
		
		resto = soma % 11;
		if ((resto == 0) || (resto == 1))
			digito = 0;
		else
			digito = 11 - resto;
		dig = digito + "";
		
		soma = 0;
		peso = 2;
		for (int i = 12; i >= 0; i--) {
			soma = soma + (cnpj.charAt(i)-48) * peso;
			peso = peso + 1;
			if (peso == 10)
				peso = 2;
		}

		resto = soma % 11;
		if ((resto == 0) || (resto == 1))
			digito = 0;
		else
			digito = 11 - resto;
		dig = dig + digito;
		
		digito = Integer.parseInt(dig);
		return digito;
	}

	// Validar o CNPJ do cliente
	public boolean validarCNPJ(String cnpj) {
		cnpj = cnpj.replaceAll("[^0-9]+", "");
		if (cnpj.length() != 14)
			return false;
		else if (!digitosIguais(cnpj))
			return false;
		
		else if (calculaDigito(cnpj) != Integer.parseInt(cnpj.substring(12, 14)))
			return false;

		return true;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String out;
		out = "Nome = " + getNome() + "\n";
		out = out + "Endereço = " + getEndereco() + "\n";
		if (validarCNPJ(CNPJ))
			out = out + "CNPJ = " + getCNPJ() + "\n";
		else
			out = out + "CNPJ = Número inválido \n";
		out = out + "Data da Fundação = " + formatter.format(getDataFundacao()) + "\n";
		out = out + "Lista de Veículos: \n\n";
		for (int i = 0; i < this.listaVeiculos.size(); i++) {
			out = out + "-- Veículo " + (i+1) + " --\n";
			out = out + this.listaVeiculos.get(i) + "\n";
		}
		return out;
	}
}
