import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SeguroPF extends Seguro {
	private Veiculo veiculo;
	private ClientePF cliente;

	// Constructor
	public SeguroPF(Veiculo veiculo, ClientePF cliente, Date dataInicio, Date dataFim, Seguradora seguradora, 
			List<Sinistro> listaSinistros, List<Condutor> listaCondutores) {
			super(dataInicio, dataFim, seguradora, listaSinistros, listaCondutores);
			this.veiculo = veiculo;
			this.cliente = cliente;
	}

	// Getters e setters
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setFrota(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	@Override
	public ClientePF getCliente() {
		return cliente;
	}

	public void setCliente(ClientePF cliente) {
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
	
	//Calcular seguro
	@Override
	public double calcularValor(List<Veiculo> listaVeiculos, Condutor condutor) {
		double valor = 0;
		int idade = calculaIdade(cliente.getDataNascimento());
		int qtdVeiculos = listaVeiculos.size();
		int qtdSinistrosCliente = condutor.getListaSinistros().size();
		int qtdSinistrosCondutor = this.getListaSinistros().size();
		
		CalcSeguro valorBase = CalcSeguro.VALOR_BASE;
		CalcSeguro fator1 = CalcSeguro.FATOR_18_30;
		CalcSeguro fator2 = CalcSeguro.FATOR_30_60;
		CalcSeguro fator3 = CalcSeguro.FATOR_60_90;
		
		if (idade >= 18 && idade <= 30)
			valor = valorBase.fator * fator1.fator * (1+1/(qtdVeiculos+2)) * (2+qtdSinistrosCliente/10) * 
				(5+qtdSinistrosCondutor/10);
		else if (idade > 30 && idade <= 60)
			valor = valorBase.fator * fator2.fator * (1+1/(qtdVeiculos+2)) * (2+qtdSinistrosCliente/10) * 
				(5+qtdSinistrosCondutor/10);
		else if (idade > 60 && idade <= 90)
			valor = valorBase.fator * fator3.fator * (1+1/(qtdVeiculos+2)) * (2+qtdSinistrosCliente/10) * 
				(5+qtdSinistrosCondutor/10);
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
		out = out + "Veiculo = " + getVeiculo() + "\n";
		out = out + "Cliente = " + getCliente() + "\n";
		return out;
	}
}
