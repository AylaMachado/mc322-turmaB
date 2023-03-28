
public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	// Constructor
	public Cliente (String nome, String cpf, String dataNascimento, int idade, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.endereco = endereco;
	}

	// Getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	// Função para verificar se todos os dígitos do CPF são iguais
	private boolean digitosIguais(String cpf) {
		for (int i=0; i < cpf.length()-1; i++) {
			char caractere1 = cpf.charAt(i);
			char caractere2 = cpf.charAt(i+1);
			if(caractere1 != caractere2)
				return true;
		}
		return false;
	}
	
	// Função para calcular os dígitos verificadores do CPF
	private int calculaDigito(String cpf) {
		int soma = 0, resto = 0, digito;
		String dig;
	
		for (int i=1; i<=9; i++) {
			soma = soma + Integer.parseInt(cpf.substring(i-1, i)) * (11 - i);
			resto = (soma * 10) % 11;
		} 
	
		if ((resto == 10) || (resto == 11))
			resto = 0;
		digito = resto;
		
		soma = 0;
		for (int i = 1; i <= 10; i++) {
			soma = soma + Integer.parseInt(cpf.substring(i-1, i)) * (12 - i);
			resto = (soma * 10) % 11;
		}
		
		if ((resto == 10) || (resto == 11)) 
			resto = 0;
		dig = digito + "" + resto;
		digito = Integer.parseInt(dig);
		
		return digito;
	}
	
	// Função para validar o CPF do cliente
	private boolean validarCPF(String cpf) {
		cpf = cpf.replaceAll("[^0-9]+", "");
		if (cpf.length() != 11)
			return false;
		else if (!digitosIguais(cpf))
			return false;
		else if (calculaDigito(cpf) != Integer.parseInt(cpf.substring(9, 11)))
			return false;
		
		return true;
	}
	
	// Função para retornar uma representação string do objeto Cliente
	@Override
	public String toString() {
		String out = "Nome = " + getNome() + "\n";
		if (validarCPF(cpf))
			out = out + "CPF = " + getCpf() + "\n";
		else
			out = out + "CPF = Número inválido \n";
		out = out + "Data de Nascimento = " + getDataNascimento() + "\n";
		out = out + "Idade = " + getIdade() + "\n";
		out = out + "Endereço = " + getEndereco() + "\n";
		return out;
	}
}
