
public enum MenuExternoExcluir {
	EXCLUIR_CLIENTE_PF(1),
	EXCLUIR_CLIENTE_PJ(2),
	EXCLUIR_VEICULO_PF(3),
	EXCLUIR_VEICULO_PJ(4),
	EXCLUIR_FROTA(5),
	EXCLUIR_SEGURADORA(6),
	VOLTAR(7),
	CONTINUE(8);
	
	public final int operacao;
	
	MenuExternoExcluir (int operacao) {
		this.operacao = operacao;
	}
	
	public int getOperacao () {
		return operacao;
	}
}
