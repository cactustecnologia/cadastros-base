package br.com.cactus.cadastros.model;

public enum TipoRegime {
	
	FISICO("Físico"), JURIDICO("Jurídico");
	
	private String descricao;

	TipoRegime(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
