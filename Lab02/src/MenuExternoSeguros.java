
public enum MenuExternoSeguros {
	GERAR_SEGURO(1),
	CANCELAR_SEGURO(2),
	VOLTAR(3),
	CONTINUE(4);
	
	public final int operacao;
	
	MenuExternoSeguros (int operacao) {
		this.operacao = operacao;
	}
	
	public int getOperacao () {
		return operacao;
	}

}
