package br.com.cactus.cadastros.model;

public enum TipoRegime {
	
	FISICA("Física"), JURIDICA("Jurídica");
	
	private String descricao;

	TipoRegime(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
