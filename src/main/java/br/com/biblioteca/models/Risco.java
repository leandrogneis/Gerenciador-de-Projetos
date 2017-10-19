package br.com.biblioteca.models;

public enum Risco {
	
	BAIXO("Baixo Risco"),
	MEDIO("Médio Risco"), 
	ALTO("Alto Risco");
	
	private String descricao;
	
	Risco(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}