
public class Main {
	public static void main(String[] args) {
		Veiculo veiculo = new Veiculo("BHK5Y62", "Ford", "Ranger");
		Cliente cliente = new Cliente("Ayla Machado", "466.534.108-70", "17/03/1999", 24, "Rua Roxo Moreira, 601 - Cidade Universitária, Campinas/SP");
		Seguradora seguradora = new Seguradora("Barão Seguros", "(19) 2651-6584", "seguradora@baraoseguros.com", "Av. Albino J. B. de Oliveira, 2615 - Santa Isabel, Campinas/SP");
		Sinistro sinistro = new Sinistro("28/03/2023", "Av. Professor Atílio Martini, 625 - Cidade Universitária, Campinas/SP");
		
		System.out.println("Veículo:\n" + veiculo);
		System.out.println("Cliente:\n" + cliente);
		System.out.println("Seguradora:\n" + seguradora);
		System.out.println("Sinistro:\n" + sinistro);
	}
}
