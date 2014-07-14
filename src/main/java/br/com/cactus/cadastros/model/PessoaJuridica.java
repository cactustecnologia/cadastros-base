package br.com.cactus.cadastros.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;    
    private String cnpj;    
    private String fantasia;    
    private String inscricaoMunicipal;    
    private String inscricaoEstadual;    
    private Date dataConstituicao;    
    private TipoRegime tipoRegime;    
    private TipoCrt tipoCrt;    
    private String suframa;    
    private Pessoa pessoa;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@NotBlank
	@Column(nullable = false, length = 14)
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@NotBlank
	@Column(nullable = false, length = 150)
	public String getFantasia() {
		return fantasia;
	}
	
	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}
	
	@NotNull
	@Column(nullable = false, length = 30)
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}
	
	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}
	
	@NotNull
	@Column(nullable = false, length = 30)
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	
	public Date getDataConstituicao() {
		return dataConstituicao;
	}
	
	public void setDataConstituicao(Date dataConstituicao) {
		this.dataConstituicao = dataConstituicao;
	}	
	
	@Column(nullable = false, length = 9)
	public String getSuframa() {
		return suframa;
	}
	
	public void setSuframa(String suframa) {
		this.suframa = suframa;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_pessoa", nullable = false)
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@NotNull	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public TipoRegime getTipoRegime() {
		return tipoRegime;
	}

	public void setTipoRegime(TipoRegime tipoRegime) {
		this.tipoRegime = tipoRegime;
	}

	@NotNull	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public TipoCrt getTipoCrt() {
		return tipoCrt;
	}

	public void setTipoCrt(TipoCrt tipoCrt) {
		this.tipoCrt = tipoCrt;
	}
}
