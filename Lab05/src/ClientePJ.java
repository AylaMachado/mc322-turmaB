import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente {
	private final String CNPJ;
	private Date dataFundacao;
	private int qtdFuncionarios;
	private List<Frota> listaFrota;

	// Constructor
	public ClientePJ(String CNPJ, Date dataFundacao, int qtdFuncionarios, List<Frota> listaFrota, String nome, String telefone, 
			String endereco, String email) {
		super(nome, telefone, endereco, email);
		this.CNPJ = CNPJ;
		this.dataFundacao = dataFundacao;
		this.qtdFuncionarios = qtdFuncionarios;
		this.listaFrota = listaFrota;
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
	
	public int getQtdFuncionarios() {
		return qtdFuncionarios;
	}

	public void setQtdFuncionarios(int qtdFuncionarios) {
		this.qtdFuncionarios = qtdFuncionarios;
	}

	public List<Frota> getListaFrota() {
		return listaFrota;
	}

	public void setListaFrota(List<Frota> listaFrota) {
		this.listaFrota = listaFrota;
	}
	
	// Adicionar uma frota
	public boolean cadastrarFrota(Frota frota) {
		if (listaFrota.add(frota))
			return true;
		return false;
	}
	
	// Remover uma frota
		// O m�todo atualizarFrota() foi subtitu�do pelo removerFrota(), j� que os m�todos adicionarVeiculo() e removerVeiculo()
		// j� est�o presentes na classe Frota (alternativa discutida no laborat�rio)
	public boolean removerFrota(Frota frota) {
		if (listaFrota.remove(frota))
			return true;
		return false;
	}
	
	 // Listar veiculos por frota
	public void getVeiculosPorFrota(Frota frota) {
		System.out.println("--- Veiculos da frota: " + frota.getCode() + " ---\n");
		for (int i = 0; i < frota.getListaVeiculos().size(); i++) {
				System.out.println("-- Veiculo " + (i+1) + " --");
				System.out.println(frota.getListaVeiculos().get(i));
		}
    }

	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String out;
		if (Validacao.validaNome(nome))
			out = "Nome = " + getNome() + "\n";
		else
			out = "Nome = Inv�lido \n";
		out = out + "Telefone = " + getTelefone() + "\n";
		out = out + "Endere�o = " + getEndereco() + "\n";
		out = out + "Email = " + getEmail() + "\n";
		if (Validacao.validaCNPJ(CNPJ))
			out = out + "CNPJ = " + getCNPJ() + "\n";
		else
			out = out + "CNPJ = N�mero inv�lido \n";
		out = out + "Data da Funda��o = " + dateFormat.format(getDataFundacao()) + "\n";
		out = out + "Quantidade de Funcion�rios = " + getQtdFuncionarios() + "\n";
		out = out + "Lista da Frota: \n\n";
		for (int i = 0; i < this.listaFrota.size(); i++) {
			out = out + "-- Ve�culo " + (i+1) + " --\n";
			out = out + this.listaFrota.get(i) + "\n";
		}
		return out;
	}
}
