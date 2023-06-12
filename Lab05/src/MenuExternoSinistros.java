
public enum MenuExternoSinistros {
	GERAR_SINISTRO(1),
	CANCELAR_SINISTRO(2),
	VOLTAR(3),
	CONTINUE(4);
	
	public final int operacao;
	
	MenuExternoSinistros (int operacao) {
		this.operacao = operacao;
	}
	
	public int getOperacao () {
		return operacao;
	}
}
