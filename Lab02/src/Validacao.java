
public class Validacao {
	// Verificar se todos os dígitos do CPF ou CNPJ são iguais
	private static boolean digitosIguais(String documento) {
		for (int i = 0; i < documento.length() - 1; i++) {
			char caractere1 = documento.charAt(i);
			char caractere2 = documento.charAt(i + 1);
			if (caractere1 != caractere2)
				return true;
		}
		return false;
	}

	// Calcular os dígitos verificadores do CPF
	private static int calculaDigitoCPF(String cpf) {
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
	
	// Calcular os dígitos verificadores do CNPJ
	private static int calculaDigitoCNPJ(String cnpj) {
		int soma, resto, peso, digito;
		String dig;

		soma = 0;
		peso = 2;
		for (int i = 11; i >= 0; i--) {
			soma = soma + (cnpj.charAt(i) - 48) * peso;
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
			soma = soma + (cnpj.charAt(i) - 48) * peso;
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

	// Validar o CPF do cliente
	public static boolean validaCPF(String cpf) {
		cpf = cpf.replaceAll("[^0-9]+", "");
		if (cpf.length() != 11)
			return false;
		else if (!digitosIguais(cpf))
			return false;
		else if (calculaDigitoCPF(cpf) != Integer.parseInt(cpf.substring(9, 11)))
			return false;

		return true;
	}

	// Validar o CNPJ do cliente
	public static boolean validaCNPJ(String cnpj) {
		cnpj = cnpj.replaceAll("[^0-9]+", "");
		if (cnpj.length() != 14)
			return false;
		else if (!digitosIguais(cnpj))
			return false;

		else if (calculaDigitoCNPJ(cnpj) != Integer.parseInt(cnpj.substring(12, 14)))
			return false;

		return true;
	}
	
	// Validar o nome do cliente
	public static boolean validaNome(String nome) {
		if (Character.isAlphabetic((nome.charAt(0))) && Character.isAlphabetic((nome.charAt(nome.length() - 1)))) 
		    return true;
		return false;
	}
}
