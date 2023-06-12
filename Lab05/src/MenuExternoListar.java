
public enum MenuExternoListar {
	LISTAR_CLIENTES_SEGURADORA_PF(1),
	LISTAR_CLIENTES_SEGURADORA_PJ(2),
	LISTAR_SINISTROS_SEGURADORA(3),
	LISTAR_SEGUROS_CLIENTE(4),
	LISTAR_SINISTROS_CLIENTE(5),
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