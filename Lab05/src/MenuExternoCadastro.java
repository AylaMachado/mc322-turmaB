
public enum MenuExternoCadastro {
	CADASTRAR_CLIENTE_PF(1),
	CADASTRAR_CLIENTE_PJ(2),
	CADASTRAR_VEICULO_PF(3),
	CADASTRAR_VEICULO_PJ(4),
	CADASTRAR_FROTA(5),
	CADASTRAR_SEGURADORA(6),
	VOLTAR(7),
	CONTINUE(8);
	
	public final int operacao;
	
	MenuExternoCadastro (int operacao) {
		this.operacao = operacao;
	}
	
	public int getOperacao () {
		return operacao;
	}
}
