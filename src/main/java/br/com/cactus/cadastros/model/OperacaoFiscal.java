package br.com.cactus.cadastros.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "tribut_operacao_fiscal")
public class OperacaoFiscal implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	private String descricaoNaNf;
	private Integer cfop;
	private String observacao;
	
	private Empresa empresa;

	
	//getter and setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@NotNull
	public String getDescricaoNaNf() {
		return descricaoNaNf;
	}

	public void setDescricaoNaNf(String descricaoNaNf) {
		this.descricaoNaNf = descricaoNaNf;
	}

	@NotBlank
	@Column(nullable = false, length = 10)
	public Integer getCfop() {
		return cfop;
	}

	public void setCfop(Integer cfop) {
		this.cfop = cfop;
	}

	@NotNull
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@NotNull
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
