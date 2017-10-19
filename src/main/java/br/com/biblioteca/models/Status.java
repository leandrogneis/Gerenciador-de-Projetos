package br.com.biblioteca.models;

public enum Status {

	EM_ANALISE("Em análise"), 
	ANALISE_REALIZADA("Análise realizada"), 
	ANALISE_APROVADA("Análise aprovada"),
	INICIADO("Iniciado"), 
	PLANEJADO("Planejado"),
	EM_ANDAMENTO("Em andamento"), 
	ENCERRADO("Encerrado"),
	CANCELADO("Cancelado");
	
	private String descricao;
	
	Status(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}