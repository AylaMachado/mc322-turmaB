
public enum MenuOperacoes {
	CADASTRAR(1),
	LISTAR(2),
	EXCLUIR(3),
	GERAR_SINISTRO(4),
	TRANSFERIR_SEGURO(5),
	CALCULAR_RECEITA(6),
	CONTINUE(7),
	SAIR(0);
	
	public final double operacao;
	
	MenuOperacoes (double operacao) {
		this.operacao = operacao;
	}
	
	public double getOperacao () {
		return operacao;
	}
}
