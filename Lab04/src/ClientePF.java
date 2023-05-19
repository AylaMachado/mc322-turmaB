import java.text.DateFormat;
import java.text.NumberFormat;
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
	
	public int calculaIdade(Date dataNascimento) {
		Date date = new Date();
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		SimpleDateFormat month = new SimpleDateFormat("MM");
		SimpleDateFormat day = new SimpleDateFormat("dd");
		int idade, anoAtual, anoNasc, mesAtual, mesNasc, diaAtual, diaNasc;
		
		anoAtual = Integer.parseInt(year.format(date));
	    anoNasc = Integer.parseInt(year.format(dataNascimento));
	    mesAtual = Integer.parseInt(month.format(date));
	    mesNasc = Integer.parseInt(month.format(dataNascimento));
	    diaAtual = Integer.parseInt(day.format(date));
	    diaNasc = Integer.parseInt(day.format(dataNascimento));
	    idade = anoAtual - anoNasc;
	    
	    if((mesAtual < mesNasc) || (mesAtual == mesNasc && diaAtual < diaNasc))
	        idade--;
		return idade;
	}
	
	public double calculaScore(List<Veiculo> listaVeiculos) {
		double score = 0;
		int idade = calculaIdade(this.dataNascimento);
		int quantidadeCarros = listaVeiculos.size();
		
		CalcSeguro valorBase = CalcSeguro.VALOR_BASE;
		CalcSeguro fator1 = CalcSeguro.FATOR_18_30;
		CalcSeguro fator2 = CalcSeguro.FATOR_30_60;
		CalcSeguro fator3 = CalcSeguro.FATOR_60_90;
		
		if (idade >= 18 && idade <= 30)
			score = valorBase.fator * fator1.fator * quantidadeCarros;
		else if (idade > 30 && idade <= 60)
			score = valorBase.fator * fator2.fator * quantidadeCarros;
		else if (idade > 60 && idade <= 90)
			score = valorBase.fator * fator3.fator * quantidadeCarros;
		return score;
	}

	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String out;
		if (Validacao.validaNome(nome))
			out = "Nome = " + getNome() + "\n";
		else
			out = "Nome = Inválido \n";
		out = out + "Endereço = " + getEndereco() + "\n";
		out = out + "Valor do Seguro = " + NumberFormat.getCurrencyInstance().format(getValorSeguro()) + "\n";
		if (Validacao.validaCPF(CPF))
			out = out + "CPF = " + getCPF() + "\n";
		else
			out = out + "CPF = Número inválido \n";
		out = out + "Genero = " + getGenero() + "\n";
		out = out + "Data da Licença = " + dateFormat.format(getDataLicenca()) + "\n";
		out = out + "Educação = " + getEducacao() + "\n";
		out = out + "Data de Nascimento = " + dateFormat.format(getDataNascimento()) + "\n";
		out = out + "Classe Econômica = " + getClasseEconomica() + "\n";
		out = out + "Lista de Veículos: \n\n";
		for (int i = 0; i < this.listaVeiculos.size(); i++) {
			out = out + "-- Veículo " + (i+1) + " --\n";
			out = out + this.listaVeiculos.get(i) + "\n";
		}
		return out;
	}
}
