package br.com.cactus.cadastros.model;

public enum TipoCrt {
	
	FISICO("Físico"), JURIDICO("Jurídico");
	
	private String descricao;

	TipoCrt(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
