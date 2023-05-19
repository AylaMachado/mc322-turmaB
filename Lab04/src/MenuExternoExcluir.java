
public enum MenuExternoExcluir {
	EXCLUIR_CLIENTE(1),
	EXCLUIR_VEICULO(2),
	EXCLUIR_SINISTRO(3),
	VOLTAR(4),
	CONTINUE(5);
	
	public final int operacao;
	
	MenuExternoExcluir (int operacao) {
		this.operacao = operacao;
	}
	
	public int getOperacao () {
		return operacao;
	}
}
