package br.com.cactus.cadastros.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "plano_conta_ref_sped")
public class PlanoContaRefSped implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String codCtaRef;
	private String descricao;
	private String orientacoes;
	private Date inicioValidade;
	private Date fimValidade;
	private String tipo;
	
	
	//getter and setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@NotBlank
	@Column(nullable = false, length = 30)
	public String getCodCtaRef() {
		return codCtaRef;
	}
	
	public void setCodCtaRef(String codCtaRef) {
		this.codCtaRef = codCtaRef;
	}
	
	@NotBlank
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@NotNull
	public String getOrientacoes() {
		return orientacoes;
	}
	
	public void setOrientacoes(String orientacoes) {
		this.orientacoes = orientacoes;
	}
	
	@NotNull
	public Date getInicioValidade() {
		return inicioValidade;
	}
	
	public void setInicioValidade(Date inicioValidade) {
		this.inicioValidade = inicioValidade;
	}
	
	@NotNull
	public Date getFimValidade() {
		return fimValidade;
	}
	
	public void setFimValidade(Date fimValidade) {
		this.fimValidade = fimValidade;
	}
	
	@NotBlank
	@Column(nullable = false, length = 1)
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
