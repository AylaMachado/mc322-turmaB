import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public abstract class Seguro {
	protected final int ID;
	protected Date dataInicio;
	protected Date dataFim;
	protected Seguradora seguradora;
	protected List<Sinistro> listaSinistros;
	protected List<Condutor> listaCondutores;
	protected double valorMensal;
	protected Cliente cliente;
	
	// Constructor
	public Seguro (Date dataInicio, Date dataFim, Seguradora seguradora, List<Sinistro> listaSinistros, 
			List<Condutor> listaCondutores) {
		this.ID = geraId();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.seguradora = seguradora;
		this.listaSinistros = listaSinistros;
		this.listaCondutores = listaCondutores;
		this.valorMensal = 0;
	}
	
	// Getters e setters
	public int getID() {
		return ID;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public List<Sinistro> getListaSinistros() {
		return listaSinistros;
	}

	public void setListaSinistros(List<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}

	public List<Condutor> getListaCondutores() {
		return listaCondutores;
	}

	public void setListaCondutores(List<Condutor> listaCondutores) {
		this.listaCondutores = listaCondutores;
	}

	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// Gerar id
	private int geraId() {
		Random random = new Random();
		int idGerado = random.nextInt(1000);
		return idGerado;
	}
	
	public abstract boolean desautorizarCondutor(Condutor condutor);
	
	public abstract boolean autorizarCondutor(Condutor condutor);
	
	public abstract double calcularValor(List<Veiculo> listaVeiculos, Condutor condutor);
	
	public abstract boolean gerarSinistro(Sinistro sinistro);
	
	public abstract boolean cancelarSinistro(Sinistro sinistro);
	
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
		out = out + "Cliente = " + getCliente() + "\n";
		return out;
	}
}
