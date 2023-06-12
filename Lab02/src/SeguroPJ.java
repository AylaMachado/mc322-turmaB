import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SeguroPJ extends Seguro{
	private Frota frota;
	private ClientePJ cliente;

	// Constructor
	public SeguroPJ(Frota frota, ClientePJ cliente, Date dataInicio, Date dataFim, Seguradora seguradora, 
			List<Sinistro> listaSinistros, List<Condutor> listaCondutores) {
			super(dataInicio, dataFim, seguradora, listaSinistros, listaCondutores);
			this.frota = frota;
			this.cliente = cliente;
	}

	// Getters e setters
	public Frota getFrota() {
		return frota;
	}
	
	public void setFrota(Frota frota) {
		this.frota = frota;
	}

	@Override
	public ClientePJ getCliente() {
		return cliente;
	}

	public void setCliente(ClientePJ cliente) {
		this.cliente = cliente;
	}

	// Autorizar condutor
	public boolean autorizarCondutor(Condutor condutor) {
		if (listaCondutores.add(condutor))
			return true;
		return false;
	}

	// Desautorizar condutor
	public boolean desautorizarCondutor(Condutor condutor) {
		if (listaCondutores.remove(condutor))
			return true;
		return false;
	}
	
	// Gerar um sinistro
	public boolean gerarSinistro(Sinistro sinistro) {
		if (listaSinistros.add(sinistro)) {
			System.out.println("Sinistro gerado:\n");
			return true;
		}
		return false;
	}
	
	// Remover um sinistro
	public boolean cancelarSinistro(Sinistro sinistro) {
		if (listaSinistros.remove(sinistro)) {
			System.out.println("Sinistro cancelado:\n");
			System.out.println(sinistro);
			return true;
		}
		return false;
	}
	
	public int calculaFundacao(Date dataFundacao) {
		Date date = new Date();
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		SimpleDateFormat month = new SimpleDateFormat("MM");
		SimpleDateFormat day = new SimpleDateFormat("dd");
		int idadeFundacao, anoAtual, anoNasc, mesAtual, mesNasc, diaAtual, diaNasc;
		
		anoAtual = Integer.parseInt(year.format(date));
	    anoNasc = Integer.parseInt(year.format(dataFundacao));
	    mesAtual = Integer.parseInt(month.format(date));
	    mesNasc = Integer.parseInt(month.format(dataFundacao));
	    diaAtual = Integer.parseInt(day.format(date));
	    diaNasc = Integer.parseInt(day.format(dataFundacao));
	    idadeFundacao = anoAtual - anoNasc;
	    
	    if((mesAtual < mesNasc) || (mesAtual == mesNasc && diaAtual < diaNasc))
	    	idadeFundacao--;
		return idadeFundacao;
	}

	@Override
	public double calcularValor(List<Veiculo> listaVeiculos, Condutor condutor) {
		double valor;
		int qtdVeiculos = listaVeiculos.size();
		int anosPosFundacao = calculaFundacao(cliente.getDataFundacao());
		int qtdSinistrosCliente = condutor.getListaSinistros().size();
		int qtdSinistrosCondutor = this.getListaSinistros().size();
		CalcSeguro valorBase = CalcSeguro.VALOR_BASE;
		
		valor = valorBase.fator * (10+cliente.getQtdFuncionarios()/10) * (1+1/(qtdVeiculos+2)) * (1+1/(anosPosFundacao+2)) *
				(2+qtdSinistrosCliente/10) * (5+qtdSinistrosCondutor/10);	
		return valor;
	}
	
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String out;
		out = "ID = " + getID() + "\n";
		out = out + "Data de Início = " + dateFormat.format(getDataInicio()) + "\n";
		out = out + "Data Final = " + dateFormat.format(getDataFim()) + "\n";
		out = out + "Seguradora:\n" + getSeguradora().toStringSimples() + "\n";
		out = out + "Lista de Sinistros = " + getListaSinistros() + "\n";
		out = out + "Lista de Condutores = " + getListaCondutores() + "\n";
		out = out + "Valor Mensal = " + NumberFormat.getCurrencyInstance().format(getValorMensal()) + "\n";
		out = out + "Frota = " + getFrota() + "\n";
		out = out + "Cliente = " + getCliente() + "\n";
		return out;
	}
}
