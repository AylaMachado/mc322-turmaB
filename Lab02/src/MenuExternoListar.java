
public enum MenuExternoListar {
	LISTAR_CLIENTES_SEGURADORA(1),
	LISTAR_SINISTROS_SEGURADORA(2),
	LISTAR_SINISTROS_CLIENTE(3),
	LISTAR_VEICULOS_CLIENTE(4),
	LISTAR_VEICULOS_SEGURADORA(5),
	VOLTAR(6),
	CONTINUE(7);
	
	public final int operacao;
	
	MenuExternoListar (int operacao) {
		this.operacao = operacao;
	}
	
	public int getOperacao () {
		return operacao;
	}
}