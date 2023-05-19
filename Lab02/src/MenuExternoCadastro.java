
public enum MenuExternoCadastro {
	CADASTRAR_CLIENTE_PF_PJ(1),
	CADASTRAR_VEICULO(2),
	CADASTRAR_SEGURADORA(3),
	VOLTAR(4),
	CONTINUE(5);
	
	public final int operacao;
	
	MenuExternoCadastro (int operacao) {
		this.operacao = operacao;
	}
	
	public int getOperacao () {
		return operacao;
	}
}
