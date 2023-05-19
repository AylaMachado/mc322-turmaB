import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente {
	private final String CNPJ;
	private Date dataFundacao;
	private int qtdeFuncionarios;

	// Constructor
	public ClientePJ(String CNPJ, Date dataFundacao, int qtdeFuncionarios, String nome, String endereco,
			List<Veiculo> listaVeiculos) {
		super(nome, endereco, listaVeiculos);
		this.CNPJ = CNPJ;
		this.dataFundacao = dataFundacao;
		this.qtdeFuncionarios = qtdeFuncionarios;
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

	public int getQtdeFuncionarios() {
		return qtdeFuncionarios;
	}

	public void setQtdeFuncionarios(int qtdeFuncionarios) {
		this.qtdeFuncionarios = qtdeFuncionarios;
	}

	public double calculaScore(List<Veiculo> listaVeiculos) {
		double score;
		int quantidadeCarros = listaVeiculos.size();
		CalcSeguro valorBase = CalcSeguro.VALOR_BASE;
		
		score = valorBase.fator * (1 + ((double) qtdeFuncionarios)/100) * quantidadeCarros;
		return score;
	}

	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String out;
		if (Validacao.validaNome(nome))
			out = "Nome = " + getNome() + "\n";
		else
			out = "Nome = Inv�lido \n";
		out = out + "Endere�o = " + getEndereco() + "\n";
		out = out + "Valor do Seguro = " + NumberFormat.getCurrencyInstance().format(getValorSeguro()) + "\n";
		if (Validacao.validaCNPJ(CNPJ))
			out = out + "CNPJ = " + getCNPJ() + "\n";
		else
			out = out + "CNPJ = N�mero inv�lido \n";
		out = out + "Data da Funda��o = " + dateFormat.format(getDataFundacao()) + "\n";
		out = out + "Quantidade de Funcion�rios = " + getQtdeFuncionarios() + "\n";
		out = out + "Lista de Ve�culos: \n\n";
		for (int i = 0; i < this.listaVeiculos.size(); i++) {
			out = out + "-- Ve�culo " + (i + 1) + " --\n";
			out = out + this.listaVeiculos.get(i) + "\n";
		}
		return out;
	}
}
