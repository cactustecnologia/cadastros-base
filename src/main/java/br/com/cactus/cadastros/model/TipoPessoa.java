package br.com.cactus.cadastros.model;

public enum TipoPessoa {
	
	FISICO("Físico"), JURIDICO("Jurídico");
	
	private String descricao;

	TipoPessoa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
